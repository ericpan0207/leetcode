class Solutions {
    /* Tortoise and hare pointers:
     *  Original idea: Find length of list and subtract n to find location to skip
     *  Better Idea: create a gap of n length between two pointers, then when hare
     *      pointer reaches end, the tortoise pointer is in the right spot to skip
     * 
     */
    // Example : 1 -> 2 -> 3 -> 4 -> 5, n = 2
    //  return : 1 -> 2 -> 3 -> 5
    public ListNode removeNthFromEnd(ListNode head, int n) {
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
}
