import java.util.*;

class HeapSolutions {
    // Sorting multiple lists that are already sorted:
    // Place everything into heap O(log n) * O(n) for n num of elements
    // Remove everything from heap O(log n) * O(n) for n num of elements
    //
    // Example: [[1, 4, 5],
    //           [1, 3, 4],
    //           [2, 6]
    //          ]
    // returns: [1, 1, 2, 3, 4, 4, 5, 6]
    public static ListNode mergeKLists(ListNode[] lists) {
        Heap minHeap = new Heap();
        for (ListNode n : lists) {
            while (n != null) {
                minHeap.add(n.val);
                n = n.next;
            }
        }
        if (minHeap.size() == 0) {
            return null;
        }
        ListNode head = new ListNode(minHeap.pop());
        ListNode curr = head;
        while (minHeap.size() > 0) {
            curr.next = new ListNode(minHeap.pop());
            curr = curr.next;
        }
        return head;
    }

    // Original Idea: Map and heap, build maxheap and pop k times
    //   Better Idea: build minHeap and remove when > k, this ensures small heap
    //  Also, one line for map insert
    //
    //  Example: [1, 1, 1, 2, 2, 3], k = 2
    //   Output: [1, 2]
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        // Sort by least freq first
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> (freq.get(n1) - freq.get(n2)));
        for (int num : freq.keySet()) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        List<Integer> topK = new ArrayList<Integer>();
        while (!heap.isEmpty()) {
            topK.add(heap.poll());
        }
        Collections.reverse(topK);
        return topK;
    }

    public static void main(String[] args) {
        // Testing mergeKLists
        // ___________________
        // List<Integer> list1 = Arrays.asList(1, 4, 5);
        // List<Integer> list2 = Arrays.asList(1, 3, 4);
        // List<Integer> list3 = Arrays.asList(2, 6);
        // ListNode n1 = LinkedListSolutions.linkedList(list1);
        // ListNode n2 = LinkedListSolutions.linkedList(list2);
        // ListNode n3 = LinkedListSolutions.linkedList(list3);
        // ListNode[] lists = {n1, n2, n3};

        // ListNode result = mergeKLists(lists);
        // LinkedListSolutions.print(result);
        //
        int[] nums = new int[] {1, 1, 1, 2, 2, 3};
        System.out.println(topKFrequent(nums, 2));
    }
}
