
public class TwoSum
{
    public int[] twoSum(int[] nums, int target)
    {
	//���������㷨���ı�ԭ����Ԫ�ص�λ�ã�����֮ǰ��Ϊԭ���鱣��һ�ݸ���
	int[] clone=new int[nums.length];
	for(int k=0;k<nums.length;k++)
	{
	    clone[k]=nums[k];
	}
	int[] orderArray=quickSort(nums);
	
	//������õ������в����Ƿ�������֮��Ϊtarget������Ԫ��
	int i=0;
	int j=orderArray.length-1;
	int[] indexArray=null;
	while(i<j)
	{
	    if((orderArray[i]+orderArray[j])==target)
	    {
		//��ԭ�����в�������Ԫ�ص�ԭʼ����
		int index1=-1;
		int index2=-1;
		//index2��ֵ�п��ܱ�index1���ǣ�����Ҫ������ѭ������ֱ����
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
     * ���������㷨
     * @param arr	Ҫ���������
     * @return		����õ�����
     */
    public static int[] quickSort(int[] arr)
    {
	int[] result = arr;
	qsort(result, 0, result.length - 1);
	return result;
    }
    
    /***
     * �ݹ���������㷨
     * @param arr 	Ҫ���������
     * @param low	��������Ҫ���򲿷ֵ���ʼλ��
     * @param high	��������Ҫ���򲿷ֵ���ֹλ��
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
     * ���������㷨��ȷ������
     * @param arr	Ҫ���������
     * @param low	��������Ҫ���򲿷ֵ���ʼλ��
     * @param high	��������Ҫ���򲿷ֵ���ֹλ��
     * @return
     */
    private static int partition(int[] arr, int low, int high)
    {
	//�ȱ����һ������Ԫ����Ϊ����Ԫ�أ��ȸ�Ԫ�ش���Ƶ�
	//��Ԫ���ұߣ�С���Ƶ����
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
