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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dum = new ListNode(0);
        ListNode head = dum;

        while(list1 != null && list2 != null){
            int val;
            if(list1.val < list2.val){
                val = list1.val;
                list1 = list1.next;
            }
            else{
                val = list2.val;
                list2 = list2.next;
            }

            head.next = new ListNode(val);
            head = head.next;
        }

        ListNode rest = list2 == null ? list1 : list2;
        while(rest != null){
            head.next = new ListNode(rest.val);
            head = head.next;
            rest = rest.next;
        }

        return dum.next;
    }
}