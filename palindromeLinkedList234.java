/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        ListNode slow = head, fast = head, prev = null, tmp = null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            tmp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = tmp;
        }
        if(fast != null){
            slow = slow.next;
        }
        while(slow != null && slow.val == prev.val){
            slow = slow.next;
            prev = prev.next;
        }
        return slow == null;
    }
}
//slow fast, and slow prev reverse
