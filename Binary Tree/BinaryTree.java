/**
 * 
 */
package com.algo.day4.selfStudy;


import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * @author Arya Soman
 *
 */
public class BinaryTree 
{
	public Node root;
	
	public BinaryTree() 
	{
		createBinaryTree();
	}
	public void createBinaryTree()
	{
		/*Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.right.left = new Node(6);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.left.right.right = new Node(10);
		node.left.left.left = new Node(8);
		node.left.left.right = new Node(9);
		node.right.right = new Node(7);
		node.right.right.right = new Node(11);
		node.right.right.right.right = new Node(12);*/
		
		/*Node node = new Node(1);
		node.left = new Node(2);
		node.left.left = new Node(4);
		node.right = new Node(3);
		node.right.right = new Node(7);
		node.right.left = new Node(6);*/

		//root = node;
		
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.left.right.right = new Node(10);
		node.left.left.left = new Node(8);
		node.left.left.left.right = new Node(15);
		node.left.left.left.right.left = new Node(17);
		node.left.left.left.right.left.left = new Node(18);
		node.left.left.left.right.right = new Node(16);
		node.left.left.right = new Node(9);
		node.right.left = new Node(6);
		node.right.left.left = new Node(13);
		node.right.left.left.left = new Node(14);
		node.right.right = new Node(7);
		node.right.right.right = new Node(11);
		node.right.right.right.right = new Node(12);
		root = node;
		
	}
	public void preOrderTraversal()
	{
		preOrderTraversal(root);
	}
	public void preOrderTraversal(Node node)
	{
		if(node != null)
		{
			System.out.print(node.data + " , ");
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}
	
	public void postOrderTraversal(Node node)
	{
		if(node != null)
		{
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.data + " , ");
		}
	}
	
	public void inOrderTraversal(Node node)
	{
		if(node != null)
		{
			inOrderTraversal(node.left);
			System.out.print(node.data + " , ");
			inOrderTraversal(node.right);
		}
	}
	
	public int getSize(Node node)
	{
		if(node == null)
			return 0;
		return 1+ getSize(node.left) + getSize(node.right);
	}
	
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
	
	//zigzag
	
	public void zigzag()
	{
		if(root == null)
			return;
		Queue<Node> que = new LinkedList<>();
		Stack<Node> stack = new Stack<Node>();
		boolean temp = true;
		que.add(root);
		que.add(null);
		
		while(que.size() != 0)
		{
			Node node = que.poll();
			if(node != null)
			{	
				if(temp)
				System.out.print(node.data +" , ");
				else
					stack.push(node);
				if(node.left != null)
					que.add(node.left);
				if(node.right != null)
					que.add(node.right);
				
			}
			else
			{
				//System.out.println();
				while(stack.size() != 0)
					System.out.print(stack.pop().data +" , ");
				System.out.println();
				if(que.size() == 0)
					return;
				temp = !temp;
				que.add(null);
			}
		}
	}
	
	//height of tree
	
	public int findHeight(Node node)
	{
		if(node == null)
			return 0;
		else
		{
			return 1 + Math.max(findHeight(node.left), findHeight(node.right));
		}
	}
	
	//print all left, right and leaf nodes
	
	public void printLeftNodes(Node node)
	{
		if(node == null)
			return;
		else
		{
			System.out.println(node.data);
			if(node.left != null)
				printLeftNodes(node.left);
						
		}
	}
	
	public void printRightNodes(Node node)
	{
		if(node == null)
			return;
		else
		{
			System.out.println(node.data);
			if(node.right != null)
				printRightNodes(node.right);
						
		}
	}
	
	public void printLeafNodes(Node node)
	{
		if(node == null)
			return;
		else
		{
			
			if(node.left == null && node.right == null)
				System.out.println(node.data);
				printLeafNodes(node.left);
				printLeafNodes(node.right);
						
		}
	}
	
	//print perimeter, in correct order
	//to print in correct order, we make use of stack to reverse the right node elemets
	public void printPerimeter(Node node, int left, int right)
	{
		Stack<Node> stack = new Stack<>();
		printPerimeter(node, 0, 0,stack);
		while(stack.size() != 0)
			System.out.print(stack.pop().data +" , ");
	}
	public void printPerimeter(Node node, int left, int right, Stack<Node> stack)
	{
		
		if(node != null)
		{
			if(left == 0 && right == 0)
				System.out.print(node.data+" , ");
			//right elemets pushed to stack for reversal
			else if(left == 0 && right != 0)
				stack.push(node);
				
			else if(left != 0 && right == 0)
				System.out.print(node.data+" , ");
			//leaf nde
			else if(node.left == null && node.right == null)
				System.out.print(node.data+" , ");
			
			printPerimeter(node.left, left+1, right,stack);
			printPerimeter(node.right, left, right+1,stack);
		}
	}
	
