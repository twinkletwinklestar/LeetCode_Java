/***
 * �ϲ�k�������б�
 * 
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList
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

    /***
     * �ϲ�k���������� ʹ��
     * 
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists)
    {
	if (lists.length == 0 || lists == null)
	{
	    return null;
	}
	/***
	 * ʹ��PriorityQueue���洢ListNode�ڵ�
	 * �����ڹ���������ʱÿ��ֻ��Ҫ�ڵ�ǰ��������ȡͷ�ڵ���С��ֵ
	 * ����Queue�Ĵ�СΪlists.length
	 */
	PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length,
		new Comparator<ListNode>()
		{
		    @Override
		    public int compare(ListNode o1, ListNode o2)
		    {
			if(o1.val>o2.val)
			{
			    return 1;
			}
			else if(o1.val<o2.val)
			{
			    return -1;
			}
			else 
			{
			    return 0;
			}
		    }
		});
	
	//����ǰ���������ͷ�ڵ���ӽ�Queue
	for(int i=0;i<lists.length;i++)
	{
	    if(lists[i]!=null)
	    {
		queue.add(lists[i]);
	    }	    
	}
	ListNode head=new ListNode(0);
	ListNode curr=head;
	//ÿ�δ�Queue��ȡ��һ���ڵ����Ҫ�����һ���µĽڵ�
	while(queue.size()>0)
	{
	    ListNode temp=queue.poll();
	    curr.next=temp;
	    curr=curr.next;
	    if(temp.next!=null)
	    {
		queue.add(temp.next);
	    }
	}
	return head.next;
    }
}
