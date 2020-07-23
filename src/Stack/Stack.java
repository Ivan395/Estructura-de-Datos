package Stack;

public class Stack<T> {
    private Node<T> top;
    private int size;

    public Stack() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T data) {
        Node<T> temp = new Node<T>(data);
        if(isEmpty()) {
            top = temp;
        }else {
            temp.setNext(top);
            top = temp;
        }
        setSize(getSize() + 1);
    }

    public T pop() {
        T data = null;
        if(!isEmpty()) {
            data = top.getData();
            top = top.getNext();
            setSize(getSize() - 1);
        }else {
            System.out.println("The stack is empty");
        }
        return data;
    }

    public T topElement() {
        return top.getData();
    }

    public void clear(){
        top = null;
    }

    public void showList() {
        if(!isEmpty()) {
            Node<T> temp = top;
            while (temp != null) {
                System.out.print("[" + temp.getData() + "] ->");
                temp = temp.getNext();
            }
            System.out.println("");
        }else {
            System.out.println("The list is empty");
        }
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
