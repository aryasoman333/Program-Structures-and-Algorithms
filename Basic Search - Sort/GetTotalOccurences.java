package com.algo.day2.selfStudy;

public class GetTotalOccurences {
	
	public static int getTotalOccurences(int[] array, int l, int h, int x)
	{
		if(l>h)
		{
			return 0;
		}
		if(array[l] > x)
		{
			return 0;
		}
		if(array[h] < x)
		{
			return 0;
		}
		if(array[l] == x && array[h] == x)
		{
			return h-l+1;
		}
		int mid=(l+h)/2;
		if(array[mid] == x)
		{
			return 1 + getTotalOccurences(array, l, mid-1, x) + getTotalOccurences(array, mid+1, h, x);
		}
		else if(array[mid] > x)
		{
			return getTotalOccurences(array, l, mid-1, x);
		}
		else
		{
			return getTotalOccurences(array, mid+1, h, x);
		}
	}

	public static void main(String[] args) 
	{
		int[] array = {2,2,2,3,3,3,4,5,5,5,5,5,5,6,6,7};
		int result = getTotalOccurences(array, 0, array.length-1, 5);
		System.out.println(result);
	}

}
