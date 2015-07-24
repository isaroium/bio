package chapter4.graph.algorithms;

import chapter4.graph.Edge;
import chapter4.graph.Node;
import chapter4.graph.ScoredNode;
import chapter4.graph.exceptions.NonDAGException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    List<Edge> stack;
    private boolean run = false;

    public LongestPath(LPGraph graph, ScoredNode<Integer> source, ScoredNode<Integer> sink) {
        this.graph = graph;
        this.start = graph.getNode(source.getId());
        this.sink = graph.getNode(sink.getId());
        stack = new ArrayList<>();
    }

    public LPGraph generateGraphs() {
        return new LPGraph();
    }

    public void run() throws NonDAGException {

        graph.getTopologicalOrder().forEach(node -> {
                    int score = node.getIncoming().stream().
                            mapToInt((cur) -> ((Edge<ScoredNode<Integer>, Integer>) cur).getFrom().getScore() + ((Edge<ScoredNode<Integer>, Integer>) cur)
                                    .getValue()).max().orElse(Integer.MIN_VALUE);
                    node.setScore(node.equals(start) ? 0 : score);
                    Optional<Edge> optional = node.getIncoming().stream().filter(
                            edge -> (((ScoredNode<Integer>) edge.getFrom()).getScore() + edge.getValue().intValue()) == node.getScore() && node.getScore() >= 0).findFirst();
                    if (optional.isPresent())
                        stack.add(optional.get());
                }
        );
        run = true;
    }

    public Integer getLongestPath() {
        if (!run)
            try {
                this.run();
            } catch (NonDAGException e) {
                return Integer.MIN_VALUE;
            }
        return graph.getNode(sink.getId()).getScore();
    }

    public String printLongestPath() {
        if (!run)
            try {
                this.run();
            } catch (NonDAGException e) {
                return null;
            }
        stack.stream().sorted((o1, o2) -> (Integer) o2.getFrom().getId() - (Integer) o1.getFrom().getId());
        Node lastNode = sink;
        StringBuilder sb = new StringBuilder();
        sb.insert(0, "->" + lastNode.getId());
        while (!lastNode.equals(start)) {
            final Node finalLastNode = lastNode;
            Edge e = stack.stream().filter(edge -> edge.getTo().equals(finalLastNode)).findFirst().get();
            lastNode = e.getFrom();
            sb.insert(0, "->" + lastNode.getId());

        }
        return sb.substring(2);
    }


}
