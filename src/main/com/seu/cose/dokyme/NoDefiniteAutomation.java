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
import java.util.Stack;

/**
 * Created by zdksc on 2017/12/7.
 */
public class NoDefiniteAutomation {

    private enum PreprocessState {
        LAST_IS_CHAR, LAST_IS_R_BRACKET, LAST_IS_R_PARTNESS, LAST_IS_SINGLE, IN_BRACKET, LAST_IS_BINARY, START, IN_BRACKET_RANGE, IN_BRACKET_SINGLE
    }

    public class VisualFrame extends JFrame {
        private Layout<State, Transition> layout;
        private BasicVisualizationServer<State, Transition> server;

        public VisualFrame(Graph<State, Transition> graph) {
            super("Hello World");
            layout = new CircleLayout<State, Transition>(graph);
            layout.setSize(new Dimension(100, 100));
            server = new BasicVisualizationServer<>(layout);
            server.setPreferredSize(new Dimension(350, 350));
            server.getRenderContext().setVertexLabelTransformer(new ToStringLabeller());
            server.getRenderer().getVertexLabelRenderer().setPosition(Renderer.VertexLabel.Position.CNTR);
            server.getRenderContext().setVertexFillPaintTransformer(e -> Color.WHITE);
            server.getRenderContext().setEdgeLabelTransformer(new ToStringLabeller());
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            getContentPane().add(server);
            pack();
            setVisible(true);
        }
    }

    private DirectedGraph<State, Transition> graph;
    private State start;
    private State end;

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

    public NoDefiniteAutomation concat(NoDefiniteAutomation next) {
        graph.addEdge(new Transition(), end, next.start);
        end = next.end;
        return this;
    }

    public NoDefiniteAutomation parellize(NoDefiniteAutomation another) {
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

    public static NoDefiniteAutomation build(RegularExpression re) {
        Logger.debug("Raw input:" + re.re);
        re = addConcatOpt(re);
        Logger.debug("Added concat symbol and transform range format to or:" + re.re);
        re = infix2suffix(re);
        Logger.debug("Transform infix to suffix:" + re.re);
//        Stack<NoDefiniteAutomation> stack = new Stack<>();
//        NoDefiniteAutomation noDefiniteAutomation = new NoDefiniteAutomation();
//        noDefiniteAutomation.graph = new DirectedSparseMultigraph<>();
//        char[] characters = re.re.toCharArray();
//        for (char cur : characters) {
//            switch (cur) {
//                case '+': {
//                    //TODO
//                    break;
//                }
//                case '-': {
//                    NoDefiniteAutomation last = stack.pop();
//                    char end = last.getOnlyCharacter();
//                    char begin = stack.pop().getOnlyCharacter();
//                    for (char it = begin; it != end; it++) {
//                        last.parellize(new NoDefiniteAutomation(it));
//                    }
//                    last.parellize(new NoDefiniteAutomation(end));
//                    stack.push(last);
//                    break;
//                }
//                case '*': {
//                    NoDefiniteAutomation last = stack.pop();
//                    last.graph.addEdge(new Transition(), last.end, last.start, EdgeType.DIRECTED);
//                    stack.push(last);
//                    break;
//                }
//                case '|': {
//                    NoDefiniteAutomation last = stack.pop();
//                    NoDefiniteAutomation lastTwo = stack.pop();
//                    last.parellize(lastTwo);
//                    stack.push(last);
//                    break;
//                }
//                default:
//                    stack.add(new NoDefiniteAutomation(cur));
//                    break;
//            }
//        }
        return null;
    }

    private static RegularExpression addConcatOpt(RegularExpression re) {
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

    public static void main(String[] args) {
        NoDefiniteAutomation nfa = new NoDefiniteAutomation();

    }
}
