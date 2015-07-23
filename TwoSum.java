
public class TwoSum
{
    public int[] twoSum(int[] nums, int target)
    {
	//快速排序算法后会改变原数组元素的位置，排序之前先为原数组保存一份副本
	int[] clone=new int[nums.length];
	for(int k=0;k<nums.length;k++)
	{
	    clone[k]=nums[k];
	}
	int[] orderArray=quickSort(nums);
	
	//在排序好的数组中查找是否存在相加之和为target的两个元素
	int i=0;
	int j=orderArray.length-1;
	int[] indexArray=null;
	while(i<j)
	{
	    if((orderArray[i]+orderArray[j])==target)
	    {
		//在原数组中查找两个元素的原始索引
		int index1=-1;
		int index2=-1;
		//index2的值有可能被index1覆盖，所以要在两个循环里面分别查找
		for(int k=0;k<clone.length;k++)
		{
		    if(orderArray[i]==clone[k])
		    {
			index1=k;
			break;
		    }
		}
		for(int k=0;k<clone.length;k++)
		{
		    if(orderArray[j]==clone[k]&&(index1!=k))
		    {
			index2=k;
			break;
		    }
		}
		indexArray=new int[2];
		if(index1<index2)
		{
		    indexArray[0]=index1+1;
		    indexArray[1]=index2+1;
		}
		else 
		{
		    indexArray[0]=index2+1;
		    indexArray[1]=index1+1;
		}
		break;
	    }
	    else if((orderArray[i]+orderArray[j])<target)
	    {
		i++;
	    }
	    else
	    {
		j--;
	    }
	}
	return indexArray;
    }

    /***
     * 快速排序算法
     * @param arr	要排序的数组
     * @return		排序好的数组
     */
    public static int[] quickSort(int[] arr)
    {
	int[] result = arr;
	qsort(result, 0, result.length - 1);
	return result;
    }
    
    /***
     * 递归调用排序算法
     * @param arr 	要排序的数组
     * @param low	排序数组要排序部分的起始位置
     * @param high	排序数组要排序部分的终止位置
     */
    private static void qsort(int[] arr, int low, int high)
    {
	if (low < high)
	{
	    int pivot = partition(arr, low, high);
	    qsort(arr, low, pivot - 1);
	    qsort(arr, pivot + 1, high);
	}
    }

    /***
     * 快速排序算法中确定中轴
     * @param arr	要排序的数组
     * @param low	排序数组要排序部分的起始位置
     * @param high	排序数组要排序部分的终止位置
     * @return
     */
    private static int partition(int[] arr, int low, int high)
    {
	//先保存第一个数组元素作为中轴元素，比该元素大的移到
	//该元素右边，小的移到左边
	int pivot = arr[low];
	while (low < high)
	{
	    while (low < high && arr[high] >= pivot)
		high--;
	    arr[low] = arr[high];
	    while (low < high && arr[low] <=pivot)
		low++;
	    arr[high] = arr[low];
	}
	arr[low] = pivot;
	return low;
    }

    public static void main(String[] args)
    {
	TwoSum twoSum = new TwoSum();
	int[] array = new int[] { 72,6,57,88,60,42,83,73,48,85};
	int[] result=twoSum.twoSum(array, 66);
	if(result!=null)
	{
	    System.out.println(result[0]+"\t"+result[1]);
	}
    }
}
