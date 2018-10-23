package com.algo.day2.selfStudy;

public class SearchFirstIndexOfRepeatedValues {

	public static int findFirstIndexOfRepeatedValues(int[] array, int low, int high, int x)
	{
		//int low=0;
		//int high=array.length-1;
		
	    	if(low > high)
	    		return -1;
			if(array[low] > x)
			{
				return -1;
			}
			if(array[high] < x)
			{
				return -1;
			}
			if(array[low] == x)
			{
				return low;
			}
			int mid=(low+high)/2;
			if(array[mid] == x )
			{
				return findFirstIndexOfRepeatedValues(array, low, mid, x);
			}
			else if(array[mid] < x)
			{
				return findFirstIndexOfRepeatedValues(array, mid+1, high, x);
			}
			else
			{
				return findFirstIndexOfRepeatedValues(array, low, mid-1, x);
			}
		
	}
	public static void main(String[] args) 
	{
		int[] array = {2,2,2,3,3,3,4,4,4,6,6,6,8,8,8};
		int result = findFirstIndexOfRepeatedValues(array, 0, array.length-1, 6);
		System.out.println(result);
		
	}

}
