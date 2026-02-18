package SinglyLinkedList;

public class P19 {
    /**
     * Problem: Remove Nth Node From End of List (LeetCode 19)
     *
     * Algorithm (Two Pointers):
     * Imagine you want to remove the N-th person from the end of a line.
     * You can use two people, let's call them 'Fast' and 'Slow'.
     *
     * 1. Start both at the beginning (a dummy node before the head).
     * 2. Send 'Fast' ahead by N+1 steps. This creates a gap of N nodes between them.
     * 3. Now, move both 'Fast' and 'Slow' forward one step at a time until 'Fast' reaches the end.
     * 4. Because of the gap, 'Slow' will be exactly right before the node we want to remove.
     * 5. 'Slow' can then just skip over the next node (the one to be removed).
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i <= n && fast != null; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        P19 p = new P19();

        // Create a list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original List:");
        printList(head);

        // Remove the 2nd node from the end (which is 4)
        int n = 2;
        ListNode newHead = p.removeNthFromEnd(head, n);

        System.out.println("List after removing " + n + "th node from end:");
        printList(newHead);
    }

    // Helper method to print the linked list
    private static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}
