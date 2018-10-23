package com.algo.day3.selfStudy;

import algoDay3.Node;

public class Linkedlist 
{
	Node head;

	public void AddNewNode(int data)
	{

		//created new node--method 1
		/*Node node = new Node();
		node.data = data;
		node.Next = null;*/


		//created new node--method 2 -- create parametrised constructor in Node class
		Node node = new Node(data);

		//join the new node--node--to existing LL

		//check if LL is null

		if(head == null)

		{
			head=node;
		}
		else
		{
			Node temp;
			temp = head;
			while(temp.Next != null)
			{
				temp = temp.Next;
			}

			temp.Next = node;

		}

	}

	//finding mid

	public Node findMid(Node node)
	{
		if(node == null)
			return null;
		Node fast = head;
		Node slow = head;

		while(fast !=null)
		{
			fast = fast.Next;
			if(fast!=null)
			{
				fast = fast.Next;
				slow = slow.Next;
			}
		}
		fast = slow.Next;
		slow.Next = null;
		return slow;

	}

	//method to add node to head

	public void addNodeToHead(int data)
	{
		Node node = new Node(data);
		node.Next=head;
		head = node;
	}

	//method to display the LL- nodes
	public void showLL()
	{
		Node temp;
		temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.Next;
		}
		//System.out.println(temp.data);
	}

	public int findNthElementFromEnd(int n)

	//3 pre checks are there
	//head = null
	//n<=0
	//n > length of LL
	{
		if(head == null || n <=0)
			return -1;

		Node front = head;
		Node back = head;

		for(int i=0 ; i < n ; i++)
		{
			front = front.Next;
			//check for n > length of LL
			if(front == null)
				return -1;
		}

		while(front != null)
		{
			front = front.Next;
			back = back.Next;
		}
		return back.data;
	}

	//to take count of nodes

	public int nodeCount()
	{
		int count = 0;
		if(head == null)
			return 0;
		else
		{
			Node temp=head;

			while(temp!=null)
			{
				temp = temp.Next;
				count++;
			}
		}
		return count;
	}

	public void reverseLL()
	{
		//check pre condition
		if (head == null || head.Next == null)
			return;

		Node back = null;
		Node mid = head;
		Node front = head.Next;

		while(front != null)
		{
			mid.Next = back;
			back = mid;
			mid = front;
			front = front.Next;
		}

		mid.Next = back;
		head = mid;
	}

	//to find middle element

	public Node findMidElement()
	{

		//precheck

		if(head == null || head.Next == null)
			return head;

		Node front = head;
		Node back = head;

		while(front != null)
		{
			front = front.Next;
			if(front != null)
			{
				front = front.Next;
				back = back.Next;
			}
		}
		return back;
	}

	//check if palindrome

	/*public boolean isPalindrome()
	{
		if(head == null || head.Next == null)
		{
			return true;
		}

		Node secondHalf = getSecondHalf();
		secondHalf = reverseForPalindrome(secondHalf);
		Node firstHalf = head;
		while(firstHalf != null && secondHalf != null)
		{

			if(firstHalf.data != secondHalf.data)
			{
				return false;
			}

			firstHalf = firstHalf.Next;
			secondHalf = secondHalf.Next;

		}
		return true;
	}*/


	public Node getSecondHalf()
	{
		if(head == null || head.Next == null)
			return null;
		Node front = head;
		Node back = head;
		while(front != null)
		{
			front = front.Next;
			if(front != null)
			{
				front = front.Next;
				back = back.Next;
			}
		}
		Node temp = back.Next;
		back.Next = null;
		return temp;
	}

	//method for palindrome

	public Node reverseForPalindrome(Node node)
	{
		if(node == null || node.Next == null)
			return null;
		Node back = null;
		Node mid = node;
		Node front = node.Next;

		while(front != null)
		{
			mid.Next = back;
			back = mid;
			mid = front;
			front = front.Next;
		}
		mid.Next = back;
		return mid;
		//head = mid;
	}

	//to find if the node is cyclic

	public boolean isCyclic()
	{
		Node front = head;
		Node back = head;
		while(front != null)
		{
			front = front.Next;
			if(front == null)
				return false;
			front = front.Next;
			back = back.Next;

			if(front == back)
				return true;
		}
		return false;
	}

	//making cyclic node

	public void cyclicNode()
	{
		AddNewNode(1);
		AddNewNode(2);
		AddNewNode(3);
		AddNewNode(4);
		AddNewNode(57);
		AddNewNode(99);
		AddNewNode(7);
		AddNewNode(8);
		AddNewNode(9);
		AddNewNode(10);
		AddNewNode(11);
		Node mid = findMidElement();
		Node last = findLastElement();
		last.Next = mid;
		System.out.println("mid elemet : " +mid.data);

	}
	public Node findLastElement()
	{
		if(head == null || head.Next == null)
		{
			return head;
		}
		Node temp = head;
		while(temp.Next != null)
		{
			temp = temp.Next;
		}
		return temp;

	}
	//sorting and merging of two sorted LL

	public Node mergeSort(Node node1,Node node2)
	{
		Node result = null;
		if(node1 == null)
			return node2;
		if(node2 == null)
			return node1;
		if (node1.data < node2.data) 
		{
			result = node1;
			result.Next = mergeSort(node1.Next, node2);
		}
		else
		{
			result = node2;
			result.Next = mergeSort(node1, node2.Next);
		}
		return result;
	}
	public void sortTest()
	{
		Node node1=new Node(4);
		node1.Next = new Node(6);
		node1.Next.Next = new Node(9);

		Node node2=new Node(1);
		node2.Next = new Node(7);
		node2.Next.Next = new Node(60);
		Node result = mergeSort(node1, node2);
		while(result.Next !=null)
		{
			System.out.println("result :" +result.data);
			result = result.Next;
		}


	}

	//to find start of a loop

	public Node findStartOfLoop()
	{
		Node fast = head;
		Node slow = head;
		while(fast != null)
		{
			fast = fast.Next;
			if(fast == null)
			{
				return null;
			}
			else
			{
				fast = fast.Next;
				slow = slow.Next;
			}
			if(fast == slow)
				break;
		}

		if(fast == null)
			return null;

		slow = head;
		while(fast != slow)
		{
			fast = fast.Next;
			slow = slow.Next;
		}
		return slow;
	}

	//zip merge

	public void zipMerge()
	{
		Node firstHalf = head;
		Node secondHalf = getSecondHalf();
		secondHalf = reverseForPalindrome(secondHalf);
		head = zipMerge(firstHalf, secondHalf, true);
		while(head != null)
		{
			System.out.println(head.data);
			head=head.Next;
		}
	}

	public Node zipMerge(Node node1,Node node2, Boolean bSwitch)
	{
		Node result = null;
		if(node1 == null)
			return node2;
		if(node2 == null)
			return node1;
		if(bSwitch)
		{
			result = node1;
			result.Next = zipMerge(node1.Next, node2, false);
		}
		else
		{
			result = node2;
			result.Next = zipMerge(node1, node2.Next, true);
		}
		return result;
	}
	//to find if 2 LL intersect
	//count method for intersection

	public int countNodes(Node node)
	{

		int count = 0;
		if(node == null)
		{
			return 0;
		}
		else
		{
			Node temp=node;
			while(temp!=null)
			{
				temp = temp.Next;
				count++;
			}
		}
		return count;
	}

	public boolean ifIntersect(Node node1, Node node2)
	{
		Node front;
		Node back;
		int count1= 0;
		int count2 = 0; 
		int count = 0;

		count1 = countNodes(node1);
		count2 = countNodes(node2);
		System.out.println("count1: " +count1);
		System.out.println("count2: "+count2);
		if(count1 > count2)
		{
			count = count1 - count2;
			front = node1;
			back = node2;
		}
		else
		{
			count = count2 - count1;
			front = node2;
			back = node1; 
		}

		for(int i=0 ; i < count ; i++)
		{
			front = front.Next;
		}

		while(front.Next != null)
		{
			front = front.Next;
			back = back.Next;
			if(front == back)
			{
				System.out.println("front :"+front.data);
				System.out.println("back :"+back.data);
				System.out.println("inside true");
				return true;
			}
		}
		return false;
	}
	public boolean isPalindrome() 
	{
		Node secondHalf = findHalf();
		Node firstHalf = head;
		secondHalf = reverse(secondHalf);
		while(firstHalf !=null && secondHalf !=null)
		{
			System.out.println("firstHalf.data"+firstHalf.data);
			System.out.println("secondHalf.data"+secondHalf.data);
			if(firstHalf.data != secondHalf.data)
				return false;
			firstHalf =firstHalf.Next;
			secondHalf = secondHalf.Next;
		}
		return true;
	}
	public Node findHalf()
	{
		Node fast = head;
		Node slow = head;
		System.out.println("test1");
		while(fast != null)
		{
			System.out.println("test2");
			fast = fast.Next;
			if(fast == null)
				break;

			{
				System.out.println("test3");
				fast = fast.Next;
				slow =slow.Next;
			}
		}
		System.out.println("slow="+slow.data);
		fast = slow;
		System.out.println("fast="+fast.data);
		return fast;
	}

	public Node reverse(Node secondHalf)
	{
		Node back = null;
		Node mid = secondHalf;
		Node front = secondHalf.Next;
		System.out.println("mid="+mid.data);
		System.out.println("secondHalf ="+secondHalf.data);
		System.out.println("front="+front.data);
		while(front!=null)
		{
			mid.Next = back;
			back = mid;
			mid = front;
			front = front.Next;
		}
		mid.Next = back;
		System.out.println("secondHalf data="+secondHalf.data);
		return mid;

	}


	public void testIntersection()
	{
		Node node1=new Node(4);
		node1.Next = new Node(6);
		Node temp = node1.Next;
		node1.Next.Next = new Node(9);
		node1.Next.Next.Next = new Node(5);

		node1.Next.Next.Next.Next = new Node(2);

		node1.Next.Next.Next.Next.Next = new Node(9);
		/*while(node1 != null)
		{
			System.out.println(node1.data);
			node1=node1.Next;
		}*/
		System.out.println();
		Node node2=new Node(1);
		node2.Next = new Node(1);
		node2.Next.Next = new Node(6);
		node2.Next.Next.Next = temp;
		/*while(node2 != null)
		{
			System.out.println(node2.data);
			node2=node2.Next;
		}*/
		boolean result = ifIntersect(node1, node2);
		System.out.println("intersection result : "+result);
	}

	public void deleteNode(int data)
	{
		Node temp = head;
		while(temp.Next.data != data)
		{
			temp = temp.Next;
		}
		Node temp1 = temp.Next.Next;
		temp.Next = temp1;
	}
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Linkedlist list = new Linkedlist();
		list.AddNewNode(1);
		list.AddNewNode(2);
		list.AddNewNode(3);
		list.AddNewNode(2);
		list.AddNewNode(1);
		list.showLL();
		System.out.println("palind ?"+ list.isPalindrome());
	}

}
