

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReorderList
{
    /***
     * 反转链表
     * @param head	链表的头结点
     * @return		翻转后的链表的头结点
     */
    public static ListNode reverseOrder(ListNode head)
    {
	if(head==null||head.next==null)
	{
	    return head;
	}
	ListNode pre=head;
	ListNode curr=pre.next;
	while(curr!=null)
	{
	    ListNode temp=curr.next;
	    curr.next=pre;
	    pre=curr;
	    curr=temp;
	}
	head.next=null;
	return pre;
    }
    
    /***
     * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
     * @param head the head of list
     */
    public static ListNode reorderList(ListNode head) 
    {
	if(head==null||head.next==null)
	{
	    return head;
	}
	//得到中间节点
	ListNode middle=head;
	ListNode index2=head;
	while(index2!=null&&index2.next!=null&&index2.next.next!=null)
	{
	    middle=middle.next;
	    index2=index2.next.next;
	}
	ListNode secondList=middle.next;
	middle.next=null;
	//将后半段链表反转
	secondList=reverseOrder(secondList);
	//合并两段链表
	ListNode p1=head;
	ListNode p2=secondList;
	while(p2!=null)
	{
	    ListNode temp1=p1.next;
	    ListNode temp2=p2.next;
	    
	    p1.next=p2;
	    p2.next=temp1;
	    
	    p1=temp1;
	    p2=temp2;
	}
	return head;
    }
    
    public static void main(String[] args)
    {
	ListNode node1=new ListNode(1);
	ListNode node2=new ListNode(2);
	ListNode node3=new ListNode(3);
	ListNode node4=new ListNode(4);
	ListNode node5=new ListNode(5);
	ListNode node6=new ListNode(6);
	ListNode node7=new ListNode(7);
	ListNode node8=new ListNode(8);
	ListNode node9=new ListNode(9);
	node1.next=node2;
	node2.next=node3;
	node3.next=node4;
	node4.next=node5;
	node5.next=node6;
	node6.next=node7;
	node7.next=node8;
	node8.next=node9;
	node9.next=null;
	ListNode head=node1;
	
	head=reorderList(head);
	while(head!=null)
	{
	    System.out.println(head.val);
	    head=head.next;
	}
    }
}