public class Tree extends BTreePrinter { // Fix this
  Node root;

  public Tree(Node root) {
    this.root = root;
  }

  public Tree() {} // Dummy constructor (No need to edit)

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
    }
    // if (search_key > node.key) {
    //   return findKey(node.right, search_key);
    // };
      return findKey(node.right, search_key);
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

  public static Node findNext(Node node) {
    if (node.right != null) {
      return leftDescendant(node.right);
    }
    return rightAncestor(node);
  }

  public static Node leftDescendant(Node node) { // Case 1 (findMin)

    if (node.left != null) {
      return leftDescendant(node.left);
    }
    return node;
  }

  public static Node rightAncestor(Node node) { // Case 1 (first right parent)

    if (node == null || node.parent == null) {
      return null;
    }

    if (node.key < node.parent.key) {
      return node.parent;
    }
    return rightAncestor(node.parent);
  }

  // This function is for deleting the root node
  // If the node is not the root, please call the recursive version
  public void deleteKey(int key) {

    // 1. Empty tree -> แจ้ง error ว่า Empty Tree!!
    if (root == null) {
      System.out.println("Empty Tree!!!");
      return;
    };

    Node fnode = findKey(key);
    if (fnode == null) {
      System.out.println("Key not found!!!");
      return;
    }

    if (root.key != key) {
      deleteKey(fnode);
      return;
    }

    // 2. Root without a child
    if (root.left == null && root.right == null) {
      root = null;
      return;
    }

    //3-4. Root with a single child 
    // root with left child
    if (root.left != null && root.right == null) {
      root.key = root.left.key;
      root.left = null;
      // root = null;
      return;
    }
    // root with right child
    if (root.left == null && root.right != null) {
      root.key = root.right.key;
      root.right = null;
      // root = null;
      return;
    }

    // 5. Full root
    if (root.left != null && root.right != null) {
      root.key = root.right.key;
      root.right = null;
      return;
    }

    // There should be 6 cases here
    // Non-root nodes should be forwarded to the static function
  }

  // Use this function to delete non-root nodes
  public static void deleteKey(Node node) {
    // There should be 7 cases here


    // 7-8. Node without a child (node อยู่ทางซ้าย หรือทางขวาของ parent) -> ให้ลบ node นี้ได้เลย โดยตัดสายกับ parent แต่ต้องตัดให้ถูกทางนะครับ (parent อยู่ทางซ้าย หรือขวาของ node)
    if (node.left == null && node.right == null) {
      if (node.parent.left != null && node.parent.left.key == node.key) {
        node.parent.left = null;
      } else if (node.parent.right != null && node.parent.right.key == node.key) {
        node.parent.right = null;
      }
      return;
    }
    // 9-12. Node with a single child -> ตามหลักคือโปรโมทลูกขึ้นมาแทนมัน ประเด็นคือ มันจะความเป็นไปได้อยู่ 4 กรณี คือ parent อยู่ซ้ายหรืออยู่ขวา ลูกของมันอยู่ซ้ายหรืออยู่ขวา จึงต้องผูกให้ถูกทาง
    if (node.right != null && node.left == null) {
      node.key = node.right.key;
      if (node.right.right == null) {
        node.right = null;
      } else if (node.right.left != null && node.right.right != null) {
        node.left = node.right.left;
        node.right = node.right.right;
      }
      return;
    } else if (node.right == null && node.left != null) {
      node.key = node.left.key;
      if (node.left.left == null) {
        node.left = null;
      } else if (node.left.left != null && node.left.right != null) {
        node.left = node.left.left;
        node.right = node.left.right;
      }
      return;
    }
    // 13. Full node -> ให้หา min ของ right-subtree เอา key มาเขียนทับ key ของ node เลย (กรณีนี้ ไม่จำเป็นต้องแก้สายผูกสายเสียใหม่ จึงไม่จำเป็นต้องพิจารณาว่าอยู่ด้านใดของ parent) ส่วน min node ที่ว่านั้น ก็ลบทิ้งแบบ recursive
    Node next = findNext(node);
    //3-4. Root with a single child 
    // root with left child
    node.key = next.key;
    deleteKey(next);

  }

}