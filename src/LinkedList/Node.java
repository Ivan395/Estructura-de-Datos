package LinkedList;


/**
 * Object for create a Linked List data type
 * @param <T>
 */
public class Node<T> {

    private T data;
    private Node<T> next;

    /**
     * Constructor for initizalize Node
     * @param data
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Method for get the object of the data
     * @return data
     */
    public T getData() {
        return data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
