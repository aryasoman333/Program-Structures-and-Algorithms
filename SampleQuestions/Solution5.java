package com.algo.midterm.sol5;

import java.util.Stack;

/**
 * @author Arya Soman
 * 
 *[Question 5]
 Given an array print the next greater element for every element. For example given array [6,8,2,34] 

Element   Next Greater Element
 6      ->   8
 8      ->   34
 2      ->   34
 34     ->   int.Minimum
 *
 */
public class Solution5 
{
	public static void printNextGreaterElement(int[] arr)
	{
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[arr.length];
		//iterating from last element to get result in same order as input array
		for(int i = arr.length-1 ; i >= 0 ; i--)
		{
			if(!stack.isEmpty())
			{
				while(!stack.isEmpty() && arr[i] >= stack.peek() )
					stack.pop();	
			}
			if(!stack.isEmpty())
				result[i] = stack.peek();
			else
				result[i] = Integer.MIN_VALUE;
			stack.push(arr[i]);

		}
		for(int i = 0 ; i < arr.length ; i++)
		{
			System.out.println(arr[i] + "      -->     " + result[i]);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//int [] arr = {1,3,2,1,5,7,3,4};
		int [] arr = {6,8,2,34};
		System.out.println("Element | Next Greater Element");
		printNextGreaterElement(arr);
	}

}
