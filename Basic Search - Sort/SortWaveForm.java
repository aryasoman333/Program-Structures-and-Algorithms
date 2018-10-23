/**
 * 
 */
package com.algo.day2.selfStudy;

/**
 * @author Arya Soman
 *
 */

public class SortWaveForm {

	/**
	 * method 1
	 * first sort the unsorted array
	 * take 2 elements at a time and swap
	 */

	static void waveSort(int[] array)
	{
		for(int j=0; j<array.length-1 ; j++)
		{
			for(int i=0;i<array.length-1-j;i++)
			{
				if(array[i] > array[i+1])
				{
					int temp = array[i];
					array[i]=array[i+1];
					array[i+1] = temp;
				}
			}
		}
		for(int i=0; i<array.length;i++) {
			System.out.print(array[i]);
		}

		for(int i=0;i<array.length-1;i=i+2)
		{
			int temp = array[i];
			array[i]= array[i+1];
			array[i+1] = temp;
		}
	}
	
	/**
	 * 2nd method
	 * no need to sort in this case
	 * we check if all the numbers in even position are bigger than their neighours
	 *
	 */
	
	static void waveSort2(int[] array)
	{
		for(int i=0; i<array.length;i=i+2)
		{
			if(i > 0 && array[i-1] > array[i])
			{
				int temp = array[i];
				array[i]= array[i-1];
				array[i-1] = temp;
			}
			if(i<array.length-1 && array[i+1] > array[i])
			{
				int temp = array[i];
				array[i]= array[i+1];
				array[i+1] = temp;
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] array = {2,5,1,6,8,7,6,4,2};
		//waveSort(array);
		waveSort2(array);;
		System.err.println();
		for(int i=0; i<array.length;i++) {
			System.out.print(array[i]);
		}
	

	}

}
