import java.util.ArrayList;
import java.util.List;

// Implements a minHeap with the add / remove operations
public class Heap {
    List<Integer> minHeap;

    public Heap() {
        minHeap = new ArrayList<Integer>();
    }

    public void add(int val) {
        minHeap.add(val);
        bubbleUp(minHeap.size() - 1);
    }

    public int pop() {
        int min = minHeap.get(0);
        swap(0, minHeap.size() - 1);
        minHeap.remove(minHeap.size() - 1);
        if (minHeap.size() != 0) {
            bubbleDown(0);
        }
        return min;
    }

    public int size() {
        return minHeap.size();
    }

    private void bubbleUp(int index) {
        if (index != 0) {
            int parent = (index - 1) / 2;
            if (minHeap.get(index) < minHeap.get(parent)) {
                swap(index, parent);
                bubbleUp(parent);
            }
        }
    }

    private void bubbleDown(int index) {
        int currVal = minHeap.get(index);
        int leftChild = index * 2 + 1;
        int rightChild = leftChild + 1;

        if (rightChild <= minHeap.size() - 1) {
            int leftVal = minHeap.get(leftChild);
            int rightVal = minHeap.get(rightChild);

            if (leftVal < currVal || rightVal < currVal) {
                if (leftVal < rightVal) {
                    swap(leftChild, index);
                    bubbleDown(leftChild);
                } else {
                    swap(rightChild, index);
                    bubbleDown(rightChild);
                }
            }
        } else if (leftChild <= minHeap.size() - 1) {
            if (minHeap.get(leftChild) < currVal) {
                swap(leftChild, index);
                bubbleDown(leftChild);
            }
        }

    }

    private void swap(int a, int b) {
        int temp = minHeap.get(a);
        minHeap.set(a, minHeap.get(b));
        minHeap.set(b, temp);
    }

}
