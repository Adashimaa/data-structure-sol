public class Node extends BTreePrinter {

    Node left;
    Node right;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public void printTree() {
        // uncomment the following line and fix the errors
        super.printTree(this);
    }

    public void printBFT() {
        if (this == null) {
            return;
        }
        Queue q = new Queue(50);
        System.out.print("BFT node sequence [ ");
        q.enqueue(this);
        while (!q.isEmpty()) {
            Node current = q.dequeue();
            if (current == null) {
                break;
            }
            System.out.printf(current.data + " ");

            if (current.left != null) {
                q.enqueue(current.left);
            }
            if (current.right != null) {
                q.enqueue(current.right);

            }
        }

        System.out.println("]");
    }

    public void printDFT() { // PreOrder
        Stack s = new Stack(50);
        s.push(this);
        System.out.print("DFT node sequence [ ");

        while (!s.isEmpty()) {
            Node current = s.pop();

            System.out.printf(current.data + " ");

            if (current.right != null) {
                s.push(current.right);
            }

            if (current.left != null) {
                s.push(current.left);
            }

        }

        System.out.println("]");
    }
}
