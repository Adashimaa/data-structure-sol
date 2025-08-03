public class Stack {
    // Implement Stack using Linked List without tail

    GiftNode head;

    // Need to remove this fucntion before submit;
    public void print() {
        GiftNode current = head;
        while (current != null) {
            System.out.println(current.giftId);
            current = current.next;
        }
    }

    public void push(GiftNode node) {
        if (isEmpty()) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    public void pop() {
        if (!isEmpty()) {
            head = head.next;
        } else {
            System.out.println("Error: Stack Underflow");
        }
        // END FIX HERE
    }

    public GiftNode top() {
        return head;
    }

    public Boolean isEmpty() {
        //START FIX HERE
        return head == null;
        // END FIX HERE
    }

}
