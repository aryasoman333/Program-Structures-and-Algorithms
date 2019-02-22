package com.algo.midterm.sol4;

/**
 * @author Arya Soman
 *
 *[Question 4]
	Delete node(s) from a circular link list. You would be given an int value and you have to 
	delete all the nodes which have data equal to the given int value. 
 */

/**
 * Node class to define the basic node elements
 *
 */
class Node 
{	
	Node head;
	Node next;
	int data;

	public Node(int data)
	{
		this.data = data;
		this.next = null;
	}
}

public class Solution4 
{
	Node head;
	/**
	 * method to Delete node(s) from a circular link list
	 *
	 */
	public void deleteNodes(int a)
	{
		if(head == null)
			return;
		Node temp = head;
		while(temp.next != head)
		{			
			if(temp.data == a)
			{
				temp.data = temp.next.data;
				temp.next = temp.next.next;

			}
			else
				temp = temp.next;
		}

		if(temp.data == a)
		{
			//check for the only element in the given linked list and is pointing to itself(head)
			if(temp == head)
				head = null;
			//check for last element, the element pointing towards head
			else
			{
				temp.data = temp.next.data;
				temp.next = temp.next.next;
				head = temp;
			}
		}
	}
	/**
	 * method to add new nodes to Linked List
	 *
	 */
	public void AddNewNode(int data)
	{
		Node node = new Node(data);

		if(head == null)

		{
			head=node;
		}
		else
		{	
			Node temp = head;
			while(temp.next != null)
			{
				temp = temp.next;
			}

			temp.next = node;
			node.next = null;
		}
	}

	/**
	 * method to make the Linked List circular
	 *
	 */
	public void makeCircular()
	{
		Node temp = head;
		while(temp.next != null)
		{
			temp = temp.next;
		}
		temp.next = head;
	}


	/**
	 * @test
	 * methods to print the values before and after deleting nodes from circular LL
	 * for testing purpose
	 */

	public void printNodesCircular()
	{
		if(head == null)
			return;
		Node temp;
		Node temp2 = head;
		temp = head;
		while(temp.next != temp2)
		{
			System.out.println(temp.data);
			temp = temp.next;
		}
		System.out.println(temp.data);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Solution4 list = new Solution4();
		//add new nodes
		list.AddNewNode(1);
		list.AddNewNode(1);
		list.AddNewNode(3);
		list.AddNewNode(3);
		list.AddNewNode(2);
		list.AddNewNode(1);

		//make nodes circular for testing purpose
		list.makeCircular();
		
		System.out.println("Before deleting nodes!");
		list.printNodesCircular();
		list.deleteNodes(1);
		//list.deleteNodes(3);
		System.out.println("After deleting nodes!");
		list.printNodesCircular();
	}

}
