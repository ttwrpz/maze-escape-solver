public class CellQueue {

    private Node front;
    private Node rear;
    private int size;

    public CellQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public void enqueue(Cell cell) {
        Node newNode = new Node(cell);

        if (isEmpty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }

        rear = newNode;
        size++;
    }

    public Cell dequeue() {
        if (isEmpty()) {
            return null;
        }

        Cell data = front.getData();
        front = front.getNext();
        size--;

        if (isEmpty()) {
            rear = null;
        }

        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return size;
    }

    public Cell peek() {
        if (isEmpty()) {
            return null;
        }
        return front.getData();
    }
}