package chapter4.graph.algorithms;

import chapter4.graph.exceptions.NodeNotExistsException;
import junit.framework.TestCase;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by mihai.isaroiu on 7/23/15.
 */
public class LongestPathTest extends TestCase {
    public LongestPath getInstance(String filename) throws IOException, NodeNotExistsException {
        LPGraph instance = new LPGraph();
        Integer start = null;
        Integer sink = null;
        if (filename != null) {

            BufferedReader br = new BufferedReader(new FileReader(filename));
            String s = br.readLine();
            if ("Input:".equalsIgnoreCase(s))
                s = br.readLine();
            start = Integer.parseInt(s);
            sink = Integer.parseInt(br.readLine());
            while ((s = br.readLine()) != "-" && s.split("->").length > 1) {
                int n = Integer.parseInt(s.split("->")[0]);
                int m = Integer.parseInt(s.split("->")[1].split(":")[0]);
                int k = Integer.parseInt(s.split("->")[1].split(":")[1]);
                instance.addEdge(n, m, k);
            }
            while ((s = br.readLine()) != null) {
                try {
                    Integer output = Integer.parseInt(s);
                } catch (Exception e) {

                }
            }

        }
        LongestPath toRet = new LongestPath(instance, instance.getNode(start), instance.getNode(sink));
        return toRet;
    }

    public void testGetLongestPath() throws Exception {
        LPGraph g = new LPGraph();
        g.addEdge(0, 1, 7);
        g.addEdge(0, 2, 4);
        g.addEdge(2, 3, 2);
        g.addEdge(1, 4, 1);
        g.addEdge(3, 4, 3);
        LongestPath lon = new LongestPath(g, g.getNode(0), g.getNode(4));
        System.out.println(lon.getLongestPath());
        System.out.println(lon.printLongestPath());
    }

    public void testExtraDataset() throws Exception {
        LongestPath lon = this.getInstance("/home/mihai.isaroiu/Downloads/longest_path_in_DAG.txt");
        System.out.println(lon.getLongestPath());
        System.out.println(lon.printLongestPath());
    }
}