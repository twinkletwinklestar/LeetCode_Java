/***
 * Question:
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * Time:2015-07-23
 */


public class SingleNumberII
{
    public static int singleNumber(int[] nums)
    {
	if(nums==null||nums.length==0)
	{
	    return -1;
	}
	//һ������Ϊ32�����飬�洢ÿλ����1�Ĵ���
	int[] count=new int[Integer.SIZE];
	for(int i=0;i<nums.length;i++)
	{
	    for(int j=0;j<Integer.SIZE;j++)
	    {
		//ÿ������ͳ�Ƹ�λ�Ƿ�Ϊ1
		if(((nums[i]>>>j)&1)==1)
		{
		    count[j]=(count[j]+1)%3;
		}
	    }
	}
	int result=0;
	for(int i=0;i<Integer.SIZE;i++)
	{
	   result=result|(count[i]<<i);
	}
	return result;
    }

    public static void main(String[] args)
    {
	int[] nums=new int[]{1,1,1,2,2,2,3,3,3,4};
	int result=singleNumber(nums);
	System.out.println(result);
    }
}
