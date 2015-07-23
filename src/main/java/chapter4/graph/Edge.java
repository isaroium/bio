package chapter4.graph;

/**
 * Created by mihai.isaroiu on 7/23/15.
 */
public class Edge<T extends Node, V extends Number> {

    private V value;
    private T from;
    private T to;

    public Edge(T from, T to) {
        this.from = from;
        this.to = to;
    }

    public Edge(T from, T to, V value) {
        this(from, to);
        this.value = value;
    }


    public T getTo() {
        return to;
    }

    public void setTo(T to) {
        this.to = to;
    }

    public T getFrom() {
        return from;
    }

    public void setFrom(T from) {
        this.from = from;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && (obj instanceof Edge) && (getTo().equals((((Edge) obj).getTo())) && (this.getFrom().equals(((Edge) obj).getFrom())));
    }

    @Override
    public String toString() {
        return getFrom() + "->" + getTo();
    }
}
