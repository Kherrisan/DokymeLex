package com.seu.cose.dokyme;

import edu.uci.ics.jung.algorithms.layout.CircleLayout;
import edu.uci.ics.jung.algorithms.layout.Layout;
import edu.uci.ics.jung.graph.DirectedGraph;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.util.EdgeType;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.decorators.ToStringLabeller;
import edu.uci.ics.jung.visualization.renderers.Renderer;


import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

/**
 * Created by zdksc on 2017/12/7.
 */
public class NoDefiniteAutomation {

    private enum PreprocessState {
        LAST_IS_CHAR, LAST_IS_R_BRACKET, LAST_IS_R_PARTNESS, LAST_IS_SINGLE, IN_BRACKET, LAST_IS_BINARY, START, IN_BRACKET_RANGE, IN_BRACKET_SINGLE
    }

    public DirectedGraph<State, Transition> graph;
    public State start;
    public State end;
    public RegularExpression re;

    public NoDefiniteAutomation() {
    }

    public NoDefiniteAutomation(char trans) {
        start = new State();
        State ml = new State();
        State mr = new State();
        end = new State();
        graph = new DirectedSparseMultigraph<>();
        graph.addEdge(new Transition(), start, ml, EdgeType.DIRECTED);
        graph.addEdge(new Transition(trans), ml, mr, EdgeType.DIRECTED);
        graph.addEdge(new Transition(), mr, end, EdgeType.DIRECTED);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        NoDefiniteAutomation newOne = new NoDefiniteAutomation();
        newOne.graph = new DirectedSparseGraph<>();
        newOne.start = new State();
        newOne.end = new State();
        return null;
    }

    /**
     * @return
     */
    public List<Character> getAllTransitionTag() {
        List<Character> characters = new ArrayList<>();
        for (Character c : re.re.toCharArray()) {
            if (!characters.contains(c) && !RegularExpression.operators.containsKey(c)) {
                characters.add(c);
            }
        }
        return characters;
    }

    /**
     * 在本NFA后连接一个NFA。
     *
     * @param next 下一个NFA。
     * @return 返回本NFA。
     */
    public NoDefiniteAutomation concat(NoDefiniteAutomation next) {
        for (State state : next.graph.getVertices()) {
            graph.addVertex(state);
            for (Transition edge : next.graph.getOutEdges(state)) {
                graph.addEdge(edge, state, next.graph.getDest(edge), EdgeType.DIRECTED);
            }
        }
        graph.addEdge(new Transition(), end, next.start);
        end = next.end;
        return this;
    }

    /**
     * 在本NFA上并列一个NFA。
     *
     * @param another 要并列的另一个NFA。
     * @return 本NFA。
     */
    public NoDefiniteAutomation parellize(NoDefiniteAutomation another) {
        for (State state : another.graph.getVertices()) {
            graph.addVertex(state);
            for (Transition edge : another.graph.getOutEdges(state)) {
                graph.addEdge(edge, state, another.graph.getDest(edge), EdgeType.DIRECTED);
            }
        }
        State newStart = new State();
        State newEnd = new State();
        graph.addEdge(new Transition(), start, another.start, EdgeType.DIRECTED);
        graph.addEdge(new Transition(), another.end, end, EdgeType.DIRECTED);
        graph.addEdge(new Transition(), newStart, start, EdgeType.DIRECTED);
        graph.addEdge(new Transition(), end, newEnd, EdgeType.DIRECTED);
        start = newStart;
        end = newEnd;
        return this;
    }

    public char getOnlyCharacter() {
        State temp = graph.getSuccessors(start).toArray(new State[]{})[0];
        return graph.getOutEdges(temp).toArray(new Transition[]{})[0].tag;
    }

    /**
     * 由输入的正则表达式，进行预处理后，利用tomhonson算法构造NFA的函数。
     *
     * @param re 输入的原始正则表达式。
     * @return 构造出来的NFA。
     */
    public static NoDefiniteAutomation build(RegularExpression re) {

        //预处理。
        Logger.debug("Raw input:" + re.re);
        re = prePreProcessor(re);
        Logger.debug("Added concat symbol and transform range format to or:" + re.re);
        re = infix2suffix(re);
        Logger.debug("Transform infix to suffix:" + re.re);

        //Tomphonson算法构造NFA。
        Stack<NoDefiniteAutomation> stack = new Stack<>();
        char[] characters = re.re.toCharArray();
        for (char cur : characters) {
            switch (cur) {
                case '~': {
                    NoDefiniteAutomation last = stack.pop();
                    NoDefiniteAutomation lastTwo = stack.pop();
                    stack.push(lastTwo.concat(last));
                    break;
                }
                case '*': {
                    NoDefiniteAutomation last = stack.pop();
                    State newStart = new State();
                    State newEnd = new State();
                    last.graph.addEdge(new Transition(), newStart, newEnd, EdgeType.DIRECTED);
                    last.graph.addEdge(new Transition(), newStart, last.start, EdgeType.DIRECTED);
                    last.graph.addEdge(new Transition(), last.end, newEnd, EdgeType.DIRECTED);
                    last.graph.addEdge(new Transition(), last.end, last.start, EdgeType.DIRECTED);
                    last.start = newStart;
                    last.end = newEnd;
                    stack.push(last);
                    break;
                }
                case '|': {
                    NoDefiniteAutomation last = stack.pop();
                    NoDefiniteAutomation lastTwo = stack.pop();
                    stack.push(last.parellize(lastTwo));
                    break;
                }
                default:
                    stack.add(new NoDefiniteAutomation(cur));
                    break;
            }
        }
        if (stack.size() != 1) {
            Logger.error("The final element left in stack is not only one");
            return null;
        }
        NoDefiniteAutomation nfa = stack.pop();
        if (re.tag != null) {
            nfa.end.tag = re.tag;
        }
        nfa.re = re;
        return nfa;
    }

