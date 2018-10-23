package com.algo.day2.selfStudy;

public class StringReversal 
{
	public static void stringReverse(int[] arr, int start, int end)
	{
//		for(int i = start;i < end  ;i++)
//		{
//			int temp = arr[i];
//			arr [i] = arr[end];
//			arr[end] = temp;
//			end--;
//			
//		}
		
// 		OR
		while(start<end)
		{
			int temp = arr[start];
			arr [start] = arr[end];
			arr[end] = temp;
			end--;
			start++;
		}
	}
	public static void main(String[] args) 
	{
		int[] arr = {1,2,3,4,5};
		int start = 0;
		int end = arr.length-1;
		
		stringReverse(arr,start,end);
		
	
	for(int i = 0;i < arr.length ; i++)
	{
		System.out.print(arr[i] + " ");
	}
	}
}
