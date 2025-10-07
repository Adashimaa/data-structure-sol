/**
 *
 * @author sapondanai
 */

class Node {

  String name;
  int value; // คะแนนความสามารถ
  long timestamp;
  boolean isAmerican; // ถือสัญชาติอเมริกาหรือไม่
  int salary; // ค่าจ้าง

  /**
   * คำนวณเงินเดือนรวมต่อปี
   * - ถ้าไม่ใช่สัญชาติอเมริกา จะได้โบนัสเพิ่ม 100,000
   * @return เงินเดือนรวมทั้งปี
   */
  public int getTotalAnnualSalary() {
    var total = salary;
    if (!isAmerican) {
      total += 100000; // โดนบวกเพิ่มเพราะไม่ใช่คน isAmerican 💀💀💀
    }
    return total;
  }

  public Node(String name, int value, boolean isAmerican, int salary) {
    this.name = name;
    this.value = value;
    this.isAmerican = isAmerican;
    this.salary = salary;
  }

  // This function will return true if Priority(thisNode) > Priority(otherNode)

  // this node = parent node

  /**
   * เปรียบเทียบ priority ระหว่าง node นี้กับ node อื่น
   * @param other node ที่ต้องการเปรียบเทียบ
   * @param isMinHeap true = min heap, false = max heap
   * @return true ถ้า node นี้มี priority สูงกว่า node อื่น
   * 
   * หลักการเปรียบเทียบ:
   * 1. ถ้า value เท่ากัน -> เปรียบเทียบด้วย salary (น้อยกว่าชนะ)
   * 2. ถ้า salary เท่ากัน -> เปรียบเทียบด้วย value (มากกว่าชนะ)
   * 3. ถ้าไม่เท่ากันทั้งคู่:
   *    - MinHeap: เปรียบเทียบด้วย salary (น้อยกว่าชนะ)
   *    - MaxHeap: เปรียบเทียบด้วย value (มากกว่าชนะ)
   */
  public boolean compare(Node other, boolean isMinHeap) {
    // กรณีที่ 1: value เท่ากัน -> ใช้ salary ตัดสิน (น้อยกว่าชนะ)
    if (this.value == other.value) {

      return getTotalAnnualSalary() < other.getTotalAnnualSalary(); // FIX THIS
    }

    // กรณีที่ 2: salary เท่ากัน -> ใช้ value ตัดสิน (มากกว่าชนะ)
    else if (getTotalAnnualSalary() == other.getTotalAnnualSalary()) {
      return this.value > other.value; // FIX THIS
    }
    // กรณีที่ 3: ไม่เท่ากันทั้งคู่
    else {

      // Min Heap: salary น้อยกว่าจะชนะ

      if (isMinHeap) {
        return getTotalAnnualSalary() < other.getTotalAnnualSalary(); // FIX THIS
      } else if (!isMinHeap) { // maxHeap
        // Max Heap: value มากกว่าชนะ

        return this.value > other.value; // FIX THIS
      } else {
        // ไม่เข้ากรณีไหนเลย ใช้ timestamp (เก่ากว่าชนะ)

        return this.timestamp < other.timestamp;
      }
    }
  }

  public Node() {} // Dummy constructor, no need to edit

  @Override
  public String toString() {
    return "Name: " + name +
      ", Value: " + Integer.toString(value) +
      ", Salary: " + Integer.toString(salary) +
      ", IsAmerican: " + Boolean.toString(isAmerican) +
      ", Total Annual Salary: " + Integer.toString(getTotalAnnualSalary()) +
      ", Timestamp: " + Long.toString(timestamp);
  }
}