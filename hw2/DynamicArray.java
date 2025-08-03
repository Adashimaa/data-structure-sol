public class DynamicArray {

    private int[] arr;
    private int capacity;
    private int size; // Last element can be indexed at size-1

    public DynamicArray(int cap) { // Class Constructor
        arr = new int[cap];
        capacity = cap;
        size = 0;
    }

    public void PushBack(int data) {
        if (size == capacity) {
            int[] newArr = new int[2 * capacity];
            for (int i = 0; i < size; i++) {
                newArr[i] = arr[i];
            }
            capacity *= 2;
            arr = newArr;
        }
        arr[size] = data;
        size++;
    }

    public int PopBack() {
        if (size == 0) {
            System.out.println("ERROR");
            return 0;
        }
        int temp = arr[size - 1];
        arr[size - 1] = 0;
        size--;
        return temp;
    }

    public int Get(int i) {
        if (i > size - 1) {
            System.out.println("ERROR");
            return 0;
        }
        return arr[i];
    }

    public void Set(int i, int value) {
        if (i > size - 1) {
            System.out.println("ERROR");
            return;
        }
        arr[i] = value;
    }

    public void Remove(int i) {
        if (i > size - 1) {
            System.out.println("ERROR");
            return;
        }
        arr[i] = 0;
        for (int j = i; j < size-1; j++) {
            arr[j] = arr[j + 1];
        }
        PopBack();
    }

    public boolean IsEmpty() {
        return size == 0;
    }

    public int GetSize() {
        return size;
    }

    public void PrintStructure() {
        // START FIX CODE HERE
        System.out.print("Size = " + size + ", Cap = " + capacity + ", arr = [ ");
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                System.out.print(arr[i]);
                continue;
            }
            System.out.print(", " + arr[i]);
        }

        if (size == 0) {
            System.out.print("]");
        } else {
            System.out.print(" ]");

        }
        System.out.println();
    }
}
