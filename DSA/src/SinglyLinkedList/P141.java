package SinglyLinkedList;

public class P141 {
    /**
     * Problem: Linked List Cycle (LeetCode 141)
     *
     * Algorithm (Tortoise and Hare):
     * Think of two runners on a track: a slow one (Tortoise) and a fast one (Hare).
     * The slow runner moves 1 step at a time, while the fast runner moves 2 steps.
     * If the track is a straight line, the fast runner reaches the end.
     * If the track is a loop (cycle), the fast runner will eventually catch up to the slow runner from behind.
     * So, if they meet, there's a cycle. If the fast runner hits the end, there isn't.
     */
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null) return false;
        ListNode slow =head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        P141 p = new P141();

        // Case 1: List with a cycle
        // 3 -> 2 -> 0 -> -4 -> (back to 2)
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Cycle here

        System.out.println("List 1 has cycle: " + p.hasCycle(head));

        // Case 2: List without a cycle
        // 1 -> 2 -> null
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        System.out.println("List 2 has cycle: " + p.hasCycle(head2));
    }
}
