package com.algo.day6.selfStudy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author Arya Soman
 *
 */


public class BinarySearchTree 
{
	Node root;
	
	public BinarySearchTree()
	{
		System.out.println("test1");
        Initialize();
       // CreateTree();
    }
//create BST
    public void Initialize()
    {
    	System.out.println("test");
        root = new Node(8);

        root.Left = new Node(3);
        root.Right = new Node(10);

        root.Left.Left = new Node(1);
        root.Left.Right = new Node(6);
        root.Right.Right = new Node(14);


        root.Left.Right.Left = new Node(4);
        root.Left.Right.Right = new Node(7);
        root.Right.Right.Left = new Node(13);


    }
    //create binary tree
    private void CreateTree(){
    	/*ArrayList<Integer> ar= new ArrayList<>();
    	ar.set(0, 1);
    	ar.get(0);
    	ar.set(0, ar.get(0)+1);*/
        Node node = new Node(1);


        node.Left = new Node(2);
        node.Right = new Node(3);

        node.Left.Left = new Node(4);
        node.Left.Right = new Node(5);

        node.Right.Left = new Node(6);
        node.Right.Right = new Node(7);

        

         node.Left.Left.Left = new Node(8);
         node.Left.Left.Right = new Node(9);
         node.Left.Right.Right = new Node(10);
         node.Right.Right.Right = new Node(11);

        root = node;

    }
    
    //inorder traversal -- gives sorted values
    public void inOrder()
    {
    	inOrder(root);
    }
    public void inOrder(Node node)
    {
    	//int i=0;
    	if(node == null)
    		return;
    	if(node!=null)
    	{
    		//System.out.println("inside while");
    		inOrder(node.Left);
    		//System.out.print(node.data + ",");
    		//array[i] = node.data;
    		//i++;
    		//System.out.println();
    		System.out.print(node.data + ",");
    		inOrder(node.Right);
    	}
    }
    
    //get smallest integer
    public void smallestNode()
    {    	
    	
    	if(root==null)
    	{
    		System.out.println("-1");
    	}
    	System.out.println("smallest = "+smallestNode(root)); 
    	
    }
    
    public int smallestNode(Node node)
    {    	
    	
    	while(node.Left!=null)
    	{
    		node = node.Left;
    	}
    	
    	return node.data;
    	//return -1;
    }
    public int largestNode(Node node)
    {
    	while(node.Right != null)
    	{
    		node = node.Right;
    	}
    	return node.data;
    }
    //take count of nodes
    public int countNodes(Node node)
    {
    	if(node == null)return 0;
    	return 1+ countNodes(node.Left) + countNodes(node.Right);
    }
    //BT ---> BST
    
   public void changeBTtoBST(Node node) 
   {
	   int[] array = new int[countNodes(node)];
	   int[] i = new int[1];
	   preOrder(root, array, i);
	   Arrays.sort(array);
	   /*for(int i=0;i<array.length;i++)
	   {
		   System.out.println(array[i]);
	   }*/
	   i[0]=0;
	   inOrder(root, array, i);
   }
   
   public void preOrder(Node node,int[] arr, int[] i)
   {
	   
	   if(node ==null)
		   return;
	   System.out.print(node.data);
	   arr[i[0]] = node.data;
	   i[0]++;
	   preOrder(node.Left,arr,i);
	   preOrder(node.Right,arr,i);
   }
   
   public void inOrder(Node node,int[] arr, int[] i)
   {
	   
	   if(node ==null)
		   return;
	   
	   inOrder(node.Left,arr,i);
	   node.data = arr[i[0]];
	   i[0]++;
	   System.out.print(node.data);
	   inOrder(node.Right,arr,i);
   }
    
    
  /*  public void changeBTtoBST(Node node) 
    {
 	   int[] array = new int[countNodes(node)];
 	   int i = 0;
 	   preOrder(root, array, i);
 	   Arrays.sort(array);
 	   for(int i=0;i<array.length;i++)
 	   {
 		   System.out.println(array[i]);
 	   }
 	   i=0;
 	   inOrder(root, array, i);
    }
    
    public void preOrder(Node node,int[] arr, int i)
    {
 	   
 	   if(node ==null)
 		   return;
 	   System.out.print(node.data);
 	   arr[i] = node.data;
 	   //i++;
 	   preOrder(node.Left,arr,i++);
 	   preOrder(node.Right,arr,i++);
    }
    
    public void inOrder(Node node,int[] arr, int i)
    {
 	   
 	   if(node ==null)
 		   return;
 	   
 	   inOrder(node.Left,arr,i);
 	   node.data = arr[i];
 	  // i++;
 	   System.out.print(node.data);
 	   inOrder(node.Right,arr,i++);
    }*/
    public void addNewNode(int data)
    {
    	Node node = new Node(data);
    	Node parent = null;
    	Node child = root;
    	
    	while(child != null)
    	{
    		parent = child;
    		if(child.data > data)
    			child = child.Left;
    		else
    			child = child.Right;
    	}
    	
    	if(parent.data > data)
    		parent.Left = node;
    	else
    		parent.Right = node;
    }
    public void findNode(int data)
    {
    	System.out.println("Node found = "+findNode(root, data));
    }
    public boolean findNode(Node node, int data)
    {
    	if(node == null)
    		return false;
    	if(node.data == data)
    	{
    		return true;
    	}
    	if(node.data > data)
    		return findNode(node.Left, data);
    	else
    		return findNode(node.Right, data);
    }
    
    //kth largest
    public void kthLargest( int k)
    {
    	int[] i= new int[1];
    	kthLargest(root, k, i);
    }
    
