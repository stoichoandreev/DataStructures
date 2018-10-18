package data.structures;

public class Queue<T> {

    private Node<T> root;
    private int size;

    public Queue(T value) {
        this.root = new Node<>(value);
        size = 1;
    }

    public void enqueue(T value) {
        Node<T> newItem = new Node<>(value);
        newItem.setNext(root);
        root = newItem;
        size++;
    }

    public T dequeue() {
        Node<T> node = root;
        Node<T> previous = null;

        while(node.getNext() != null) {
            previous = node;
            node = node.getNext();
        }
        node = previous.getNext();
        previous.setNext(null);
        size--;
        return node.getValue();
    }

    public int size() {
        return size;
    }

    public static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

}
