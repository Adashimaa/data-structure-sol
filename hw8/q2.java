/**
 *
 * @author sapondanai
 */
public class Heap {

  private Node[] heap;
  private int size;
  private int capacity;
  private boolean isMinHeap;
  private String name;
  private long timer;

  /**
   * Constructor: สร้าง heap โดยกำหนดประเภท (min/max), ขนาด และชื่อ
   * - Index 0 ไม่ได้ใช้งาน เริ่มจาก index 1 (Complete Binary Tree)
   * - parent = k/2, leftChild = 2k, rightChild = 2k+1
   */
  public Heap(boolean isMinHeap, int capacity, String name) {
    this.heap = new Node[capacity];
    this.isMinHeap = isMinHeap;
    this.capacity = capacity;
    this.name = name;
    this.size = 0;
    // Initialize the heap here
    // Don't forget that we will build the binary heap using...
    // ... the concept of "Complete binary tree based on the heapay implementation"
    // ... The 0 index will not be used, The index starts from 1 (remember?)
  }

  public Node top() {
    return heap[1]; // FIX THIS
  }

  /**
   * เพิ่ม node ใหม่เข้า heap
   * 1. เช็คว่า heap เต็มหรือไม่
   * 2. ใส่ node ที่ตำแหน่งสุดท้าย (size+1)
   * 3. Percolate up: เลื่อนขึ้นไปเรื่อยๆ จนกว่าจะถึง root หรือ parent มี priority สูงกว่า
   */
  public void push(Node node) {

    if (size == capacity) {
      System.out.println("Heap is full!");
      return;
    }

    // Increase timer each time you push something into the Queue
    timer++;
    node.timestamp = timer; // Stamp the time number to the node

    if (isEmpty()) {
      heap[1] = node;
      size++;
    } else {

      // ใส่ node ที่ตำแหน่งสุดท้าย
      heap[size + 1] = node;
      size++;

      // Percolate up: เปรียบเทียบกับ parent และ swap ถ้าจำเป็น
      int k = size;
      int parent;
      while (k > 1) {
        parent = (int) Math.floor(k / 2);

        Node parentNode = heap[parent];
        Node currentNode = heap[k];

        // ถ้า currentNode มี priority สูงกว่า parentNode ให้ทำการ swap และกำหนดค่า k เป็น parent
        if (currentNode.compare(parentNode, this.isMinHeap)) {
          swap(k, parent);
          k = parent;
        } else {
          break;
        }
      }
    }
  }

  /**
   * ลบและคืนค่า node บนสุด (root)
   * 1. เก็บ root ไว้ return
   * 2. เอา node สุดท้ายมาแทนที่ root
   * 3. Percolate down: เลื่อนลงไปเรื่อยๆ โดยเปรียบเทียบกับ children
   *    - เลือก child ที่มี priority สูงกว่ามา swap
   *    - ทำจนกว่าจะไม่มี child หรือ parent มี priority สูงกว่า children
   */
  public Node pop() {
    if (isEmpty()) {
      return null;
    }
    // parent = k/2
    // leftChild = 2k
    // rightChild = 2k+1

    // เก็บ root เพื่อ return
    Node root = top();

    // เอา node สุดท้ายมาแทนที่ root
    heap[1] = heap[size];
    heap[size] = null;
    size--;

    int k = 1; // Start at root

    // Percolate down: เริ่มจาก root
    while (true) {
      int leftChildIndex = (2 * k);
      int rightChildIndex = (2 * k) + 1;

      Node parentNode = heap[k];
      Node leftChild = heap[leftChildIndex];
      Node rightChild = heap[rightChildIndex];

      // กรณีมี child ทั้ง 2 ตัว
      if (leftChild != null && rightChild != null) {
        // เลือก child ที่มี priority สูงกว่า
        if (leftChild.compare(rightChild, this.isMinHeap)) {

          // Check ว่า leftChild มี priority สูงกว่า
          if (leftChild.compare(parentNode, this.isMinHeap)) {
            // ถ้าใช่ให้ทำกับ swap Node และกำหนดค่า k เป็น index ของตัวที่สลับ
            swap(leftChildIndex, k);
            k = leftChildIndex;
          } else {
            break;
          }
        } else {
          // กรณีที่ rightChild มี priority สูงกว่า leftChild ให้เข้ามาทำงานใน block นี้

          // Check ว่า rightChild มี priority สูงกว่า parentNode ไหม
          if (rightChild.compare(parentNode, this.isMinHeap)) {
            // ถ้าใช่ให้ทำกับ swap Node และกำหนดค่า k เป็น index ของตัวที่สลับ

            swap(rightChildIndex, k);
            k = rightChildIndex;
          } else {
            break;
          }
        }

      }

      // กรณีมีเฉพาะ leftChild
      else if (leftChild != null && rightChild == null) {

        // Check ว่า leftChild มี priority สูงกว่า parentNode ไหม

        if (leftChild.compare(parentNode, this.isMinHeap)) {
          // ถ้าใช่ให้ทำกับ swap Node และกำหนดค่า k เป็น index ของตัวที่สลับ

          swap(leftChildIndex, k);
          k = leftChildIndex;
        } else {
          break;
        }
      }

      // กรณีมีเฉพาะ rightChild
      else if (rightChild != null && leftChild == null) {

        // Check ว่า rightChild มี priority สูงกว่า parentNode ไหม

        if (rightChild.compare(parentNode, this.isMinHeap)) {
          // ถ้าใช่ให้ทำกับ swap Node และกำหนดค่า k เป็น index ของตัวที่สลับ

          swap(rightChildIndex, k);
          k = rightChildIndex;
        } else {
          break;
        }
      } else {
        // ไม่มี child เลย
        break;
      }
    }
    // To do:
    // 1. Mark the root for return (Don't forget to return this node)
    // 2. Move the last node to the root (change pointer, set null)
    // 3. Decrease the heap size
    // 4. Sift (percolate) it down the heap
    //      * Check priority of the current node with both children
    //      * Swap the current node if the priority is lower than child
    //      * Repeat the process until the node has no child or there is no swap (Pls use while loop)
    return root; // FIX THIS

  }

  private void swap(int i, int j) {
    Node temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }

  public void printArray() {
    // No need to fix this function
    System.out.printf("-----------------\n%s Heap:\n", name);
    if (isEmpty()) {
      System.out.println("Empty Heap");
    }
    for (int i = 1; i <= size; i++) {
      System.out.printf("%d] %s\n", i, heap[i].toString());
    }
    System.out.print("-----------------\n");
  }

  public boolean isEmpty() {
    return size == 0;
  }
}