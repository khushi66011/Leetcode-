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

    // Reverse exactly k nodes starting from 'head'
    // Example: 1->2->3 , k=2
    // becomes : 2->1->3
    private ListNode reverse(ListNode head, int k) {

        ListNode prev = null;
        ListNode curr = head;

        while (k-- > 0) {

            // Store next node
            ListNode next = curr.next;

            // Reverse link
            curr.next = prev;

            // Move prev and curr forward
            prev = curr;
            curr = next;
        }

        // prev becomes new head after reversing
        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        // Empty list or k=1 => no changes needed
        if (head == null || k == 1)
            return head;

        // left = starting node of current group
        ListNode left = head;

        // Tail of previous reversed group
        ListNode prevLeft = null;

        // Final head of answer
        ListNode res = null;

        while (true) {

            // right will move to kth node
            ListNode right = left;

            // Find kth node of current group
            for (int i = 0; i < k - 1; i++) {

                // Less than k nodes exist
                if (right == null)
                    break;

                right = right.next;
            }

            // Not enough nodes to reverse
            if (right == null) {

                // Connect previous group with remaining nodes
                if (prevLeft != null)
                    prevLeft.next = left;

                // If nothing was reversed yet
                if (res == null)
                    res = left;

                break;
            }

            // Save starting node of next group
            ListNode nextLeft = right.next;

            // Reverse current group
            reverse(left, k);

            // Connect previous reversed group
            // with current reversed group
            if (prevLeft != null)
                prevLeft.next = right;

            // First reversed group's head
            // becomes answer head
            if (res == null)
                res = right;

            // After reversal,
            // 'left' becomes tail of current group
            prevLeft = left;

            // Move to next group
            left = nextLeft;
        }

        return res;
    }
}