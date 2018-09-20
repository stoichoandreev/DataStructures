package data.structures;


public class LinkedListCustom<E> {

    private int counter;
    private Node<E> head;

    public void add(E item) {

        if (head == null) {
            head = new Node<>(item);
        }

        final Node<E> temp = new Node<>(item);
        Node<E> current = head;

        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);

        counter++;
    }


    public void add(E item, int index) {
        final Node<E> temp = new Node<>(item);
        Node<E> current = head;

        for (int i = 0; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }

        temp.setNext(current.getNext());
        current.setNext(temp);

        counter++;
    }

    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head.getNext();
        for (int i = 0; i < index; i++) {
            if (current.getNext() == null) {
                return null;
            }
            current = current.getNext();
        }
        return current.getData();
    }

    public boolean remove(int index) throws IndexOutOfBoundsException {
        if (index < 1 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            if (current.getNext() == null) {
                return false;
            }
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());

        counter--;

        return true;
    }

    public int size() {
        return counter;
    }

    public String toString() {
        final StringBuilder output = new StringBuilder();

        Node<E> current = head.getNext();
        while (current != null) {
            output.append("[").append(current.getData().toString()).append("]");
            current = current.getNext();
        }
        return output.toString();
    }

    static class Node<T> {

        private Node<T> next;
        private T data;

        Node(T dataValue) {
            next = null;
            data = dataValue;
        }

        Node(T dataValue, Node<T> nextValue) {
            next = nextValue;
            data = dataValue;
        }

        public T getData() {
            return data;
        }

        public void setData(T dataValue) {
            data = dataValue;
        }

        public Node<T> getNext() {
            return next;
        }

        private void setNext(Node<T> nextValue) {
            next = nextValue;
        }
    }
}
