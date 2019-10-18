

public class LinkedList<T> implements List<T> {    
    public class Node {
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public T getData() {
            return this.data;
        }
    }

    private Node head = null;
    private int size = 0;

    public void add(T item) {
        if (head == null) {
            head = new Node(item);
        } else {
            Node prev = head;
            while (prev.next != null) {
                prev = prev.getNext();
            }
            prev.setNext(new Node(item));
        }
        size++;
    }

    public void add(int index, T item) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception();
        }
        Node curr = new Node(item);
        if (index == 0) {
            curr.setNext(head);
            head = curr;
        } else {
            Node prev = head;
            for (int i=0; i < index - 1; i++) {
                prev = prev.getNext();
            }
            curr.setNext(prev.next);
            prev.setNext(curr);
        }
        size++;
    }

    public T remove(int index) throws Exception {
        if (index < 0 || index > size-1) {
            throw new Exception();
        }
        if (index == 0) {
            Node temp = head;
            head = head.next;
            size--;
            return temp.getData();
        } else {
            Node prev = head;
            for (int i=0; i < index-1; i++) {
                prev = prev.getNext();
            }
            Node temp = prev.getNext();
            prev.setNext(temp.getNext());
            size--;
            return temp.getData();
        } 
    }

    public T get(int index) throws Exception {
        if (index < 0 || index > size - 1) {
            throw new Exception();
        }
        if (index == 0) {
            return head.getData();
        } else {
            Node prev = head;
            for (int i=0; i < index; i++) {
                prev = prev.next;
            }
            return prev.getData();
        }
    }

    public int size() {
        return this.size;
    }
}