
public class DoublyLinkedList {

    Node head;
    Node tail;
    String listName;

    public DoublyLinkedList(String name) {
        this.listName = name;
    }

//    -- Need to fix here --
    public void popTail() {
        //START FIX HERE
        if (isEmpty()) {
            System.out.println("ERROR");
        } else {
            if (head == tail) {
                head = null;
                tail = null;
                return;
            }

            tail = tail.previous;
            tail.next = null;
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
    }

    public Node getHead() {
        //START FIX HERE
        if (isEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return head;
        }
        //END FIX HERE
    }

    public Node getTail() {
        //START FIX HERE
        if (isEmpty()) {
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node current = head;
            while (current != null) {
                if (current.next == null) {
                    tail = current;
                    break;
                }
                current = current.next;
            }
            return tail;
        }
    }

    public void pushHead(Node node) {
        if (isEmpty()) {
            head = node;
        } else {
            node.next = head;
            head.previous = node;
            head = node;
            getTail();
        }
    }

    public void pushTail(Node node) {
        if (isEmpty()) {
            head = node;
        } else {
            Node current = head;

            while (current != null) {
                if (current.next == null) {
                    current.next = node;
                    node.previous = current;
                    tail = node;
                    break;
                }
                current = current.next;
            }
        }
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
            while (current != null) {
                if (current.heroId == id) {

                    Node prev = current.previous;
                    if (prev == null) {
                        head = current.next;
                        current.next.previous = null;
                        return current;
                    } else {
                        prev.next = current.next;
                        current.previous = prev;
                    }
                    return current;
                }
                current = current.next;
            }

            return new Node("Hero Not Found!");
        }
        //END FIX HERE
    }

    public void addNodeAfter(Node node1, Node node2) {
        node2.next = node1.next;
        node2.previous = node1;
        node1.next.previous = node2;
        node1.next = node2;

    }

    public void addNodeBefore(Node node1, Node node2) {
        node1.previous.next = node2;
        node2.previous = node1.previous;
        node2.next = node1;
        node1.previous = node2;
    }

    public boolean isEmpty() {
        //START FIX HERE
//        System.out.printf("isEmpty = %s\n", this.head == null);
        return this.head == null;
        //END FIX HERE
    }

    public void merge(DoublyLinkedList list) {
        if (list.isEmpty()) {
            return;
        }
        tail.next = list.head;
        list.head.previous = tail;
    }

    public void printStructure() {
        //START FIX HERE

        System.out.print(listName + ": head <-> ");
        Node current = head;
        while (current != null) {
            System.out.printf("{%d} <-> ", current.heroId);
            current = current.next;
        }

        System.out.println("tail");
        //END FIX HERE
    }

    // This may be useful for you for implementing printStructure()
    public void printStructureTailward() {
        Node current = tail;
        System.out.print(listName + ": tail <-> ");
        while (current != null) {
            System.out.print("{" + current.heroId + "} <-> ");
            current = current.previous;
        }
        System.out.println("head");
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
