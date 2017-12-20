package com.seu.cose.dokyme;

import edu.uci.ics.jung.graph.DirectedSparseMultigraph;
import edu.uci.ics.jung.graph.Graph;

import java.util.*;

/**
 * Created by zdksc on 2017/12/7.
 */
public class DefiniteAutomation {

    private static int sid = 0;

    private class TableEntry {
        public int stateId;
        public Set<State> nfaStates;
        public HashMap<Transition, Integer> transitions;

        public TableEntry() {
            stateId = sid++;
            transitions = new HashMap<>();
            nfaStates = new HashSet<>();
        }

        public TableEntry(Set<State> states) {
            this();
            nfaStates = states;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            } else if (!(obj instanceof TableEntry)) {
                return false;
            } else if (!this.nfaStates.equals(((TableEntry) obj).nfaStates)) {
                return false;
            } else {
                return true;
            }
        }
    }

    private List<TableEntry> table;
    private Set<Character> allTrans;
    private NoDefiniteAutomation nfa;
    public Graph<State, Transition> graph;
    public State start;
    public Set<State> endStates;

    public static DefiniteAutomation build(Set<NoDefiniteAutomation> nfas) {
        List<NoDefiniteAutomation> nfaList = new ArrayList<>();
        nfaList.addAll(nfas);
        NoDefiniteAutomation leaderNFA = nfaList.get(0);
        Set<State> allEndState = new HashSet<>();
        allEndState.add(leaderNFA.end);
        if (nfas.size() > 1) {
            for (int i = 1; i < nfaList.size(); i++) {
                leaderNFA.merge(nfaList.get(i));
                allEndState.add(nfaList.get(i).end);
            }
        }
        DefiniteAutomation dfa = build(leaderNFA, allEndState);
        return dfa;
    }

    private static DefiniteAutomation build(NoDefiniteAutomation nfa, Set<State> allEndState) {
        DefiniteAutomation dfa = new DefiniteAutomation();
        dfa.allTrans = nfa.getAllTransitionTag();
        dfa.nfa = nfa;
        dfa.table = new ArrayList<>();
        dfa.graph = new DirectedSparseMultigraph<>();
        Set<State> stateSet = new HashSet<>();
        stateSet.add(nfa.start);
        stateSet = dfa.getEpsilonClosure(stateSet);
        dfa.table.add(dfa.new TableEntry(stateSet));

        for (int i = 0; i < dfa.table.size(); i++) {
            TableEntry entry = dfa.table.get(i);
            for (Character transChar : dfa.allTrans) {
                Transition trans = new Transition(transChar);
                Set<State> extendedStates = dfa.getStateExtension(entry.nfaStates, trans);
                Set<State> epslnExtendedStates = dfa.getEpsilonClosure(extendedStates);
                TableEntry potentialEntry = dfa.new TableEntry(epslnExtendedStates);
                if (!epslnExtendedStates.isEmpty()) {
                    int existedEntryIndex = dfa.table.indexOf(potentialEntry);
                    if (existedEntryIndex == -1) {
                        dfa.table.add(potentialEntry);
                        entry.transitions.put(trans, dfa.table.size() - 1);
                        Logger.debug("Found new dfa state " + dfa.table.size());
                    } else {
                        entry.transitions.put(trans, existedEntryIndex);
                    }
                }
            }
        }

        State.resetId();
        List<State> dfaStates = new ArrayList<>();
        for (int i = 0; i < dfa.table.size(); i++) {
            dfaStates.add(new State());
        }

        Set<State> newEndStates = new HashSet<>();
        for (int i = 0; i < dfa.table.size(); i++) {
            boolean isEndState = false;
            TableEntry entry = dfa.table.get(i);
            for (State nfaEndState : allEndState) {
                if (entry.nfaStates.contains(nfaEndState) && (dfaStates.get(i).precedence == -1 || dfaStates.get(i).precedence > nfaEndState.precedence)) {
                    dfaStates.get(i).tag = nfaEndState.tag;
                    dfaStates.get(i).precedence = nfaEndState.precedence;
                    isEndState = true;
                }
            }
            if (isEndState) {
                newEndStates.add(dfaStates.get(i));
            }
            for (Transition trans : entry.transitions.keySet()) {
                dfa.graph.addEdge(new Transition(trans.tag), dfaStates.get(i), dfaStates.get(entry.transitions.get(trans)));
            }
        }

        dfa.start = dfaStates.get(0);
        dfa.endStates = newEndStates;
        return dfa;
    }

    /**
     * 求得该NFA中state中每个state经过transition转移之后是状态集。
     *
     * @param states     初始状态集。
     * @param transition 某个转移（只关心该transition的tag）。
     * @return 经过状态转移的HashSet<State>
     */
    public Set<State> getStateExtension(Set<State> states, Transition transition) {
        Set<State> resultSet = new HashSet<>();
        for (State state : states) {
            for (Transition edge : nfa.graph.getOutEdges(state)) {
                if (edge.equals(transition)) {
                    resultSet.add(nfa.graph.getDest(edge));
                }
            }
        }
        return resultSet;
    }

    /**
     * 求该nfa中originStates的Epsilon闭包。
     *
     * @param originStates
     * @return 求得Epsilon闭包后的HashSet<State>
     */
    public Set<State> getEpsilonClosure(Set<State> originStates) {
        Set<State> resultSet = new HashSet<>();
        while (true) {
            for (State start : originStates) {
                resultSet.add(start);
                for (Transition edge : nfa.graph.getOutEdges(start)) {
                    if (edge.tag.equals('~')) {
                        resultSet.add(nfa.graph.getDest(edge));
                    }
                }
            }
            if (resultSet.equals(originStates)) {
                return resultSet;
            }
            originStates = new HashSet<>();
            for (State state : resultSet) {
                originStates.add(state);
            }
        }
    }
}
