public class SinglyLinkedList {

    Node head;
    String listName;

    public SinglyLinkedList(String name) {
        this.listName = name;
    }

    public void popTail() {
        //START FIX HERE
        if (isEmpty()) {
            System.out.println("ERROR");
        } else {
            Node current = head;
            while (current != null) {

                if (current.next == null) {
                    head = null;
                    break;
                }

                if (current.next.next == null) {
                    current.next = null;
                    break;
                }
                current = current.next;
            }
        }
        //END FIX HERE
    }

    public void popHead() {
        //START FIX HERE
        if (isEmpty()) {
            System.out.println("ERROR");
        } else {
            head = head.next;
        }
        //END FIX HERE
    }

    public Node getHead() {
        if (isEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return head;
        }
    }

    public Node getTail() {
        //START FIX HERE
        if (isEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node current = head;
            Node tail = head;
            while (current != null) {

                if (current.next == null) {
                    tail = current;
                }
                current = current.next;
            }
            return tail;
        }
    }

    public void pushHead(Node node) {
        //START FIX HERE
        if (isEmpty()) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        //END FIX HERE
    }

    public void pushTail(Node node) {
        //START FIX HERE
        if (isEmpty()) {
            head = node;
        } else {
            Node current = head;
            while (current != null) {
                if (current.next == null) {
                    current.next = node;
                    break;
                }
                current = current.next;
            }
        }
        //END FIX HERE
    }

    public Node findNode(int id) {
        //START FIX HERE
        if (isEmpty()) {
            return new Node("Empty List!");
        } else {

            Node current = head;
            while (current != null) {

                if (current.heroId == id) {
                    return current;
                }
                current = current.next;
            }
            return new Node("Hero Not Found!");
        }
        //END FIX HERE
    }

    public Node eraseNode(int id) {
        //START FIX HERE
        if (isEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {

            Node current = head;
            Node target = new Node("Hero Not Found!");;
            while (current != null) {

                if (head.heroId == id) {
                    target = head;
                    head = head.next;
                    break;
                } else if (current.next != null && current.next.heroId == id) {
                    target = current.next;
                    current.next = current.next.next;
                    break;
                }

                current = current.next;
            }

            return target;
        }
        //END FIX HERE
    }

    public void addNodeAfter(Node node1, Node node2) {
        node2.next = node1.next;
        node1.next = node2;
    }

    public void addNodeBefore(Node node1, Node node2) {
        Node current = head;
        while (current != null) {
            if (current.next != null && current.next.heroId == node1.heroId) {
                node2.next = node1;
                current.next = node2;
                break;
            }
            current = current.next;
        }

    }

    public boolean isEmpty() {
        return head == null;
    }

    public void merge(SinglyLinkedList list) {
        //START FIX HERE
        if (list.isEmpty()) {
            return;
        }
        Node tail = getTail();
        tail.next = list.head;
    }

    /**
     *
     */
    public void printStructure() {
        Node nodeIndex = this.head;
        System.out.print(listName + ": head -> ");

        while (nodeIndex != null) {
            System.out.print("{" + nodeIndex.heroId + "} -> ");
            nodeIndex = nodeIndex.next;
        }

        System.out.println("null");
    }

    public Node getHighestPowerHero() {
        //START FIX HERE
        if (isEmpty()) {
            return new Node("Empty List!");
        } else {

            Node max = head;
            Node current = head;
            while (current != null) {
                if (max.power < current.power) {
                    max = current;
                }
                current = current.next;
            }

            return max;
        }
    }
}
