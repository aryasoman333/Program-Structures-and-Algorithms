package com.algo.day1.selfStudy;

/**
 * @author Arya Soman
 *
 */
public class BubbleSort {

	/**
	 * method to compare 2 adjacent elements and swap the bigger one to right side
	 * time complexity - O(n^2)
	 * space complexity - O(1)
	 * @param array
	 */
	public static void bubbleSort(int[] array)
	{
		for(int i=0;i<array.length-1;i++)
		{
			for (int j=0;j<array.length-1-i;j++)
			{
				if(array[j] > array[j+1])
				{
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
				
			}
		}
	}
	public static void main(String[] args) 
	{
		int []array={3,4,1,55,33,31,7,0};
		bubbleSort(array);
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i] +" ");
		}
	}

}
