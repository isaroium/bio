package chapter4.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by mihai.isaroiu on 7/23/15.
 */
public class Node<T> {

    private Set<Edge> outgoing;
    private Set<Edge> incoming;
    private T id;

    public Node(T value) {
        outgoing = new HashSet<Edge>();
        incoming = new HashSet<Edge>();
        id = value;

    }

    public Set<Edge> getIncoming() {
        return incoming;
    }

    public void setIncoming(Set<Edge> incoming) {
        this.incoming = incoming;
    }


    public Set<Edge> getOutgoing() {
        return outgoing;
    }

    public void setOutgoing(Set<Edge> outgoing) {
        this.outgoing = outgoing;
    }

    public void addEdge(Edge e) {
        outgoing.add(e);
    }

    public void removeEdge(Edge e) {
        outgoing.remove(e);
    }

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof Node && ((this.getId() == ((Node) obj).getId()) || ((Node) obj).getId().equals(this.getId()));
    }

    @Override
    public int hashCode() {
        return (getId() == null) ? super.hashCode() : getId().hashCode();
    }

    @Override
    public String toString() {
        return getId().toString();
    }
}
