package chapter4.graph.algorithms.longestpath;

import chapter4.graph.ScoredNode;
import chapter4.graph.TopologicalOrderCapableGraph;
import chapter4.graph.exceptions.NodeNotExistsException;

/**
 * Created by mihai.isaroiu on 7/23/15.
 */
public class LPGraph extends TopologicalOrderCapableGraph<String, ScoredNode<String>, Integer> {
    @Override
    public void addEdge(String from, String to, Integer value) throws NodeNotExistsException {

        if (nodes.get(from) == null)
            nodes.put(from, new ScoredNode<String>(from, Integer.MIN_VALUE));

        if (nodes.get(to) == null)
            nodes.put(to, new ScoredNode<String>(to, Integer.MIN_VALUE));
        super.addEdge(nodes.get(from), nodes.get(to), value);


    }

}
