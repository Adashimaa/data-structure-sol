public class Queue {
    // Implement Queue using Linked List with tail

    TicketNode head;
    TicketNode tail;

    public void push(TicketNode node) {
        //START FIX HERE
        if (head == null) {
            head = node;
            tail = node;
        } else {
            // Do something (Non-empty list)
            head.next = node;
            tail = node;
        }
        //END FIX HERE
    }

    public void pop() {
        if (head != null) {
            if (head != tail) {
                // Do something (List of many nodes)
                head = head.next;
            } else {
                head = null;
                tail = null;
            }
        } else {
            System.out.println("Error: Queue Underflow");
        }
    }

    public TicketNode top() {

        return head;
        //END FIX HERE
    }

}
