package chapter4.graph.algorithms.alignment;

import chapter4.graph.Edge;
import chapter4.util.Direction;

/**
 * Created by mihai.isaroiu on 7/28/15.
 */
public class PeptideEdge extends Edge<PeptideNode, Integer> {
    Direction d;

    public PeptideEdge(PeptideNode from, PeptideNode to, Direction d) {
        super(from, to, Integer.MIN_VALUE);
        this.d = d;
    }

    public PeptideEdge(PeptideNode from, PeptideNode to, Integer value, Direction d) {
        super(from, to, value);
        this.d = d;
    }
}
