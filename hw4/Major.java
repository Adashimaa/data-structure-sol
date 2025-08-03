public class Major {

    private Stack cardStack;
    private Queue ticketQueue;
    public String brandName;

    public Major(String name) {
        this.cardStack = new Stack();
        this.ticketQueue = new Queue();
        this.brandName = name;
    }

    public void addGift(String giftId, String cardName) {
        GiftNode gift = new GiftNode(giftId, cardName);
        cardStack.push(gift);
    }

    public void addTicket(String tickId, String seatId) {
        TicketNode ticket = new TicketNode(tickId, seatId);
        ticketQueue.push(ticket);
    }

    public void processAll() {
        System.out.println("Processed all tickets and all gifts.");
        // START FIX HERE

        while (ticketQueue.top() != null && !cardStack.isEmpty()) {
            // why do we need to print 2 times?
            ticketQueue.top().printNode();
            cardStack.top().printNode();

            ticketQueue.top().printNode();
            cardStack.top().printNode();

            ticketQueue.pop();
            cardStack.pop();
        }

        if (ticketQueue.top() != null) {
            System.out.println("The gift stack is empty, but there are still tickets in the queue.");
        } else {
            System.out.println("Finished!!! There is no remaining queue.");
        }

    }

    public void processOne() {

        if (ticketQueue.top() != null && !cardStack.isEmpty()) {

            // why do we need to print 2 times?
            ticketQueue.top().printNode();
            cardStack.top().printNode();

            System.out.println("Processed one ticket and one gift.");
            ticketQueue.top().printNode();
            cardStack.top().printNode();

            ticketQueue.pop();
            cardStack.pop();
        }
    }

    // NO NEED THIS FIX
    public void showStack() {
        GiftNode currentNode = cardStack.top();
        System.out.print("head ");

        while (currentNode != null) {
            System.out.print("-> ");
            currentNode.printNode();
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    // NO NEED TO FIX
    public void showQueue() {
        TicketNode currentNode = ticketQueue.top();
        System.out.print("head ");
        while (currentNode != null) {
            System.out.print("-> ");
            currentNode.printNode();
            currentNode = currentNode.next;
        }
        System.out.println(" -> tail");
    }
}
