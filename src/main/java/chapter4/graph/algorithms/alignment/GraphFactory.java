package chapter4.graph.algorithms.alignment;

import chapter4.util.Pepdite;

/**
 * Created by mihai.isaroiu on 7/28/15.
 */
public class GraphFactory {

    public static AllignmentGraph generateGraph(String a, String b, int delta) {
        AllignmentGraph ag = new AllignmentGraph();
        String locala = "-" + a;
        String localb = "-" + b;
        PeptideNode start = new PeptideNode(0, 0, Pepdite.NO);
        for (int i = 0; i < a.length() + 1 * b.length() + 1; i++) {
            //TODO form arrays

        }


        return null;
    }
}
