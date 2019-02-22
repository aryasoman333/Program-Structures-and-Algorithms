package com.algo.finalTerm;

/**
 * @author Arya Soman
 *Given a binary tree, you need to compute the length of the diameter of the tree. The
diameter of a binary tree is the length of the longest path between any two nodes in a
tree. This path may or may not pass through the root.
 */

class Node
{
	int data;
	Node left;
	Node right;
	public Node(int data)
	{
		this.data = data;
	}
}
public class Solution2 
{
	Node root;
	public Solution2()
	{
		createTree();
	}

	public void createTree()
	{
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.left.left = new Node(4);
		node.left.left.left.left = new Node(4);
		node.left.left.left.left.left = new Node(4);
		node.left.right = new Node(5);
		node.left.right.right = new Node(6);
		node.left.right.left = new Node(8);
		node.left.right.left.left = new Node(8);
		node.right.right = new Node(7);
		node.right.left = new Node(17);
		root = node;
	}

	public int diameterOfBinaryTree(Node root) 
	{	
		if(root == null)
			return 0;
		int leftHeight = getHeight(root.left);
		int righttHeight = getHeight(root.right);

		int leftDiameter = diameterOfBinaryTree(root.left);
		int rightDiameter = diameterOfBinaryTree(root.right);

		return Math.max(leftHeight + righttHeight, Math.max(leftDiameter, rightDiameter));
	}

	public int getHeight(Node node)
	{
		if(node == null)
			return 0;
		return 1 + Math.max(getHeight(node.left), getHeight(node.right));
	}
	public static void main(String[] args) 
	{
		Solution2 sol = new Solution2();
		System.out.println(sol.diameterOfBinaryTree(sol.root));
	}

}
