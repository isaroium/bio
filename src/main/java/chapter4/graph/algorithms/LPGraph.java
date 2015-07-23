package chapter4.graph.algorithms;

import chapter4.graph.ScoredNode;
import chapter4.graph.TopologicalOrderCapableGraph;
import chapter4.graph.exceptions.NodeNotExistsException;

/**
 * Created by mihai.isaroiu on 7/23/15.
 */
public class LPGraph extends TopologicalOrderCapableGraph<Integer, ScoredNode<Integer>, Integer> {
    @Override
    public void addEdge(Integer from, Integer to, Integer value) throws NodeNotExistsException {

        if (nodes.get(from) == null)
            nodes.put(from, new ScoredNode<Integer>(from, Integer.MIN_VALUE));

        if (nodes.get(to) == null)
            nodes.put(to, new ScoredNode<Integer>(to, Integer.MIN_VALUE));
        super.addEdge(nodes.get(from), nodes.get(to), value);


    }

}
