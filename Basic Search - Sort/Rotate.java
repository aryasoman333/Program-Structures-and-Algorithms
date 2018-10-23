package com.algo.day2.selfStudy;

public class Rotate {
	//n is the number of rotations
	public static void rotate(int[] array, int n)
	{
		n=n%array.length; //to avoid unwanted rotation.if 5 is array length and k=6, doing a rotation 5 times is same 
										//as not doing any rotation at all
		//make sure index is written as array.length-1 --> else exception
		reverse(array, 0, array.length-1);
		reverse(array, 0, n-1);
		reverse(array, n, array.length-1);
	}
	
	public static void reverse(int[] array,int start,int end)
	{
		int temp=0;
		while(start < end)
		{
			temp=array[start];
			array[start] = array[end];
			array[end]=temp;
		
			start++;
			end--;
		}
	}

	public static void main(String[] args) 
	{
		int[] array = {1,2,3,4,5};
		rotate(array, 4);
		for(int i = 0 ; i < array.length ; i++)
		{
			System.out.print(array[i] + " ");
		}
	}

}
