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

  public Node findKey(int search_key) {
    return findKey(root, search_key);
  }

  public static Node findKey(Node node, int search_key) {

    if (node == null) {
      return null;
    }

    if (node.key == search_key) {
      return node;
    };
    if (search_key < node.key) {
      return findKey(node.left, search_key);
    } else if (search_key > node.key) {
      return findKey(node.right, search_key);
    };
    return null;
  }

  public Node findMin() {
    return findMin(root); // Call the recursive version
  }

  public static Node findMin(Node node) {
    if (node == null) {
      return null;
    }
    if (node.left == null) {
      return node;
    }
    return findMin(node.left);
  }

  public Node findMax() {
    return findMax(root); // Call the recursive version
  }

  public static Node findMax(Node node) {

    if (node == null) {
      return null;
    }
    if (node.right == null) {
      return node;
    }
    return findMax(node.right);
  }

  public Node findClosestLeaf(int search_key) {
    return findClosestLeaf(root, search_key); // Call the recursive version
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

  public Node findClosest(int search_key) {
    // Please use while loop to implement this function
    // Try not to use recursion

    Node current, closest;
    closest = current = root;
    int min_diff = Integer.MAX_VALUE;

    while (current != null) {

      int diff = Math.abs(search_key - current.key);
      if (diff < min_diff) {
        closest = current;
        min_diff = diff;
      }

      if (search_key < current.key) {
        current = current.left;
      } else if (search_key > current.key) {
        current = current.right;
      } else {
        closest = current;
        break;
      }
    }

    // Use while loop to traverse from root to the closest leaf

    return closest;
  }

  // Print node's key
  public static void printNode(Node node) {
    if (node == null) {
      System.out.println("Node not found!!!");
      return;
    }
    System.out.println(node.key);
  }

  public Tree() {} // Dummy constructor (No need to edit)
}