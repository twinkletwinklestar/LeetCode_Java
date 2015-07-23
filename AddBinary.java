/***
 * Question: Given two binary strings, return their sum (also a binary string).
 * For example, a = "11" b = "1" Return "100"
 * 
 * @author tangxin Time:2015-07-23
 */
public class AddBinary
{
    public static String addBinary(String a, String b)
    {
	if(a==null||b==null)
	{
	    return null;
	}
	if(a.length()==0||b.length()==0)
	{
	    return a+b;
	}
	int aLength=a.length();
	int bLength=b.length();
	int aPosition=aLength-1;
	int bPosition=bLength-1;
	int mark=0;
	int aNum=0;
	int bNum=0;
	String result=new String("");
	while(aPosition>=0&&bPosition>=0)
	{
	    aNum=a.charAt(aPosition)-'0';
	    bNum=b.charAt(bPosition)-'0';
	    int sum=aNum+bNum+mark;
	    if(sum>=2)
	    {
		sum=sum-2;
		mark=1;
	    }
	    else
	    {
		mark=0;
	    }
	    result=sum+result;
	    aPosition--;
	    bPosition--;
	}
	
	while(aPosition>=0)
	{
	    aNum=a.charAt(aPosition)-'0';
	    aNum=aNum+mark;
	    if(aNum>=2)
	    {
		aNum=aNum-2;
		mark=1;
	    }
	    else
	    {
		mark=0;
	    }
	    result=aNum+result;
	    aPosition--;
	}
	
	while(bPosition>=0)
	{
	    bNum=b.charAt(bPosition)-'0';
	    bNum=bNum+mark;
	    if(bNum>=2)
	    {
		bNum=bNum-2;
		mark=1;
	    }
	    else
	    {
		mark=0;
	    }
	    result=bNum+result;
	    bPosition--;
	}
	if(mark==1)
	{
	    result=1+result;
	}
	return result;
    }

    public static void main(String[] args)
    {
	String result=addBinary("101", "1");
	System.out.println(result);
    }
}
