public class Queue {

    Node[] arr; // circular Queue
    int capacity;
    int front;
    int back;
    int size;

    public Queue(int capacity) {
        this.capacity = capacity;//Set capacity of this queue
        arr = new Node[capacity];//create arry to keep element of queue
        front = 0;//front that point to index 0 of array
        back = -1;//back that point ont of arry until enqueue
        size = 0;//set zero by defult
    }

    public void enqueue(Node node) {
        if (!isFull()) {
            /*if this queue isn't full that can push element to queue*/
            back = (back + 1) % capacity;
            /*set back to point the bottom of queue and modulo back by capacity for make this arry to circular array*/
            arr[back] = node;//set value of bottom of queue
            size++;//update volume of this queue (increase)
        } else {
            /*if this queue is full show error Queue Overflow!!!*/
            System.out.println("Queue Overflow!!!");
        }
    }

    public Node dequeue() {
        if (!isEmpty()) {
            /*if this queue isn't empty can dequque this queue*/
            Node temp = arr[front];//create temp to keep node that front of queue
            front = (front + 1) % capacity;
            /*set front to point next node of queue and modulo front by capacity for make this arry to circular array*/
            size--;//update volume of this queue (reduce)
            return temp;//return node that temp keep
        } else {
            /*if this queue is empty show error Queue Underflow!!!*/
            System.out.println("Queue Underflow!!!");
        }
        return null; 
    }

    public boolean isEmpty() {
        /*if this queue is empty that mean tihs queue don't have element size will equal 0*/
        return size == 0;  //return size equal 0 ? that ture or false
    }

    public boolean isFull() {
        /*if this  queue is full that mean volume equal capacity (size == capacity)*/
        return size == capacity; //return that size equal capacity is true or false
    }

    public void printCircularIndices() {
        System.out.println("Front index = " + front + " Back index = " + back);
    }

    public void printQueue() {
        if (!isEmpty()) {
            /*if this isn't empty that can show all element*/
            System.out.print("[Front] ");
            int current = front;//create current for point to element of queue set defult to front position
            for (int i = 0; i < size; i++) {
                //for loop until show all element already
                System.out.print(arr[current].data + " ");//show that node value current point to.
                current = (current + 1) % capacity;
                //change current to next position and modulo by capacity to prevent current out of index array.
            }
            System.out.println("[Back]");
        } else {
            /*if this is empty show this Empty Queue!!!*/
            System.out.println("Empty Queue!!!");
        }
    }
}