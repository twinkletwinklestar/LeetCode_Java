

public class SearchForaRange
{
    public int getFirst(int[] nums, int target, int start, int end)
    {
	if (start > end)
	{
	    return -1;
	}
	int middleIndex = (start + end) >>> 1;
	if (nums[middleIndex] == target)
	{
	    if (middleIndex > 0 && nums[middleIndex - 1] != target
		    || middleIndex == 0)
	    {
		return middleIndex;
	    }
	    else
	    {
		end = middleIndex - 1;
	    }
	}
	else if (nums[middleIndex] > target)
	{
	    end = middleIndex - 1;
	}
	else
	{
	    start = middleIndex + 1;
	}
	return this.getFirst(nums, target, start, end);
    }

    public int getLast(int[] nums, int target, int start, int end)
    {
	if (start > end)
	{
	    return -1;
	}
	int middleIndex = (start + end) >>> 1;
	if (nums[middleIndex] == target)
	{
	    if (middleIndex < nums.length - 1
		    && nums[middleIndex + 1] != target
		    || middleIndex == nums.length - 1)
	    {
		return middleIndex;
	    }
	    else
	    {
		start = middleIndex + 1;
	    }
	}
	else if (nums[middleIndex] > target)
	{
	    end = middleIndex - 1;
	}
	else
	{
	    start = middleIndex + 1;
	}
	return this.getLast(nums, target, start, end);
    }

    public int[] searchRange(int[] nums, int target)
    {
	int[] result = new int[] { -1, -1 };
	if (nums == null)
	{
	    return result;
	}
	if(nums.length==1&&nums[0]==target)
	{
	    result[0]=0;
	    result[1]=0;
	    return result;
	}
	if(nums.length==2&&nums[0]==nums[1]&&nums[0]==target)
	{
	    result[0]=0;
	    result[1]=1;
	    return result;
	}
	int first = this.getFirst(nums, target, 0, nums.length - 1);
	int last = this.getLast(nums, target, 0, nums.length - 1);
	result[0] = first;
	result[1] = last;
	return result;
    }

    
    public static void main(String[] args)
    {
	int[] nums = new int[] { 5, 7, 7, 8, 8, 10 };
	int target = 8;
	SearchForaRange searchForaRange = new SearchForaRange();
	int[] result = searchForaRange.searchRange(nums, target);
	System.out.println(result[0] + "\t" + result[1]);
    }
}
