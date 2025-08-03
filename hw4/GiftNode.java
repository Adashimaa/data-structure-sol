public class GiftNode {
  public String giftId;
  public String cardName;
  GiftNode next;

    public GiftNode(String giftId, String cardName) {
        this.giftId = giftId; 
        this.cardName = cardName;
    }

    public void printNode() {
        System.out.println("Gift ID: " + giftId + ", Card Name: " + cardName);
    }
}
