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

  public static int height(Node node){
      // Use recursion to implement this function
      // height = length(path{node->deepest child})
      
      if (node == null) {
          return -1;
      }
      
      return 1 + Math.max(height(node.left), height(node.right));
  }
  
  public static int size(Node node){
      // Use recursion to implement this function
      // size = #children + 1(itself)
      
      if (node == null) {
          return 0;
      }
      
      return 1 + size(node.left) + size(node.right);
  }
  
  public static int depth(Node root, Node node){
      // Use recursion to implement this function
      // Similar to height() but start from node, go up to root
      
      if (node == null) {
          return -1; // not found
      }
      if (root == node) {
          return 0;
      }
      
      // depth = length(path{node->root})
      return 1 + depth(root, node.parent);
  }
  
  public int treeHeight(){ // Tree height
      // Hint: call the static function
      return height(root);
  }
  
  public int treeSize(){ // Tree size
      // Hint: call the static function
      return size(root);
  }
  
  public int treeDepth(){ // Tree depth
      // Hint: call the static function
      return height(root);
  }
  
  public Node findKthSmallest(int k){
      return findKthSmallest(root, k); // Call the recursive version
  }
  
  public static Node findKthSmallest(Node node, int k){
      int leftSize = size(node.left);
      
      if (k == leftSize + 1) return node;
      if (k < leftSize + 1) return findKthSmallest(node.left, k);
      if (k > leftSize + 1) return findKthSmallest(node.right, k-leftSize-1);
      return null;
  }
  
  public Tree(){} // Dummy constructor (No need to edit)
}