package com.algo.day1.selfStudy;
/**
 * @author Arya Soman
 *
 */
public class QuickSort {

	/**
	 * method to sort an array recursively
	 * time complexity - O(nlogn) -- worst -O(n^2)
	 * space complexity - logn
	 * @param array
	 */
public static void quickSort(int[] array)
{
	quickSort(array,0,array.length-1);
}

public static void quickSort(int[] array, int low, int high)

{
	if(low>=high)
	{
		return;
	}
	int pivot= array[(low+high)/2];
	int index=Partition(array,low,high,pivot);
	quickSort(array, low, index-1);
	quickSort(array, index+1, high);
}

public static int Partition(int[] array, int low, int high, int pivot)

{
	while(low<=high)
	{
		while(array[low]<pivot)
		{
			low++;
		}
		while(array[high]>pivot)
		{
			high--;
		}
		//if(low<=high)
		//{
		Swap(array,low,high);
		low++;
		high--;
		//}
	}
	return low; // returns partition where all elements to left are smaller and all elements to right are bigger
	
}

public static void Swap(int[] array,int low,int high)

{
	int temp;
	temp=array[low];
	array[low]=array[high];
	array[high]=temp;
}
public static void main(String[] args) 
{
	
	int[] array= {3,5,9,1,4,9,3};
	for(int i=0;i<array.length;i++)
	{
	System.out.print(array[i]);
	}
	quickSort(array);
	System.out.println();
	for(int i=0;i<array.length;i++)
	{
	System.out.print(array[i]+",");
	}
	
}

}
