/***
Question:
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Time:2015-07-23
 */


public class RemoveElement
{
    public static int removeElement(int[] nums, int val)
    {
	if (nums == null || nums.length == 0)
	{
	    return 0;
	}
	// 记录nums数组中val的个数
	int count = 0;
	// 前向遍历数组的指针
	int frontPosition = 0;
	// 后向遍历数组的指针
	int backPosition = nums.length - 1;
	while(frontPosition<=backPosition)
	{
	    if(nums[frontPosition]==val)
	    {
		count++;
		while(backPosition>frontPosition&&nums[backPosition]==val)
		{
		    count++;
		    backPosition--;
		}
		if(frontPosition!=backPosition)
		{
		    nums[frontPosition]=nums[backPosition];
		    backPosition--;
		}
		else
		{
		    break;
		}
	    }
	    frontPosition++;
	}
	return nums.length - count;
    }

    public static void main(String[] args)
    {
	int[] nums = new int[] { };
	int newLength = removeElement(nums, 0);
	System.out.println(newLength);
    }
}
