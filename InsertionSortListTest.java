
public class InsertionSortListTest
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

    public ListNode insertionSortList(ListNode head)
    {
	if(head==null||head.next==null)
	{
	    return head;
	}
	ListNode first=head;
	//��ǰ���ڴ���Ľڵ�
	ListNode curr=head.next;
	first.next=null;
	//��ǰָ��
	ListNode p=head;
	while(curr!=null)
	{
	    ListNode temp=curr.next;
	    if(curr.val<=first.val)
	    {
		curr.next=first;
		first=curr;
	    }
	    else
	    {
		while(p.next!=null)
		{
		    if(p.val<=curr.val&&p.next.val>curr.val)
		    {
			curr.next=p.next;
			p.next=curr;
			break;
		    }
		    else 
		    {
			 p=p.next;
		    } 
		}
		if(p.next==null&&p.val<=curr.val)
		{
		    p.next=curr;
		    curr.next=null;
		}
	    }
	    curr=temp;
	    //ָ�븴λ
	    p=first;
	}
	return first;
    }

    public static void main(String[] args)
    {
	// TODO �Զ����ɵķ������
    }
}
