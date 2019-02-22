package com.algo.midterm.sol1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Arya Soman
 *
 *[Question 1]
 * Invert a binary tree.
Example:
Input:
     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:
     4
   /   \
  7     2
 / \   / \
9   6 3   1

 *
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

public class Solution1 
{	
	Node root;

	public Solution1()
	{
		CreateTree();
	}
	/**
	 * method to create a binary tree
	 *
	 */
	private void CreateTree()
	{
		Node node = new Node(4);
		node.left = new Node(2);
		node.right = new Node(7);
		node.left.left = new Node(1);
		node.left.right = new Node(3);
		node.right.left = new Node(6);
		node.right.right = new Node(9);
		root = node;
	}

	/**
	 * method to Invert a binary tree(RECURSIVE solution)
	 *
	 */ 

	public void invertBinaryTree()
	{
		System.out.println("Before inverting tree");
		printLevelOrder();
		invertBinaryTree(root);
		System.out.println("After inverting tree");
		printLevelOrder();
	}

	public void invertBinaryTree(Node node)
	{
		if(node == null)
			return;
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
		invertBinaryTree(node.left);
		invertBinaryTree(node.right);
	}

	/**
	 * method to Invert a binary tree(ITERATIVE solution)
	 *
	 */ 

	public void invertBinaryTreeIterative()
	{
		System.out.println("Before inverting tree");
		printLevelOrder(root);
		Node node = invertBinaryTreeIterative(root);
		System.out.println("After inverting tree");
		printLevelOrder(node);
	}

	public Node invertBinaryTreeIterative(Node node)
	{
		if(node == null)
			return null;
		Queue<Node> que = new LinkedList<>();
		que.add(node);
		while(que.size() != 0)
		{
			Node temp1 = que.poll();
			Node temp2 = temp1.left;
			temp1.left = temp1.right;
			temp1.right = temp2;
			if(temp1.left != null)
				que.add(temp1.left);
			if(temp1.right != null)
				que.add(temp1.right);
		}
		return node;
	}

	/**
	 * @test
	 * methods to print the values before and after inverting the tree
	 * for testing purpose
	 */

	public void printLevelOrder()
	{
		if(root == null)
			return;
		Queue<Node> que = new LinkedList<>();
		que.add(root);
		que.add(null);


		while(que.size() != 0)
		{
			Node node = que.poll();

			if(node != null)
			{
				System.out.print(node.data +" ");
				if(node.left != null)
					que.add(node.left);
				if(node.right != null)
					que.add(node.right);
			}
			else
			{
				System.out.println();
				if(que.size() == 0)
					return;
				que.add(null);
			}
		}
	}

	public void printLevelOrder(Node node1)
	{
		if(node1 == null)
			return;
		Queue<Node> que = new LinkedList<>();
		que.add(node1);
		que.add(null);


		while(que.size() != 0)
		{
			Node node = que.poll();

			if(node != null)
			{
				System.out.print(node.data +" ");
				if(node.left != null)
					que.add(node.left);
				if(node.right != null)
					que.add(node.right);
			}
			else
			{
				System.out.println();
				if(que.size() == 0)
					return;
				que.add(null);
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Solution1 sol = new Solution1();
		sol.invertBinaryTree();
		//sol.invertBinaryTreeIterative();
	}

}
