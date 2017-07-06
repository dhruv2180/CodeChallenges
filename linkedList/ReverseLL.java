public class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode root=head;
        if(root==null){
            return root;
        }
        if(root.next==null){
            return root;
        }
        ListNode curr=root.next;
        root.next=null;
        ListNode prev=root;
        ListNode next=null;

        while(curr!=null){

            next=curr.next;
            curr.next=prev;

            prev=curr;
            curr=next;
        }
        return prev;
    }
}
