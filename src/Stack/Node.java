package Stack;

public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this.setData(data);
    }

    public T getData() {
        return this.data;
    }

    private void setData(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

}
