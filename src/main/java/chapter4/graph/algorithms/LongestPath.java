package chapter4.graph.algorithms;

import chapter4.graph.Edge;
import chapter4.graph.ScoredNode;
import chapter4.graph.exceptions.NonDAGException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mihai.isaroiu on 7/23/15.
 */
public class LongestPath {
    /**
     * <code>LONGESTPATH(Graph, source, sink)
     * for each node b in Graph
     * sb ← −∞
     * ssource ← 0
     * topologically order Graph
     * for each node b in Graph (following the topological order)
     * sb ← maxall predecessors a of node b {sa + weight of edge from a to b}
     * return ssink</code>
     **/
    LPGraph graph;
    ScoredNode<Integer> start;
    ScoredNode<Integer> sink;
    private boolean run = false;

    public LongestPath(LPGraph graph, ScoredNode<Integer> source, ScoredNode<Integer> sink) {
        this.graph = graph;
        this.start = graph.getNode(source.getId());
        this.sink = graph.getNode(sink.getId());
    }

    public LPGraph generateGraphs() {
        return new LPGraph();
    }

    public void run() throws NonDAGException {
        graph.getTopologicalOrder().forEach(node -> {
                    int score = node.getIncoming().stream().
                            mapToInt((cur) -> ((Edge<ScoredNode<Integer>, Integer>) cur).getFrom().getScore() + ((Edge<ScoredNode<Integer>, Integer>) cur)
                                    .getValue()).max().orElse(0);
                    ScoredNode used = node.getIncoming().stream().findFirst(edge -> edge.getFrom().getScore() + Integer.MAX_VALUE);
                    //TODO
                }
        );
        run = true;
    }

    public Integer getLongestPath() {
        if (!run)
            try {
                this.run();
            } catch (NonDAGException e) {

            }
        return graph.getNode(sink.getId()).getScore();
    }

    public String printLongestPath() {
        if (!run)
            try {
                this.run();
            } catch (NonDAGException e) {

            }
        int max = getLongestPath();

        ScoredNode<Integer> current = graph.getNode(sink.getId());
        StringBuffer stack = new StringBuffer();
        stack.append(current.toString());
        while (max > 0) {
            List<Edge> list = current.getIncoming().stream().collect(Collectors.toList());
            list.sort((a, b) -> a.getValue().intValue() - a.getValue().intValue());
            current = (ScoredNode) list.get(list.size() - 1).getFrom();
            max = max - current.getScore();
            stack.append(">-" + current);
        }
        stack.append(">-" + start.toString());
        return stack.reverse().toString();
    }


}
