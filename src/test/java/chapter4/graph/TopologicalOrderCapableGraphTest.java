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

    public void testGetTopologicalOrdere() throws Exception {
        TopologicalOrderCapableGraph<String, Node<String>, Integer> graph = new TopologicalOrderCapableGraph<>();
        graph.addEdge(new Node("a"), new Node("b"));
        graph.addEdge(new Node("a"), new Node("c"));
        graph.addEdge(new Node("a"), new Node("d"));
        graph.addEdge(new Node("a"), new Node("e"));
        graph.addEdge(new Node("a"), new Node("f"));
        graph.addEdge(new Node("b"), new Node("c"));
        graph.addEdge(new Node("b"), new Node("f"));
        graph.addEdge(new Node("c"), new Node("d"));
        graph.addEdge(new Node("e"), new Node("f"));
        graph.addEdge(new Node("e"), new Node("d"));


        System.out.println(graph.getTopologicalOrder());
        //System.out.println(graph.)
    }
}