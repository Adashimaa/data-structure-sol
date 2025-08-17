public class Node extends BTreePrinter{ // Fix this line

    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public void printTree() {
        // Understand this line before uncommenting
        super.printTree(this);
    }

}