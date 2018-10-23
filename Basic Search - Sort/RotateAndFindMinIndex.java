package com.algo.day2.selfStudy;

public class RotateAndFindMinIndex {
	
	public static int minIndex(int[] array, int low, int high)
	{
		
		while(array[low] > array[high])
		{
			int mid=low+high/2;
			if(array[mid] > array[high])
			{
				//not sorrted
				low=mid + 1;
			}
			else
			{
				high=mid;
			}
			
		}
		return low;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