	public void printLeftView()
	{
		if(root==null)
			return;
		Queue<Node> que = new LinkedList<>();
		boolean temp=true;
		que.add(root);
		que.add(null);
		
		while(que.size() != 0)
		{
			Node node = que.poll();
			if(node != null) 
			{
				if(temp)
				{
				System.out.print(node.data);
				temp = false;
				}
				if(node.left != null)
					que.add(node.left);
				if(node.right != null)
					que.add(node.right);
			}
			else
			{
				System.out.println();
				if(que.size() ==0)
					break;
				temp = true;
				que.add(null);
			}
		}
		
	}
	
	//right view -complicated
	
	public void printRightView()
	{
		if(root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		Stack<Node> st= new Stack<>();
		boolean temp = true;
		q.add(root);
		q.add(null);
		
		while(q.size() != 0)
		{
			Node node = q.poll();
			if(node != null)
			{
				st.push(node);
				if(node.left != null)
					q.add(node.left);
				if(node.right != null)
					q.add(node.right);
			}
			else
			{
				while(st.size() != 0)
				{
					if(temp) {
					System.out.println(st.pop().data);
					temp = false;
					}
					if(st.size() != 0)
					st.pop();
				}
				//System.out.println();
				if(q.size() == 0)
					break;
				q.add(null);
				temp = true;
			}
		}
	}
	
	//reight view easy
	
	public void rightViewEasy()
	{
		if(root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		q.add(null);
		Node temp = root; //to hold the last node 
		
		while(q.size() != 0)
		{
			Node node = q.poll();
			if(node != null)
			{
				temp = node;
				if(node.left != null)
					q.add(node.left);
				if(node.right != null)
					q.add(node.right);
			}
			else
			{
				System.out.println(temp.data);
				if(q.size() == 0)
					break;
				q.add(null);
			}
		}
		
	}
	//top view
	/*public void topView(Node node, int left, int right)
	{
		if(node == null)
			return;
		if(left == 0 && right == 0)
			System.out.println(node.data);
		else if(left == 0 && right != 0)
			System.out.println(node.data);
		else if(left != 0 && right == 0)
			System.out.println(node.data);
		topView(node.left, left+1, right);
		topView(node.right, left, right + 1);
		
	}*/
	
	public void topViewWithoutRepetition()
	{
		int hd = 0;
		TreeMap<Integer, Node> map = new TreeMap<>();
		if(root == null)
			return;
		Queue<Node> que = new LinkedList<>();
		root.hd=hd;
		Node node;
		que.add(root);
		
		while(que.size() != 0)
		{
			node = que.poll();
			hd = node.hd;
			if(!map.containsKey(hd))
			map.put(hd, node);
			if(node.left != null)
			{
				node.left.hd = hd - 1;
				que.add(node.left);
			}
			if(node.right != null)
			{	
				node.right.hd = hd + 1;
				que.add(node.right);
			}	
		}
		Set<Integer> keys = map.keySet();

		for(Integer i : keys)
		{
			System.out.println("Key: " +i+ " & Value: " +map.get(i).data);
		}
	}

	
	//max width
	
	public int maxWidth()
	{
		Queue<Node> que = new LinkedList<>();
		que.add(root);
		que.add(null);
		int count = 0;
		int i=0;
		int[] counter = new int[10];
		
		while(que.size() != 0)
		{
			Node node = que.poll();
			if(node != null)
			{
				//System.out.println(node.data +" ");
				count++;
				if(node.left != null)
					que.add(node.left);
				if(node.right != null)
					que.add(node.right);
			}
			else
			{
				//System.out.println("count : "+count);
				
				counter[i] = count;
				count=0;
				
				i++;
				//System.out.println();
				if(que.size() == 0)
					break;
				que.add(null);
			}
		}
		
			for(int k=0;k < counter.length-1;k++)
			{
				if(counter[k] > counter[k+1])
						{
							int temp = counter[k];
							counter[k] = counter[k+1];
							counter[k+1] = temp;
							//System.out.println(counter[k]);
						}
			}
		return counter[counter.length-1];
	}
	
	
	//max width - O(n)
	
		public int maxWidthOfTree()
		{
			if(root == null)
				return 0;
			Queue<Node> que = new LinkedList<>();
			que.add(root);
			que.add(null);
			int maxWidth = 1;
			while(que.size() != 0)
			{
				
				
				Node node = que.poll();
				if(node != null)
				{
					//System.out.println(node.data +" ");
					
					if(node.left != null)
						que.add(node.left);
					if(node.right != null)
						que.add(node.right);
				}
				else
				{
					int queSize = que.size();
					System.out.println("queSize: "+queSize);
					System.out.println("maxWidth:"+maxWidth);
					maxWidth = Math.max(queSize, maxWidth);
					if(que.size() == 0)
						break;
					que.add(null);
				}
			}
			
			return maxWidth;
		}
		
		
	//bottom view
	
	public void bottomView()
	{
		Hashtable<Integer, Node> hash = new Hashtable<>();
		bottomView(root, hash, 0);
		Set<Integer> keys = hash.keySet();
		for(Integer i : keys)
		{
			System.out.println("Key: " +i+ " & Value: " +hash.get(i).data);
		}
	}
	
	public void bottomView(Node node,Hashtable<Integer, Node> hash, int cursor)
	{
		if(node!=null)
		{
			hash.put(cursor, node);
			bottomView(node.left, hash, cursor-1);
			bottomView(node.right, hash, cursor+1);
		}
	}
	
	//sorted
	//bottom correct code:
	
	public void bottomViewSorted()
	{
		int hd = 0;
		TreeMap<Integer, Node> map = new TreeMap<>();
		if(root == null)
			return;
		Queue<Node> que = new LinkedList<>();
		root.hd=hd;
		Node node;
		que.add(root);
		
		while(que.size() != 0)
		{
			node = que.poll();
			hd = node.hd;
			map.put(hd, node);
			if(node.left != null)
			{
				node.left.hd = hd - 1;
				que.add(node.left);
			}
			if(node.right != null)
			{	
				node.right.hd = hd + 1;
				que.add(node.right);
			}	
		}
		Set<Integer> keys = map.keySet();

		for(Integer i : keys)
		{
			System.out.println("Key: " +i+ " & Value: " +map.get(i).data);
		}
	}
	
	/*public void bottomViewSorted()
	{
		TreeMap<Integer, Node> tree = new TreeMap<>();
		bottomViewSorted(root, tree, 0);
		Set<Integer> keys = tree.keySet();
		for(Integer i : keys)
		{
			System.out.println("Key: " +i+ " & Value: " +tree.get(i).data);
		}
	}
	
	public void bottomViewSorted(Node node,TreeMap<Integer, Node> tree, int cursor)
	{
		if(node!=null)
		{
			tree.put(cursor, node);
			bottomViewSorted(node.left, tree, cursor-1);
			bottomViewSorted(node.right, tree, cursor+1);
		}
	}
	
	public void bottomViewLinked()
	{
		LinkedHashMap<Integer, Node> tree = new LinkedHashMap<>();
		bottomViewLinked(root, tree, 0);
		Set<Integer> keys = tree.keySet();
		for(Integer i : keys)
		{
			System.out.println("Key: " +i+ " & Value: " +tree.get(i).data);
		}
	}
	
	public void bottomViewLinked(Node node,LinkedHashMap<Integer, Node> tree, int cursor)
	{
		if(node!=null)
		{
			tree.put(cursor, node);
			bottomViewLinked(node.left, tree, cursor-1);
			bottomViewLinked(node.right, tree, cursor+1);
		}
	}
	
	//hashmap
	
	public void bottomViewMap()
	{
		HashMap<Integer, Node> tree = new HashMap<>();
		bottomViewMap(root, tree, 0);
		Set<Integer> keys = tree.keySet();
		for(Integer i : keys)
		{
			System.out.println("Key: " +i+ " & Value: " +tree.get(i).data);
		}
	}
	
	public void bottomViewMap(Node node,HashMap<Integer, Node> tree, int cursor)
	{
		if(node!=null)
		{
			tree.put(cursor, node);
			bottomViewMap(node.left, tree, cursor-1);
			bottomViewMap(node.right, tree, cursor+1);
		}
	}*/
	
	public static void main(String[] args)
	{
		BinaryTree bin = new BinaryTree();
		//bin.preOrderTraversal();
//		bin.preOrderTraversal(bin.root);
//		System.out.println();
//		bin.postOrderTraversal(bin.root);
//		System.out.println();
//		bin.inOrderTraversal(bin.root);
//		System.out.println();
//		System.out.println("size is: " +bin.getSize(bin.root));
	bin.printLevelOrder();
//		bin.zigzag();
//		System.out.println("Height of tree : " +bin.findHeight(bin.root));
//		bin.printLeftNodes(bin.root);
//		System.out.println();
//		bin.printRightNodes(bin.root);
//		System.out.println();
//		bin.printLeafNodes(bin.root);
//		System.out.println("perimeter");
//		bin.printPerimeter(bin.root, 0, 0);
//		System.out.println("left nodes");
//		bin.printLeftView();
//		System.out.println("top view");
//		bin.topView(bin.root, 0, 0);
//		System.out.println("max width:" +bin.maxWidth());
//		System.out.println("right view");
//		bin.printRightView();
//		System.out.println("right view easy");
//		bin.rightViewEasy();
		System.out.println("bottom");
		bin.bottomView();
		System.out.println("bottom sort");
		bin.bottomViewSorted();
//		System.out.println("bottom linked");
//		bin.bottomViewLinked();
//		System.out.println("map");
//		bin.bottomViewMap();
//		System.out.println("maxWidthOfTree : "+bin.maxWidthOfTree());
		bin.topViewWithoutRepetition();
	}
}
