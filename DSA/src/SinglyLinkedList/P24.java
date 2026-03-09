package SinglyLinkedList;

public class P24 {
        public ListNode swapPairs(ListNode head) {
        /*  this is while loop approach
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;
        while(prev.next!=null &&prev.next.next!=null){
            ListNode first=prev.next;
            ListNode second =first.next;
            first.next=second.next;
            second.next=first;
            prev.next=second;
            prev=first;
        }
        return dummy.next; */
            // RECURSION METHOD APPROACH
            if(head==null || head.next == null){
                return head;
            }
            ListNode prev=head;
            ListNode first=head.next;
            ListNode currNext=first.next;
            first.next=prev;
            prev.next=swapPairs(currNext);
            return first;

        }

}
