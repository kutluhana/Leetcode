/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {

        if(head == null ||head.next == null){
            return head;
        }
        
        ListNode curr = head;
        ListNode next = head.next;
        ListNode prev = null;

        while(curr != null && next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }

        curr.next = prev;

        return curr;
    }
}

/*

1   ->    2     ->    3     ->    4     ->    5
curr      next

*/
