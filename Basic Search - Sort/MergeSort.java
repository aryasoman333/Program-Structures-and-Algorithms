package com.algo.day1.selfStudy;
/**
 * @author Arya Soman
 *
 */
public class MergeSort {
	/**
	 * method to sort an array recursively
	 * time complexity - O(nlogn)
	 * space complexity - O(n)
	 * @param array
	 */
	public static void mergeSort(int[] array) 
	{
		mergeSort(array,new int[array.length], 0,array.length-1);
	}
	
	public static void mergeSort(int [] array,int[] temp,int leftStart, int rightEnd)
	{
		if(leftStart>=rightEnd)
		{
			return;
		}
		int middle = (leftStart+rightEnd)/2;
		mergeSort(array, temp, leftStart, middle);
		mergeSort(array, temp, middle+1, rightEnd);
		mergeHalves(array,temp,leftStart,rightEnd);
	}
	
	public static void mergeHalves(int[] array,int[] temp, int leftStart, int rightEnd)
	{
		int leftEnd=(rightEnd+leftStart)/2;
		int rightStart = leftEnd+1;
		int left=leftStart;
		int right=rightStart;
		int index=leftStart;
		int size=rightEnd-leftStart+1;
		while(left<=leftEnd && right<=rightEnd)
		{
			if(array[left] < array[right])
			{
				temp[index]=array[left];
				left++;
			}
			else
			{
				temp[index]=array[right];
				right++;
			}
			index++;
		}
		//arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
		
		System.arraycopy(array, left, temp, index, leftEnd-left+1);
		System.arraycopy(array, right, temp, index, rightEnd-right+1);
		System.arraycopy(temp, leftStart, array, leftStart, size); //copy from temp to "array"
	}
	public static void main(String[] args) 
	{
		int[] array= {33,22,4,234,34,123,0,6};
		mergeSort(array);
		for(int i=0;i<array.length;i++)
		{
			System.out.print(array[i] +" ");
		}
	}

}
