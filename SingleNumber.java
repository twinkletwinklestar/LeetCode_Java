/**
 * Question:
 * Given an array of integers, 
 * every element appears twice except for one. 
 * Find that single one.
 * 
 * Time:2015-07-23
 */


public class SingleNumber
{
    public static int singleNumber(int[] nums)
    {
	if(nums==null || nums.length==0)
	{
	    return -1;
	}
	int result=0;
	for(int i=0;i<nums.length;i++)
	{
	    result=result^nums[i];
	}
	return result;
    }

    public static void main(String[] args)
    {
	int[] nums=new int[]{1,1,2,2,3};
	int result=singleNumber(nums);
	System.out.println(result);
    }
}
