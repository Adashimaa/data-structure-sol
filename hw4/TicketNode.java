public class TicketNode {

    public String tickId;
    public String seatId;
    public TicketNode next;

    public TicketNode(String tickId, String seatId) {
        this.tickId = tickId;
        this.seatId = seatId;
    }

    public void printNode() {
        System.out.println("Ticket ID: " + tickId + ", Seat ID: " + seatId);
    }

}
