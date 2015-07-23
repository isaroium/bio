package chapter4.graph;

import chapter4.graph.exceptions.NodeNotExistsException;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by mihai.isaroiu on 7/23/15.
 */
public class Graph<T, NT extends Node<T>, V extends Number> {
    protected Set<Edge> edges;
    protected HashMap<T, NT> nodes;

    public Graph() {
        edges = new HashSet<>();
        nodes = new HashMap<>();
    }

    public Collection<NT> getNodes() {
        return nodes.values();
    }

    public NT getNode(T id) {
        return nodes.get(id);
    }

    public void addNode(NT node) {
        nodes.put(node.getId(), node);
    }

    public void removeNode(NT id) {
        nodes.remove(id.getId());
        edges = edges.stream().filter(e -> e.getFrom().getId() != id).filter(e -> e.getTo().getId().equals(id)).collect(Collectors.toSet());
    }

    public void addEdge(T from, T to) throws NodeNotExistsException {
        this.addEdge(from, to, null);
    }

    public void addEdge(T from, T to, V value) throws NodeNotExistsException {
        if (nodes.get(from) == null)
            throw new NodeNotExistsException(from);
        if (nodes.get(to) == null)
            throw new NodeNotExistsException(to);
        this.addEdge(nodes.get(from), nodes.get(to), value);

    }

    public void addEdge(NT from, NT to) {
        this.addEdge(from, to, null);

    }

    public void addEdge(NT from, NT to, final V value) {
        Edge e = new Edge(from, to, value);
        edges.add(e);
        if (nodes.get(from.getId()) == null)
            this.addNode(from);
        if (nodes.get(to.getId()) == null)
            this.addNode(to);
        nodes.get(from.getId()).addEdge(e);
        nodes.get(to.getId()).getIncoming().add(e);
    }

    public void removeEdge(T from, T to) {
        edges.removeIf(s -> s.getFrom().getId().equals(from) && s.getTo().getId().equals(to));
    }


}
