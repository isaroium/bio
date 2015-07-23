package chapter4.graph;

import junit.framework.TestCase;

/**
 * Created by mihai.isaroiu on 7/23/15.
 */
public class TopologicalOrderCapableGraphTest extends TestCase {


    public void testGetTopologicalOrder() throws Exception {
        TopologicalOrderCapableGraph<Integer, Node<Integer>, Integer> graph = new TopologicalOrderCapableGraph<>();
        graph.addEdge(new Node(0), new Node(1));
        graph.addEdge(new Node(1), new Node(2));
        graph.addEdge(new Node(3), new Node(1));
        graph.addEdge(new Node(4), new Node(2));
        System.out.println(graph.getTopologicalOrder());
        //System.out.println(graph.)
    }
}