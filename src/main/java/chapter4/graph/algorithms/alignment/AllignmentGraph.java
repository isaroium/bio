package chapter4.graph.algorithms.alignment;


import chapter4.graph.TopologicalOrderCapableGraph;


/**
 * Created by mihai.isaroiu on 7/28/15.
 */
public class AllignmentGraph extends TopologicalOrderCapableGraph<Integer, PeptideNode, Integer> {
    @Override
    public void addEdge(PeptideNode f, PeptideNode t, Integer value) {
        // PeptideEdge e=new PeptideEdge(f,t,value);
        //  super.addEdge(e);
    }

    @Override
    public void addEdge(PeptideNode from, PeptideNode to) {
        this.addEdge(from, to, Integer.MIN_VALUE);
    }
}