    public void kthLargest(Node node, int k, int[] count)
    {
    	if(node == null)
    		return;
    	kthLargest(node.Right,k,count);
    	count[0]++;
    	if(count[0] == k)
    		System.out.println("kth element is = "+node.data);
    	kthLargest(node.Left,k,count);
    }
    
   /* //testing
    
    public void kthLargesttesting(Node node, int k, int count)
    {
    	System.out.println("tetsing1");
    	if(node == null)
    		return;
    	kthLargesttesting(node.Right,k,count);
    	count++;
    	System.out.println("count="+count);
    	if(count == k)
    	{
    		System.out.println("TEST");
    		System.out.println("kth element while testing is = "+node.data);
    	}
    	kthLargesttesting(node.Left,k,count);
    }*/
    
    //not void
    public void kthLargestNode(int k)
    {
    	int[] count = new int[1];
    	Node[] temp = new Node[1];
    	Node[] result = kthLargestNode(root, k, count,temp);
    	System.out.println("result = "+result[0].data);
    }
    public Node[] kthLargestNode(Node node, int k, int[] count, Node[] temp)
    {
    	if(node != null)
    	{
    		kthLargestNode(node.Right, k, count,temp);
    		count[0]++;
    		if(count[0] == k)
    			temp[0] = node;
    		kthLargestNode(node.Left, k, count,temp);
    	}
    	return temp;
    }
    
   
    //smallest kth with return type
    
    public void kthSmallestNode(int k)
    {
    	int[] count = new int[1];
    	Node[] result = new Node[1];
    	Node[] res = kthSmallestNode(root, k, count, result);
    	System.out.println(k+"th Smallest node = " +res[0].data);
    }
    public Node[] kthSmallestNode(Node node, int k, int[] count, Node[] result)
    {
    	if(node !=null)
    	{
    		kthSmallestNode(node.Left, k, count, result);
    		count[0]++;
    		if(count[0] == k)
    			result[0] = node;
    		kthSmallestNode(node.Right, k, count, result);
    	}
    	return result;
    }
    public void findCeilingNode(int data)
    {
    	if(root == null)
    		return;
    	Node parent = null;
    	Node child = root;
    	
    	findCeilingNode(data, parent,child);
    }
    public void findCeilingNode(int data, Node parent, Node child)
    {
    	if(child.data == data)
    	{
    		System.out.println("Ceiling found ="+child.data);
    		return;
    	}
    	
    	if(child.data > data && child.Left !=null)
    	{
    		parent = child;
    		child = child.Left;
    		findCeilingNode(data,parent,child);
      	}
    	else if(child.data < data && child.Right !=null)
    	{
    		parent = child;
    		child = child.Right;
    		findCeilingNode(data,parent,child);
    	}
    	else
    	{
    		if(child.data > data)
    			System.out.println("Ceiling found ="+child.data);
    		else if(parent.data < data)
    			System.out.println("No ceiling found!");
    		else
    			System.out.println("Ceiling found ="+parent.data);
    	}
    	
    	
    }
    
    //print nodes in range
    
    public void printNodesInRange(Node node, int low, int high)
    {
    	if(node == null)
    		return;
    	if(node.data >= low && node.data <= high)
    		System.out.println(node.data);
    	if(node.data > low)
    		printNodesInRange(node.Right, low, high);
    	if(node.data < high)
    		printNodesInRange(node.Left, low, high);
    }
    
    public void printNodesInRange1(Node node, int low, int high)
    {
    	if(node != null)
    	{
    		printNodesInRange1(node.Left,low,high);
    		if(node.data >= low && node.data <= high)
        		System.out.println(node.data);
    		printNodesInRange1(node.Right,low,high);
    	}
    	
    	
    	/*if(node == null)
    		return;
    	if(node.data >= low && node.data <= high)
    		System.out.println(node.data);
    	if(node.data > low)
    		printNodesInRange(node.Right, low, high);
    	if(node.data < high)
    		printNodesInRange(node.Left, low, high);*/
    }
    
    
    /*public void findCeiling(int data)
    {
    	Node parent = null;
    	Node child = root;
    	while(child != null)
    	{
    		parent = child;
    		if(child.data == data)
    		{
    			System.out.println("Ceiling found ="+child.data);
    			return;
    		}
    		if(child.data > data)
    			child = child.Left;
    		else
    			child = child.Right;
    	}
    	
    	if(parent.data < data)
    		System.out.println("No ceiling found!");
    	else
    		System.out.println("Ceiling found ="+parent.data);
    }*/
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		BinarySearchTree bst = new BinarySearchTree();
		bst.inOrder();
		/*bst.smallestNode();
		System.out.println("largest = "+bst.largestNode(bst.root));
		//bst.BtToBst(bst.root);
		//bst.changeBTtoBST(bst.root);
		bst.addNewNode(5);
		bst.inOrder();
		System.out.println();
		bst.addNewNode(5);
		bst.inOrder();
		bst.findNode(0);
		//bst.kthLargest(5);
		bst.kthLargestNode(3);
		Node temp = null;
		int[] count = {0};*/
		//Node test= bst.kthLargestNodeTest(bst.root, 3, count, temp);
		//System.out.println("test result = "+test);
		//bst.kthLargesttesting(bst.root, 5, 0);
		//bst.kthSmallestNode(7);
		bst.findCeilingNode(0);
		//bst.findCeiling(2);
		//bst.printNodesInRange(bst.root, 2, 10);
		bst.printNodesInRange1(bst.root, 5, 10);
	}

}
