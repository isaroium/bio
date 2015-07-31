package chapter4.graph.algorithms;

import chapter4.graph.algorithms.longestpath.LPGraph;
import chapter4.graph.algorithms.longestpath.LongestPath;
import chapter4.graph.exceptions.NodeNotExistsException;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mihai.isaroiu on 7/23/15.
 */
public class LongestPathTest extends TestCase {

    public LongestPath getInstance(String filename) throws IOException, NodeNotExistsException {
        LPGraph instance = new LPGraph();
        Integer start = null;
        Integer sink = null;
        if (filename != null) {
            BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(filename)));
            String s = br.readLine();
            if ("Input:".equalsIgnoreCase(s))
                s = br.readLine();
            start = Integer.parseInt(s);
            sink = Integer.parseInt(br.readLine());
            while ((s = br.readLine()) != null && s.split("->").length > 1) {
                int n = Integer.parseInt(s.split("->")[0]);
                int m = Integer.parseInt(s.split("->")[1].split(":")[0]);
                int k = Integer.parseInt(s.split("->")[1].split(":")[1]);
                // instance.addEdge(n, m, k);
            }
            while ((s = br.readLine()) != null) {
                try {
                    Integer output = Integer.parseInt(s);
                } catch (Exception e) {

                }
            }

        }

        return null;//new LongestPath(instance, instance.getNode(start), instance.getNode(sink));
    }

    public void testGetLongestPath() throws Exception {
        LPGraph g = new LPGraph();
//        g.addEdge(0, 1, 7);
//        g.addEdge(0, 2, 4);
//        g.addEdge(2, 3, 2);
//        g.addEdge(1, 4, 1);
//        g.addEdge(3, 4, 3);
        //  LongestPath lon = new LongestPath(g, g.getNode(0), g.getNode(4));
//        System.out.println(lon.getLongestPath());
//        System.out.println(lon.printLongestPath());

    }

    public void testExtraDataset() throws Exception {
        LongestPath lon = this.getInstance("longest_path_in_DAG.txt");
        System.out.println(lon.getLongestPath());
        System.out.println(lon.printLongestPath());
    }

    public void testExtraProblem() throws Exception {
        LongestPath lon = this.getInstance("dataset_245_7.txt");
        System.out.println(lon.getLongestPath());
        System.out.println(lon.printLongestPath());
    }

    public void testGetLongestPathProblem() throws Exception {
        LPGraph g = new LPGraph();
        g.addEdge("a", "b", 3);
        g.addEdge("a", "c", 6);
        g.addEdge("a", "d", 5);
        g.addEdge("b", "c", 2);
        g.addEdge("b", "f", 4);
        g.addEdge("c", "e", 4);
        g.addEdge("c", "f", 3);
        g.addEdge("c", "g", 7);
        g.addEdge("d", "e", 4);
        g.addEdge("d", "f", 5);
        g.addEdge("e", "g", 2);
        g.addEdge("f", "g", 1);
//        g.addEdge(0, 1, 7);
//        g.addEdge(0, 2, 4);
//        g.addEdge(2, 3, 2);
//        g.addEdge(1, 4, 1);
//        g.addEdge(3, 4, 3);
        LongestPath lon = new LongestPath(g, g.getNode("a"), g.getNode("g"));
        System.out.println(lon.getLongestPath());
        System.out.println(lon.printLongestPath());

    }
}