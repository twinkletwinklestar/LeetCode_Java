/***
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 ¡ú 2
[1,3,5,6], 2 ¡ú 1
[1,3,5,6], 7 ¡ú 4
[1,3,5,6], 0 ¡ú 0

time: 2015-07-20
 */


public class SearchInsertPosition
{
    public static int searchInsert(int[] nums, int target)
    {
	if(nums==null)
	{
	    return 0;
	}
	int first=0;
	int last=nums.length-1;
	int middle=(first+last)/2;
	while(first<last)
	{
	    if(nums[middle]==target)
	    {
		return middle;
	    }
	    else if(target>nums[middle])
	    {
		first=middle+1;
	    }
	    else
	    {
		last=middle-1;
	    }
	    middle=(first+last)/2;
	}
	if(target>nums[first])
	{
	    first=first+1;
	}
	return first;
    }

    public static void main(String[] args)
    {
	int[] nums = new int[] { 1, 3, 5, 6, 7 };
	int target = 8;
	int result = searchInsert(nums, target);
	System.out.println(result);
    }
}