    /**
     * 预处理部分第一个步骤，补全连接符。并且把[a-z]的形式转换为了(a|b|c|d...|z)的形式。
     *
     * @param re 输入的正则表达式（原始形式）。
     * @return 正则表达式对象。
     */
    private static RegularExpression prePreProcessor(RegularExpression re) {
        char[] chars = re.re.toCharArray();
        PreprocessState pstate = PreprocessState.START;
        String result = "";
        char rangeStart = 'a';
        for (char cur : chars) {
            switch (cur) {
                case '(':
                    if (pstate.equals(PreprocessState.LAST_IS_SINGLE)) {
                        result += '~';
                    }
                    pstate = PreprocessState.START;
                    result += cur;
                    break;
                case ')':
                    result += cur;
                    pstate = PreprocessState.LAST_IS_R_PARTNESS;
                    break;
                case '[':
                    if (pstate.equals(PreprocessState.LAST_IS_SINGLE) || pstate.equals(PreprocessState.LAST_IS_R_BRACKET)) {
                        result += "~";
                    }
                    result += '(';
                    pstate = PreprocessState.IN_BRACKET;
                    break;
                case ']':
                    result += ')';
                    pstate = PreprocessState.LAST_IS_R_BRACKET;
                    break;
                case '+':
                case '*':
                    result += cur;
                    pstate = PreprocessState.LAST_IS_SINGLE;
                    break;
                case '|':
                    result += cur;
                    pstate = PreprocessState.LAST_IS_BINARY;
                    break;
                case '-':
                    pstate = PreprocessState.IN_BRACKET_RANGE;
                    break;
                default:
                    if (pstate.equals(PreprocessState.IN_BRACKET_RANGE)) {
                        for (char c = (char) (rangeStart + 1); c <= cur; c++) {
                            result += ('|' + "" + c);
                        }
                        pstate = PreprocessState.IN_BRACKET_SINGLE;
                    } else if (pstate.equals(PreprocessState.IN_BRACKET_SINGLE)) {
                        result += "" + '|' + cur;
                        rangeStart = cur;
                        pstate = PreprocessState.IN_BRACKET_SINGLE;
                    } else if (pstate.equals(PreprocessState.IN_BRACKET)) {
                        result += cur;
                        rangeStart = cur;
                        pstate = PreprocessState.IN_BRACKET_RANGE;
                    } else if (pstate.equals(PreprocessState.LAST_IS_R_BRACKET) || pstate.equals(PreprocessState.LAST_IS_R_PARTNESS) || pstate.equals(PreprocessState.LAST_IS_SINGLE)) {
                        result += "" + '~' + cur;
                        pstate = PreprocessState.LAST_IS_SINGLE;
                    } else {
                        result += cur;
                        pstate = PreprocessState.LAST_IS_SINGLE;
                    }
                    break;
            }
        }
        return new RegularExpression(result, re.tag);
    }

    /**
     * 将正则表达式中缀形式转换为后缀形式。
     *
     * @param re 正则表达式对象，已经补全了连接符并且[a-z]的形式转换为了(a|b|c|d...|z)的形式。
     * @return 预处理结束的正则表达式对象。
     */
    private static RegularExpression infix2suffix(RegularExpression re) {
        Stack<Character> operators = new Stack<>();
        Stack<Character> temp = new Stack<>();
        Character l;
        char[] chars = re.re.toCharArray();
        for (char cur : chars) {
            switch (cur) {
                case '(':
                    operators.add(cur);
                    break;
                case ')':
                    while ((l = operators.pop()) != '(') {
                        temp.add(l);
                    }
                    break;
                case '[':
                    operators.add(cur);
                    break;
                case ']':
                    while ((l = operators.pop()) != '[') {
                        temp.add(l);
                    }
                    break;
                case '-':
                case '*':
                case '~':
                case '|':
                    if (operators.empty() || operators.peek().equals('(') || operators.peek().equals('[') || RegularExpression.operators.get(cur) > RegularExpression.operators.get(operators.peek())) {
                        operators.push(cur);
                    } else {
                        while (!operators.empty() && operators.peek() != '(' && operators.peek() != '[' && RegularExpression.operators.get(cur) < RegularExpression.operators.get(operators.peek())) {
                            temp.push(operators.pop());
                        }
                        operators.push(cur);
                    }
                    break;
                default:
                    //是操作数
                    temp.add(cur);
                    break;
            }
        }
        while (!operators.empty()) {
            temp.push(operators.pop());
        }
        String result = "";
        for (Character c : temp.toArray(new Character[]{})) {
            result += c;
        }
        return new RegularExpression(result, re.tag);
    }

    public static NoDefiniteAutomation mock() {
        return build(RegularExpression.mock());
    }

    public static void main(String[] args) {
        NoDefiniteAutomation nfa = new NoDefiniteAutomation();
    }
}
