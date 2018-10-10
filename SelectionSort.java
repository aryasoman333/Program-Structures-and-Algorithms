package com.algo.day1.selfStudy;

public class SelectionSort {

	/**
	 * method to sort an array
	 * select a minvalue as first element and compare with others
	 * at end of each loop, swap the smallest with first element
	 * time complexity - O(n^2)
	 * space complexity - O(1)
	 * @param array
	 */
	
	public static void selectionSort(int[] array)
	{
		int temp;
		int minVal;
		int minIndex;
		for(int i=0;i<array.length;i++)
		{
			minVal=array[i];
			minIndex=i;
			for(int j=i;j<array.length;j++)
			{
				if(array[j] < minVal)
				{
					minVal=array[j];
					minIndex=j;
				}
			}
			if (minVal<array[i])
			{
				temp=array[i];
				array[i]=array[minIndex];
				array[minIndex]=temp;
			}
			
		}
	}
	public static void main(String[] args) 
	{
		int [] array= {3,6,4,33,0};
		selectionSort(array);
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i] +" ");
		}
	}

}
