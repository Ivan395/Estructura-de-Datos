package LinkedList;

public class LinkedList<T> {

    private Node<T> head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void addStart(T data) {
        if(isEmpty()) {
            head = new Node<T>(data);
        }else {
            Node<T> temp = new Node<T>(data);
            temp.setNext(head);
            head = temp;
        }
        setSize(getSize() + 1);
    }

    public void addEnd(T data) {
        if(isEmpty()) {
            addStart(data);
        }else {
            Node<T> temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new Node<T>(data));
            setSize(getSize() + 1);
        }
    }

    public T getValue(int index) {
        if(!isEmpty()) {
            if(!(index >= getSize() || index < 0)) {
                Node<T> temp = head;
                int counter = 0;
                while (counter < index) {
                    temp = temp.getNext();
                    counter++;
                }
                return temp.getData();
            }
        }
        return null;
    }

    public void showList() {
        if(!isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Node<T> temp = head;
            while (temp != null) {
                sb.append(temp.getData()).append(", ");
                temp = temp.getNext();
            }
            System.out.println(sb.toString().substring(0, sb.length() - 2).trim());
        }else {
            System.out.println("The list is empty");
        }
    }

    public boolean removeAtStart() {
        if(!isEmpty()) {
            head = head.getNext();
            setSize(getSize() - 1);
            return true;
        }
        return false;
    }

    public boolean removeAtEnd() {
        if(!isEmpty()) {
            if(getSize() == 1) {
                removeAtStart();
            }else {
                Node<T> ant = head;
                Node<T> temp = ant.getNext();
                while (temp.getNext() != null) {
                    ant = temp;
                    temp = temp.getNext();
                }
                ant.setNext(null);
                setSize(getSize() - 1);
            }
            return true;
        }
        return false;
    }

    public boolean removeByValue(int data) {
        if(!isEmpty()) {
            Node<T> ant = head;
            if(ant.getData().equals(data)) {
                removeAtStart();
            }else {
                Node<T> temp = ant.getNext();
                while (!temp.getData().equals(data)) {
                    ant = temp;
                    temp = temp.getNext();
                }
                ant.setNext(temp.getNext());
                setSize(getSize() - 1);
            }
            return true;
        }
        return false;
    }

    public boolean removeByIndex(int index) {
        if(!isEmpty()) {
            if(index == 0) {
                removeAtStart();
            }else {
                int counter = 0;
                Node<T> temp = head;
                while (counter < index - 1) {
                    temp = temp.getNext();
                    counter++;
                }
                setSize(getSize() - 1);
                temp.setNext(temp.getNext().getNext());
            }
            return true;
        }
        return false;
    }

    public int getIndexOfValue(T data) {
        int index = -1;
        if(!isEmpty()) {
            index = 0;
            Node<T> temp = head;
            while (temp != null && index < getSize() && !temp.getData().equals(data)) {
                temp = temp.getNext();
                index++;
            }
            if(temp == null) {
                index = -1;
            }
        }
        return index;
    }

    public boolean isEmpty() {
        return getSize() <= 0;
    }

    public int getSize() {
        return this.size;
    }

    private void setSize(int size) {
        this.size = size;
    }

}
