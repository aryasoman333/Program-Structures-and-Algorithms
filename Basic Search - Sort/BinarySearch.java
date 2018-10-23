package com.algo.day2.selfStudy;

public class BinarySearch {
	
	public static boolean binarySearch(int[] array, int x)
	{
		int start=0;
		int end=array.length-1;
		boolean result = binarySearchRecursive(array, start, end, x);
		return result;
	}
	
	public static boolean binarySearchRecursive(int[] array, int start, int end, int x)
	{
		if(start > end)
		{
			return false;
		}
			
		int mid=(start+end)/2;
		if(array[mid]==x)
		{
			return true;
		}
		else if(array[mid] > x)
		{
			return binarySearchRecursive(array, 0, mid-1, x);
		}
		else
		{
			return binarySearchRecursive(array, mid + 1, end, x);
		}
	}

	public static boolean searchInRotatedArray(int[] array, int x)
	{
		int minIndex = findMinIndex(array);
		System.out.println("minIndex = "+ minIndex);
		if(array[minIndex-1] < x)
		{
			return false;
		}
		if(array[minIndex] > x)
		{
			return false;
		}
		if(array[array.length-1] > x ) 
		{
			return binarySearchRecursive(array, minIndex, array.length-1, x);
		}
		else
		{
			return binarySearchRecursive(array, 0, minIndex-1, x);
		}
	}
	
	public static int findMinIndex(int[] array)
	{
		int low = 0;
		int high = array.length-1;
		while(array[low] > array[high])
		{
		int mid = low + high / 2;
		if(array[mid] > array[high])
		{
			//unsorted
			
			low= mid + 1;
			
		}
		else
		{
			high= mid;
		}
		}
		System.out.println("minindex test = "+low);
			return low;
	}
	public static void main(String[] args) 
	{
		int[] array= {7,8,9,10,1,2};
		int start=0;
		int end=array.length-1;
		//boolean result = binarySearchRecursive(array, start, end, 5);
		boolean result = searchInRotatedArray(array,6);
		
		//boolean result = binarySearch(array, 3);
		System.out.println(result);
	}

}
