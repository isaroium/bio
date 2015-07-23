package chapter4.graph.exceptions;

/**
 * Created by mihai.isaroiu on 7/23/15.
 */
public class NodeNotExistsException extends Exception {
    public NodeNotExistsException(Object from) {
        super(from.toString());
    }

}
