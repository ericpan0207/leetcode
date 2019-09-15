import static java.util.Arrays.asList;
import java.util.List;
import java.util.Arrays;

class HeapSolutions {
    // Sorting multiple lists that are already sorted:
    // Place everything into heap O(log n) * O(n) for n num of elements
    // Remove everything from heap O(log n) * O(n) for n num of elements
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

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 4, 5);
        List<Integer> list2 = Arrays.asList(1, 3, 4);
        List<Integer> list3 = Arrays.asList(2, 6);
        ListNode n1 = LinkedListSolutions.linkedList(list1);
        ListNode n2 = LinkedListSolutions.linkedList(list2);
        ListNode n3 = LinkedListSolutions.linkedList(list3);
        ListNode[] lists = {n1, n2, n3};

        ListNode result = mergeKLists(lists);
        LinkedListSolutions.print(result);

    }
}
