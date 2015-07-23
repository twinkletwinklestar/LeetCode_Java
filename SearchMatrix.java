/***
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
time:2015-07-20
 */


public class SearchMatrix
{
    public static boolean searchMatrix(int[][] matrix, int target)
    {
	boolean isExist = false;
	if (matrix == null)
	{
	    return false;
	}
	int rows = matrix.length;
	int colums = matrix[0].length;
	// 二分查找，查找所在的行坐标
	int rowIndexStart = 0;
	int rowIndexEnd = rows - 1;
	int rowIndexMiddle = (rowIndexStart + rowIndexEnd) / 2;
	while (rowIndexStart < rowIndexEnd)
	{
	    if (matrix[rowIndexMiddle][colums - 1] == target)
	    {
		return true;
	    }
	    else if (target > matrix[rowIndexMiddle][colums - 1])
	    {
		rowIndexStart = rowIndexMiddle + 1;
	    }
	    else
	    {
		rowIndexEnd = rowIndexMiddle - 1;
	    }
	    rowIndexMiddle = (rowIndexStart + rowIndexEnd) / 2;
	}
	if (target > matrix[rowIndexStart][colums - 1])
	{
	    rowIndexStart = rowIndexStart + 1;
	}
	// 二分查找，查找所在的列坐标
	int columIndexStart = 0;
	int columIndexEnd = colums - 1;
	int columIndexMiddle = (columIndexStart + columIndexEnd) / 2;
	if (rowIndexStart <= rows - 1)
	{
	    while (columIndexStart < columIndexEnd)
	    {
		if (matrix[rowIndexStart][columIndexMiddle] == target)
		{
		    return true;
		}
		else if (target > matrix[rowIndexStart][columIndexMiddle])
		{
		    columIndexStart = columIndexMiddle + 1;
		}
		else
		{
		    columIndexEnd = columIndexMiddle - 1;
		}
		columIndexMiddle = (columIndexStart + columIndexEnd) / 2;
	    }
	    if (matrix[rowIndexStart][columIndexStart] == target)
	    {
		return true;
	    }
	}
	return isExist;
    }

    public static void main(String[] args)
    {
	int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
		{ 23, 30, 34, 50 } };
	System.out.println(searchMatrix(matrix, 15));
    }
}
