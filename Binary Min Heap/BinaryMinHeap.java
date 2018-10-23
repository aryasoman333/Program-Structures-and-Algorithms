/**
 * 
 */
package com.algo.day5.selfStudy;

/**
 * @author Arya Soman
 *
 */
public class BinaryMinHeap {

	int[] array;
	int heapSize;
	
	public BinaryMinHeap(int size)
	{
		array = new int[size];
		heapSize = 0;
	}
	
	public int minIndexValue()
	{
		if(heapSize == 0)
		return Integer.MAX_VALUE; //2147483647
		//return Integer.MIN_VALUE; //2147483647
		return array[0];
	}
	
	public int leftChildIndex(int index)
	{
		return 2*index +1;
	}
	
	public int rightChildIndex(int index)
	{
		return 2*index +2;
	}
	
	public int parentIndex(int index)
	{
		return (index-1)/2;
	}
	
	public void add(int data)
	{
		if(heapSize >= array.length)
			System.out.println("overflow!!");
		else
		{
			heapSize ++;
			array[heapSize-1] = data;			
			siftUp(heapSize-1);
		}
	}
	
	public void siftUp(int index)
	{
		if(index == 0)
			return;
		int parent;
		int child;
		
		parent = parentIndex(index);
		child = index;
		
		if(array[parent] < array[child])
			return;
		else
		{
			int temp = array[child];
			array[child] = array[parent];
			array[parent] = temp;
			siftUp(parent);
		}
	}
	
	public void remove()
	{
		array[0] = array[heapSize -1];
		siftDown(0);
	}
	
	public void siftDown(int index)
	{
		//base condition
		
		if(index == heapSize - 1)
			return;
		int left;
		int right;
		int minIndex;
		left = leftChildIndex(index);
		right = rightChildIndex(index);
		//find minIndex first
		
		if(right > heapSize - 1)
			minIndex = left;
		else if(left < right)
			minIndex = left;
		else
			minIndex = right;
			
		if(!(array[index] < array[minIndex]))
			{
				int temp = array[index];
				array[index] = array[minIndex];
				array[minIndex] = temp;
				siftDown(minIndex);
			}
		
	}
	public void display()
	{
		for(int i =0;i<heapSize;i++)
			System.out.println(array[i]);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		BinaryMinHeap min = new BinaryMinHeap(10);
		System.out.println(min.minIndexValue());
		min.add(1);
		min.add(3);
		min.add(2);
		min.add(4);
		min.add(5);
		min.add(6);
		min.add(7);
		min.add(8);
		min.add(2);
		min.display();
		System.out.println();
		min.remove();
		min.display();
	}

}
