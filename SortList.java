

public class SortList
{
    class ListNode
    {
	int      val;
	ListNode next;

	ListNode(int x)
	{
	    val = x;
	}
    }

    public ListNode mergeTwoList(ListNode l1,ListNode l2)
    {
	ListNode fakeHead=new ListNode(0);
        ListNode curr=fakeHead;
        while(l1!=null&&l2!=null)
        {
            if(l1.val<l2.val)
            {
                curr.next=l1;
                l1=l1.next;
            }
            else
            {
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
        }
        if(l1!=null)
        {
            curr.next=l1;
        }
        else if(l2!=null)
        {
            curr.next=l2;
        }
        return fakeHead.next;
    }
    
    public ListNode sortList(ListNode head)
    {
	if(head==null||head.next==null)
	{
	    return head;
	}
	ListNode fast=head;
	ListNode slow=head;
	while(fast.next!=null&&fast.next.next!=null)
	{
	    fast=fast.next.next;
	    slow=slow.next;
	}	
	fast=slow;
	slow=slow.next;
	fast.next=null;
	//·Ö¶ÎÅÅÐò
	ListNode l1=this.sortList(head);
	ListNode l2=this.sortList(slow);
	return this.mergeTwoList(l1,l2);
    }
}
