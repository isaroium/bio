package chapter4.graph.algorithms.alignment;

import chapter4.graph.ScoredNode;
import chapter4.util.Pepdite;

/**
 * Created by mihai.isaroiu on 7/28/15.
 */
public class PeptideNode extends ScoredNode<Integer> {
    private String name;

    public PeptideNode(Integer id, String name) {
        this(id, Integer.MIN_VALUE, name);
    }

    public PeptideNode(Integer id, Integer defaultScore, String name) {
        super(id, defaultScore);
        this.name = name;
    }

    public PeptideNode(Integer id, Integer defaultScore, Pepdite name) {
        super(id, defaultScore);
        this.name = name.getVal() + "";
    }

    public String getName() {
        return name;
    }
}
