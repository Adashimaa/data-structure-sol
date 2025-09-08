public class Tree extends BTreePrinter { // Fix this
    Node root;
      
    public Tree(Node root){
        this.root = root;
    }
    
    public void printTree(){
        if (this.root == null) {
          System.out.println("Empty tree!!!");
          return;
        }
        super.printTree(root);
    }

    public Node findClosest(int search_key){

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
    
    public static Node findNext(Node node){
        if (node.right != null) {
            return leftDescendant(node.right);
        }
        return rightAncestor(node);
    }
    
    public static Node leftDescendant(Node node){// Case 1 (findMin)
        
        if (node.left != null) {
            return leftDescendant(node.left);
        }
        return node;
    }
    
    public static Node rightAncestor(Node node) {// Case 1 (first right parent)
    
        if (node == null || node.parent == null) {
            return null;
        }
    
        if (node.key < node.parent.key) {
            return node.parent;
        }
        return rightAncestor(node.parent);
    }
    
    public List rangeSearch(int x, int y){
        List list = new List(100);
        
        Node node = findClosest(x);

        while (node != null && node.key <= y) {
            if (node.key >=x) {
                list.append(node);
            };
            node = findNext(node);
        }
        // This function utilizes findCloest() and findNext()
        // Use list.append(node) to add node to the list
        return list;
    }
    
    
    public Tree(){} // Dummy constructor (No need to edit)
}