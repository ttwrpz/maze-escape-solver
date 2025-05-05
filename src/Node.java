public class Node {
    private Cell data;
    private Node next;

    public Node(Cell data) {
        this.data = data;
        this.next = null;
    }

    public Cell getData() {
        return data;
    }

    public void setData(Cell data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}