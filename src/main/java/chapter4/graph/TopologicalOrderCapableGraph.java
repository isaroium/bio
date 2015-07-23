package chapter4.graph;

import chapter4.graph.exceptions.NonDAGException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by mihai.isaroiu on 7/23/15.
 */
public class TopologicalOrderCapableGraph<T, NT extends Node<T>, V extends Integer> extends Graph<T, NT, V> {

    public Set<NT> getTopologicalOrder() throws NonDAGException {
        Set<NT> topologicalOrder = new HashSet<>();
        List<NT> candidates = getNodes().stream().filter(f -> f.getIncoming().size() == 0).collect(Collectors.toList());
        Set<Edge> edgeCandidates = new HashSet<>(edges);
        while (!candidates.isEmpty()) {
            NT n = nodes.get(candidates.remove(0).getId());
            topologicalOrder.add(n);
            n.getOutgoing().forEach(current -> {
                NT ref = nodes.get(((Edge<NT, V>) current).getTo().getId());
                edgeCandidates.removeIf(edge1 -> edge1.equals(current));
                // System.out.println(edgeCandidates.stream().filter(edge2 -> edge2.getTo().equals(ref)).collect(Collectors.toList()));
                long num = edgeCandidates.stream().filter(edge2 -> edge2.getTo().equals(ref)).collect(Collectors.counting());
                if (0 == num) {
                    candidates.add(ref);
                }
            });
        }
        if (edgeCandidates.size() != 0) {
            throw new NonDAGException("Graph cannot be topological ordered");
        }
        return topologicalOrder;
    }

}
