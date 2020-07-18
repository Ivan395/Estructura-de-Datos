package DoublyLinkedList;

public class DoublyLinkedList<T> {
    private Node<T> before;
    private Node<T> after;
    private int size;

    public DoublyLinkedList() {
        before = after = null;
        size = 0;
    }

    public void addStart(T data) {
        if(isEmpty()) {
            addEnd(data);
        }else {
            Node<T> temp = new Node<T>(data);
            temp.setAfter(before);
            before.setBefore(temp);
            before = temp;
            setSize(getSize() + 1);
        }
    }

    public void addEnd(T data) {
         if(isEmpty()) {
             before = after = new Node<T>(data);
         }else {
             Node<T> temp = new Node<T>(data);
             after.setAfter(temp);
             temp.setBefore(after);
             after = temp;
         }
         setSize(getSize() + 1);
    }

    public void showDataFromStart() {
        if(!isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Node<T> temp = before;
            while (temp != null) {
                sb.append(temp.getData()).append(", ");
                temp = temp.getAfter();
            }
            System.out.println(sb.substring(0, sb.length() - 2).trim());
        }else {
            System.out.println("The list is empty");
        }
    }

    public void showDatafromEnd() {
        if(!isEmpty()) {
            StringBuilder sb = new StringBuilder();
            Node<T> temp = after;
            while (temp != null) {
                sb.append(temp.getData()).append(", ");
                temp = temp.getBefore();
            }
            System.out.println(sb.substring(0, sb.length() - 2).trim());
        }else {
            System.out.println("The list is empty");
        }
    }

    public boolean removeAtStart() {
        if(!isEmpty()) {
            if(before == after) {
                before = after = null;
            }else {
                before = before.getAfter();
                before.setBefore(null);
            }
            setSize(getSize() - 1);
            return true;
        }
        return false;
    }

    public boolean removeAtEnd() {
        if(!isEmpty()) {
            if(before == after) {
                before = after = null;
            }else {
                after = after.getBefore();
                after.setAfter(null);
            }
            setSize(getSize() - 1);
            return true;
        }
        return false;
    }

    public boolean removeByIndex(int index, boolean fromEnd) {
        if(!isEmpty() && index >= 0 && index < getSize() - 1) {
            if(!fromEnd) {
                if(index == 0) {
                    removeAtStart();
                }else if(index == getSize() - 1) {
                    removeAtEnd();
                }else {
                    int counter = 0;
                    Node<T> temp = before;
                    while (counter < index - 1) {
                        temp = temp.getAfter();
                        counter++;
                    }
                    temp.setAfter(temp.getAfter().getAfter());
                    setSize(getSize() - 1);
                }
            }else {
                if(index == 0) {
                    removeAtEnd();
                }else if(index == getSize() - 1) {
                    removeAtStart();
                }else {
                    int counter = 0;
                    Node<T> temp = after;
                    while (counter < index - 1) {
                        temp = temp.getBefore();
                        counter++;
                    }
                    temp.setBefore(temp.getBefore().getBefore());
                    setSize(getSize() - 1);
                }
            }
            return true;
        }
        return false;
    }

    public boolean removeByValue(T data) {
        if (!isEmpty()){
            Node<T> temp = before;
            if(temp.getData().equals(data)) {
                removeAtStart();
            }else {
                while (temp.getAfter() != null && !temp.getAfter().getData().equals(data)) {
                    temp = temp.getAfter();
                }
                if(temp.getAfter() != null) {
                    temp.setAfter(temp.getAfter().getAfter());
                    setSize(getSize() - 1);
                    return true;
                }
            }
        }
        return false;
    }

    public T getValue(int index) {
        if(!isEmpty()) {
            if(index >= 0 && index < getSize()) {
                int counter = 0;
                Node<T> temp = before;
                while (temp != null && counter < index) {
                    temp = temp.getAfter();
                    counter++;
                }
                if(temp != null) {
                    return temp.getData();
                }
            }
        }
        return null;
    }

    public int getIndex(T data) {
        int index = -1;
        if(!isEmpty()) {
            index++;
            Node<T> temp = before;
            while (temp != null && !temp.getData().equals(data)) {
                temp = temp.getAfter();
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
        return size;
    }

    private void setSize(int size) {
        this.size = size;
    }
}
