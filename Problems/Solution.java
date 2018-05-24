class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        long num1=returnNumber(l1);
        long num2=returnNumber(l2);
        long num3=num1+num2;
        
        
        return returnList(num3);
        
    }
    
    public long returnNumber(ListNode l1){
        
        long num=0;
        long mult=1;
        
        while(l1!=null){
            
            num=num+l1.val*mult;
            mult=mult*10;
            l1=l1.next;
        }
        System.out.println(num);
        return num;
        
    }
    
    
    public ListNode returnList(long num){
        
        String s=num+"";
        ListNode head=null;
        ListNode curr=null;
        
        if(s.length()>0){
            head=new ListNode(Character.getNumericValue(s.charAt(s.length()-1)));
        }
        
        curr=head;
        
        for(int i=s.length()-2;i>-1;i--){
         
            curr.next=new ListNode(Character.getNumericValue(s.charAt(i)));
            curr=curr.next;
        }
        
        return head;
    }
    
}