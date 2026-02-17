package SinglyLinkedList;

public class P206 {
    /**
     * Problem: Reverse Linked List (LeetCode 206)
     * Definition:
     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     *
     * Algorithm: Iterative Approach
     * 1. Initialize three pointers:
     *    - `prev` as null (this will become the new tail of the reversed list).
     *    - `curr` as head (the current node we are processing).
     *    - `next` (to temporarily store the next node before we break the link).
     *
     * 2. Iterate through the list while `curr` is not null:
     *    - Store the next node: `next = curr.next`.
     *    - Reverse the link: `curr.next = prev`.
     *    - Move `prev` forward: `prev = curr`.
     *    - Move `curr` forward: `curr = next`.
     *
     * 3. At the end of the loop, `prev` will point to the new head of the reversed list.
     *
     * Time Complexity: O(n) - We visit each node once.
     * Space Complexity: O(1) - We use constant extra space.
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        P206 p = new P206();
        System.out.println("Original List:");
        printList(head);

        ListNode reversedHead = p.reverseList(head);

        System.out.println("Reversed List:");
        printList(reversedHead);
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
