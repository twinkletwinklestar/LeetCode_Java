/***
 * 合并k个有序列表
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
     * 合并k个有序链表 使用
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
	 * 使用PriorityQueue来存储ListNode节点
	 * 由于在构建新链表时每次只需要在当前各链表中取头节点最小的值
	 * 所以Queue的大小为lists.length
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
	
	//将当前所有链表的头节点添加进Queue
	for(int i=0;i<lists.length;i++)
	{
	    if(lists[i]!=null)
	    {
		queue.add(lists[i]);
	    }	    
	}
	ListNode head=new ListNode(0);
	ListNode curr=head;
	//每次从Queue中取出一个节点后需要再添加一个新的节点
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
