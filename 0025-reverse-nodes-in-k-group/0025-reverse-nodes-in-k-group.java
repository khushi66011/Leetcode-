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

    private ListNode reverse(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;

        while (k-- > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1)
            return head;

        ListNode left = head;
        ListNode prevLeft = null;
        ListNode res = null;

        while (true) {

            ListNode right = left;

            // Find kth node
            for (int i = 0; i < k - 1; i++) {
                if (right == null)
                    break;
                right = right.next;
            }

            // Less than k nodes remaining
            if (right == null) {
                if (prevLeft != null)
                    prevLeft.next = left;

                if (res == null)
                    res = left;

                break;
            }

            ListNode nextLeft = right.next;

            reverse(left, k);

            if (prevLeft != null)
                prevLeft.next = right;

            if (res == null)
                res = right;

            prevLeft = left;
            left = nextLeft;
        }

        return res;
    }
}