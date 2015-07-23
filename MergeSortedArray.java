

/***
 * 将两个排序数组合并
 * 
 * @author tangxin
 * 
 */
public class MergeSortedArray
{
    /***
     * Given two sorted integer arrays nums1 and nums2, 
     * merge nums2 into nums1 as one sorted array.
     * @param nums1	排序数组1
     * @param m		
     * @param nums2	排序数组2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n)
    {
	int curr=m+n-1;
	int nums1Index=m-1;
	int nums2Index=n-1;
	while(nums1Index>=0&&nums2Index>=0)
	{
	    if(nums1[nums1Index]>nums2[nums2Index])
	    {
		nums1[curr]=nums1[nums1Index];
		nums1Index--;
	    }
	    else
	    {
		nums1[curr]=nums2[nums2Index];
		nums2Index--;
	    }
	    curr--;
	}
	while (nums2Index>=0)
	{
	    nums1[curr]=nums2[nums2Index];
	    curr--;
	    nums2Index--;
	}
    }
}
