package Queue;

import Queue.Node;

public class Queue<T> {

    private Node<T> head, tail;
    private int size;

    public Queue() {
        this.head = this.tail = null;
        this.size = 0;
    }

    public void enqueue(T data){
        Node<T> temp = new Node<T>(data);
        if(isEmpty()) {
            this.head = this.tail = temp;
        }else {
            this.tail.setNext(temp);
            this.tail = this.tail.getNext();
        }
        setSize(getSize() + 1);
    }

    public T dequeue() {
        T result = null;
        if(!isEmpty()) {
            result = this.head.getData();
            this.head = this.head.getNext();
            setSize(getSize() - 1);
        }
        return result;
    }

    public void showList() {
        if(!isEmpty()) {
            Node<T> temp = this.head;
            while (temp != null) {
                System.out.print("[" + temp.getData() + "] ->");
                temp = temp.getNext();
            }
            System.out.println("");
        }else {
            System.out.println("The queue is empty");
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int getSize() {
        return size;
    }

    private void setSize(int size) {
        this.size = size;
    }
}
