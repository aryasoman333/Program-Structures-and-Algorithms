package com.algo.midterm.sol2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Arya Soman
 * 
 *[Question 2]
 * Merge two binary trees into a new binary tree. The merge rule is that if two nodes overlap, 
 * then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
Example:
Input: 
	Tree 1                     Tree 2                  
          1                         2                             
         / \                       / \                            
        3   2                     1   3                        
       /                           \   \                      
      5                             4   7                  
Output: 
Merged tree:
	     3
	    / \
	   4   5
	  / \   \ 
	 5   4   7

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

public class Solution2 
{
	Node root;
	Node a;
	Node b;

	public Solution2()
	{
		CreateTree();
	}
	/**
	 * method to create a binary tree
	 *
	 */
	private void CreateTree()
	{
		a = new Node(1);
		a.left = new Node(3);
		a.left.left = new Node(5);
		a.right = new Node(2);

		b = new Node(2);
		b.left = new Node(1);
		b.right = new Node(3);
		b.right.right = new Node(7);
		b.left.right = new Node(4);
	}
	/**
	 * method to merge 2 binary trees
	 *
	 */ 
	public Node mergeNodes(Node node1, Node node2)
	{
		if(node1 == null)
			return node2;
		if(node2 == null)
			return node1;
		node1.data = node1.data + node2.data;
		node1.left = mergeNodes(node1.left, node2.left);
		node1.right = mergeNodes(node1.right, node2.right);
		return node1;
	}

	/**
	 * @test
	 * methods to print the values before and after merging the trees
	 *testing purpose
	 */

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

	public static void main(String[] args) 
	{
		Solution2 sol = new Solution2();
		System.out.println("Before merge!");
		sol.printLevelOrder(sol.a);
		sol.printLevelOrder(sol.b);
		Node node = sol.mergeNodes(sol.a, sol.b);
		System.out.println("Merged!");
		sol.printLevelOrder(node);
	}

}
