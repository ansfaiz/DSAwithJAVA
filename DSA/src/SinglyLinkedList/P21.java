package SinglyLinkedList;

public class P21 {
    /**
     * Problem: Merge Two Sorted Lists (LeetCode 21)
     *
     * What we need to do:
     * We have two linked lists, and both are already sorted (numbers go from small to big).
     * We want to combine them into one single sorted linked list.
     *
     * Algorithm (The "Zipper" Approach):
     * 1. Create a "dummy" node. This acts as a placeholder for the start of our new list.
     *    We'll use a pointer `temp` to build the list after this dummy node.
     *
     * 2. Look at the current head of both lists (`list1` and `list2`).
     *    - Compare their values.
     *    - Pick the smaller one and attach it to our new list (`temp.next`).
     *    - Move the pointer of the list we picked from forward.
     *    - Move our `temp` pointer forward.
     *
     * 3. Repeat step 2 until one of the lists runs out of nodes.
     *
     * 4. If one list still has nodes left (because it was longer or had larger numbers),
     *    just attach the rest of it to the end of our new list.
     *
     * 5. Return `newHead.next` (skipping the dummy node we created at the start).
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Dummy node to start the result list
        ListNode newHead = new ListNode(0);
        ListNode temp = newHead;

        // Traverse both lists while they both have nodes
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;       // Pick node from list1
                list1 = list1.next;      // Move list1 forward
            } else {
                temp.next = list2;       // Pick node from list2
                list2 = list2.next;      // Move list2 forward
            }
            temp = temp.next;            // Move result pointer forward
        }

        // Attach the remaining part of whichever list is not empty
        if (list1 != null) temp.next = list1;
        if (list2 != null) temp.next = list2;

        return newHead.next;
    }

    public static void main(String[] args) {
        P21 p = new P21();

        // Create first sorted list: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // Create second sorted list: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        System.out.println("List 1:");
        printList(list1);
        System.out.println("List 2:");
        printList(list2);

        // Merge them
        ListNode mergedList = p.mergeTwoLists(list1, list2);

        System.out.println("Merged List:");
        printList(mergedList);
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
