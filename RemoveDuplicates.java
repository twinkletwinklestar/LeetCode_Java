/***
Given a sorted array, remove the duplicates in place such that each 
element appear only once and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array nums = [1,1,2],
Your function should return length = 2,
 with the first two elements of nums being 1 and 2 respectively.
  It doesn't matter what you leave beyond the new length.
  time:2015-07-20
 */


public class RemoveDuplicates
{
    public static int removeDuplicates(int[] nums)
    {
	if(nums==null||nums.length==0)
	{
	    return 0;
	}
	/**
	 * ��Ҫ����Ϊ��������ָ�룬curr��ʾ��ǰ�����Ԫ��,newArrayIndexΪ������ĳ���
	 * ��nums[curr]��nums[curr-1]�����ʱ������nums[curr]��nums[++newArrayIndex]
	 */
	int newArrayIndex=0;
	int curr=0;
	if(nums.length>=2)
	{
	    curr++;
	    while(curr<nums.length)
	    {
		if(nums[curr]!=nums[curr-1])
		{
		    nums[++newArrayIndex]=nums[curr];
		}
		curr++;
	    }
	}
	return ++newArrayIndex;
    }
    
    public static void main(String[] args)
    {
	int[] nums=new int[]{1,1,1,2,3,4,4,5};
	int index=removeDuplicates(nums);
	System.out.println(index);
    }
}
