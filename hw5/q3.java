public static Node constructTree2() {
  Node root = new Node(1); // Fix this
  root.left = new Node(2);
  root.left.left = new Node(4);
  root.left.right = new Node(5);
  root.left.right.left = new Node(7);
  root.left.right.right = new Node(8);
  root.left.right.right.right = new Node(10);

  root.right = new Node(3);
  root.right.right = new Node(6);
  root.right.right.left = new Node(9);

  return root;
}