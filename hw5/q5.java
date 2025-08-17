public class Queue {

    Node[] arr; // circular Queue
    int capacity;
    int front;
    int back;
    int size;

    public Queue(int cap) {
        this.arr = new Node[cap];
        this.capacity = cap;
        this.size = 0;
        this.front = 0;
        this.back = 0;
    }

    public void enqueue(Node node) {
        if (!isFull()) {
            arr[size] = node;
            size++;
            back++;
        } else {
            System.out.println("Queue Overflow!!!");
        }
    }

    public Node dequeue() {

        if (!isEmpty()) {
            Node temp = arr[front];
            front++;
            return temp;
        } else {
            System.out.println("Queue Underflow!!!");
        }
        return null; // fix this (out of place)
    }

    public boolean isEmpty() {
        return size == 0; // fix this
    }

    public boolean isFull() {
//        System.out.printf("size=%d capacity=%d \n", size, capacity);
        return size == capacity; // fix this
    }

    public void printCircularIndices() {
        System.out.println("Front index = " + front + " Back index = " + back);
    }

    public void printQueue() {
        if (!isEmpty()) {
            System.out.print("[Front] ");
            for (int i = front; i < back; i++) {
                System.out.printf(arr[i].data + " ");
            }
            System.out.println("[Back]");
        } else {
            System.out.println("Empty Queue!!!");
        }
    }
}
