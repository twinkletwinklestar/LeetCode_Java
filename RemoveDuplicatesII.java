/***
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5,
with the first five elements of nums being 1, 1, 2, 2 and 3.
It doesn't matter what you leave beyond the new length
 */


public class RemoveDuplicatesII
{
    public static int removeDuplicates(int[] nums)
    {
	if (nums.length <= 2)
	    return nums.length;
	// point to previous
	int prev = 1;
	// point to current
	int curr = 2;
	while (curr < nums.length)
	{
	    if (nums[curr] == nums[prev] && nums[curr] == nums[prev - 1])
	    {
		curr++;
	    }
	    else
	    {
		prev++;
		nums[prev] = nums[curr];
		curr++;
	    }
	}
	return prev + 1;
    }

    public static void main(String[] args)
    {
	int[] nums = new int[] { 1, 2, 2 };
	int index = removeDuplicates(nums);
	for (int i = 0; i < index; i++)
	{
	    System.out.print(nums[i] + "  ");
	}
    }
}
