import static java.util.Arrays.asList;
import java.util.List;
import java.util.Arrays;
class Solutions {
    /* Tortoise and hare pointers:
     *  Original idea: Find length of list and subtract n to find location to skip
     *  Better Idea: create a gap of n length between two pointers, then when hare
     *      pointer reaches end, the tortoise pointer is in the right spot to skip
     *
     */
    // Example : 1 -> 2 -> 3 -> 4 -> 5, n = 2
    //  return : 1 -> 2 -> 3 -> 5
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;
        // Move fast in front so the gap between slow and fast becomes n
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // if fast is null, we're removing head
        if (fast == null) {
            return head.next;
        }
        // Move fast to the end, maintaining the gap
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // Skip the desired node
        slow.next = slow.next.next;
        return head;
    }

    /* Original Idea: Two pointers + stack
     * Update: Don't need stack and can just reverse and merge'
     *
     */
    // Example: 1 -> 2 -> 3 -> 4 -> 5
    //  change: 1 -> 5 -> 2 -> 4 -> 3
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        // Step 1. cut list to two halves
        // prev will be the tail of 1st half
        // slow will be the head of 2nd half
        ListNode prev = null, slow = head, fast = head, l1 = head;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        // Step 2. reverse 2nd half
        ListNode l2 = reverse(slow);

        // Step 3. merge the two halves
        merge(l1, l2);
    }

    // Modifies original head
    private static ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head, next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Merges two linkedlists in alternating order
    private static void merge(ListNode l1, ListNode l2) {
        while (l2 != null) {
            ListNode next = l1.next;
            l1.next = l2;
            l1 = l1.next;
            l2 = next;
        }
    }

    private static ListNode linkedList(List<Integer> list) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        for (int num : list) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return head.next;
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        ListNode test = linkedList(list);
        print(test);
    }
}
