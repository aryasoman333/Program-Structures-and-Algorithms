package com.algo.midterm.sol3;
/**
 * @author Arya Soman
 * 
 *[Question 3]
 * Given two binary trees, write a function to check if they are the same or not.
	Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 */

/**
 * Node class to define the basic node elements
 *
 */

class Node 
{
	Node left;
	Node right;
	int data;

	public Node(int data)
	{
		this.data = data;
	}
}

public class Solution3 
{
	Node root;
	Node a;
	Node b;
	Node a1;
	Node b1;

	public Solution3()
	{
		CreateTree();
	}
	/**
	 * method to create a binary tree
	 *
	 */
	private void CreateTree()
	{

		//sample nodes which are not identical
		a = new Node(1);
		a.left = new Node(3);
		a.left.left = new Node(5);
		a.right = new Node(2);


		b = new Node(2);
		b.left = new Node(1);
		b.right = new Node(3);
		b.right.right = new Node(7);
		b.left.right = new Node(4);

		//sample nodes which are identical
		a1 = new Node(1);
		a1.left = new Node(3);
		a1.left.left = new Node(5);
		a1.right = new Node(2);


		b1 = new Node(1);
		b1.left = new Node(3);
		b1.right = new Node(2);
		b1.left.left = new Node(5); 
	}
	/**
	 * method to check if 2 trees are identical
	 *
	 */  
	public boolean isIdentical(Node node1, Node node2)
	{
		if(node1 == null && node2 == null)
			return true;
		if(node1 == null || node2 == null)
			return false;
		return (node1.data == node2.data) && isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Solution3 sol = new Solution3();
		System.out.println("is identical = "+sol.isIdentical(sol.a, sol.b));
		System.out.println("is identical = "+sol.isIdentical(sol.a1, sol.b1));
	}

}
