package com.algo.day2.selfStudy;

public class FindFirstLargerThanKRecursive 
{
	public static int nextBiggerNumberRecursive(int [] array, int l, int h, int x)
	{
		
		if(l > h)
		{
			return -1;
		}
		
			if(array[h] <= x)
			{
				return -1;
			}
			int m = (l+h)/2;
			System.out.println("m is " +m);
			if(array[m] == x)
			{
				return array[m+1];
			}
			if(array[m] < x)
			{

				return nextBiggerNumberRecursive(array, m+1, h, x);
			
			}
			else
			{
				return nextBiggerNumberRecursive(array, l, m-1, x);
			}

	}
	public static void main(String[] args) 
	{
		
		int[] array = {1,2,3,6,7};
		int result = nextBiggerNumberRecursive(array, 0, array.length-1, 2);
		System.out.println(result);
		
	}
}
