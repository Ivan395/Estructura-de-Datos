package DoublyLinkedList;

import java.lang.annotation.AnnotationFormatError;

public class Node<T> {
    private T data;
    private Node<T> before;
    private Node<T> after;

    public Node(T data) {
        this(data, null, null);
    }

    private Node(T data, Node<T> before, Node<T> after) {
        setData(data);
        setBefore(before);
        setAfter(after);
    }

    public T getData() {
        return data;
    }

    private void setData(T data) {
        this.data = data;
    }

    public Node<T> getBefore() {
        return before;
    }

    public void setBefore(Node<T> before) {
        this.before = before;
    }

    public Node<T> getAfter() {
        return after;
    }

    public void setAfter(Node<T> after) {
        this.after = after;
    }

}
