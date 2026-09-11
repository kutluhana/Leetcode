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
    public int pairSum(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head.next;

        if(fast.next == null) {
            return fast.val + slow.val;
        }

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode curr = slow.next;
        ListNode next = slow.next.next;
        ListNode prev = null;

        while(next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }

        curr.next = prev;

        int max = Integer.MIN_VALUE;
        fast = curr;
        slow = head;

        while(fast != null) {
            max = Math.max(max, fast.val + slow.val);

            fast = fast.next;
            slow = slow.next;
        }

        return max;

    }
}