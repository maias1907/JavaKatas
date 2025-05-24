package ArraysAndStrings;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        int carry=0;
        ListNode duppy=new ListNode(0);
        ListNode current=duppy;



        while(l1!=null && l2!=null)
        {
            int num=(l1.val+l2.val+carry)%10;
            carry=(l1.val+l2.val+carry)/10;
            current.next=new ListNode(num);
            current=current.next;
            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null)
        {
            int num=(l1.val+carry)%10;
            carry=(l1.val+carry)/10;
            current.next=new ListNode(num);
            current=current.next;
            l1=l1.next;
        }
        while(l2!=null)
        {
            int num=(l2.val+carry)%10;
            carry=(l2.val+carry)/10;
            current.next=new ListNode(num);
            current=current.next;
            l2=l2.next;
        }
        if(carry!=0 && l1==null && l2==null)
        {
            current.next=new ListNode(carry);
            //current=current.next;
        }
        return duppy.next;
    }
}
