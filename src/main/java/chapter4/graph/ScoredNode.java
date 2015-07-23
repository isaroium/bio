package chapter4.graph;

/**
 * Created by mihai.isaroiu on 7/23/15.
 */
public class ScoredNode<T> extends Node<T> {
    private Integer score;

    public ScoredNode(T id) {
        super(id);
    }

    public ScoredNode(T id, Integer defaultScore) {
        super(id);
        this.score = defaultScore;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
