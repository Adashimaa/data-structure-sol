public class Tree extends BTreePrinter { // Fix this
  Node root;

  public Tree(Node root) {
    this.root = root;
  }

  public void printTree() {
    if (this.root == null) {
      System.out.println("Empty tree!!!");
      return;
    }
    super.printTree(root);
  }

  public static void printNode(Node node) {
    if (node == null) {
      System.out.println("Node not found!!!");
      return;
    }
    System.out.println(node.key);
  }

  public static Node findClosestLeaf(Node node, int search_key) {

    if (node == null) {
      return null;
    }

    if (search_key < node.key) {
      if (node.left == null) {
        return node;
      }
      return findClosestLeaf(node.left, search_key);
    } else if (search_key > node.key) {

      if (node.right == null) {
        return node;
      }
      return findClosestLeaf(node.right, search_key);
    }
    return node;
  }

  public void insertKey(int key) {
    // Implement insertKey() using the non-recursive version
    // This function should call findClosestLeaf()

    if (root == null) {
      root = new Node(key);
      return;
    }

    Node closestLeaf = findClosestLeaf(root, key);

    if (closestLeaf == null) {
      return;
    }

    if (closestLeaf.key == key) {
      System.out.println("Duplicated key!!!");
      return;
    }
    Node newNode = new Node(key);
    if (key < closestLeaf.key) {
      closestLeaf.left = newNode;
      newNode.parent = closestLeaf;
    }
    if (key > closestLeaf.key) {
      closestLeaf.right = newNode;
      newNode.parent = closestLeaf;
    }
  }

  public void printPreOrderDFT() {
    System.out.print("PreOrder DFT node sequence [ ");
    // Call the recursive version
    printPreOrderDFT(root);
    System.out.println("]");
  }

  public static void printPreOrderDFT(Node node) {
    if (node == null) return;
    // visit left right
    System.out.print(node.key + " ");
    printPreOrderDFT(node.left);
    printPreOrderDFT(node.right);
  }

  public void printInOrderDFT() {
    System.out.print("InOrder DFT node sequence [ ");
    // Call the recursive version
    printInOrderDFT(root);
    System.out.println("]");
  }

  public static void printInOrderDFT(Node node) {
    if (node == null) return;
    // left visit right
    printInOrderDFT(node.left);
    System.out.print(node.key + " ");
    printInOrderDFT(node.right);
  }

  public void printPostOrderDFT() {
    System.out.print("PostOrder DFT node sequence [ ");
    // Call the recursive version
    printPostOrderDFT(root);
    System.out.println("]");
  }

  public static void printPostOrderDFT(Node node) {
    if (node == null) return;
    printPostOrderDFT(node.left);
    printPostOrderDFT(node.right);
    System.out.print(node.key + " ");

  }

  public Tree() {} // Dummy constructor (No need to edit)
}