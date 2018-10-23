package com.algo.day3.selfStudy;

public class Node 
{
	int data;
	Node Next;
	Node head;
	//parametrized constructor to be called each time a node (object) is created.
	public Node(int data)
	{
		this.data = data;
		this.Next = null;
	}
	
}
