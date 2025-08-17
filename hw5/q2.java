public static Node constructTree1() {
  Node root = new Node(3); // Fix this
  root.left = new Node(7);

  root.left.left = new Node(2);
  root.left.right = new Node(6);

  root.left.right.left = new Node(1);
  root.left.right.right = new Node(8);

  root.right = new Node(5);
  root.right.right = new Node(9);
  root.right.right.left = new Node(4);

  return root;
}