package B_LinkedList;

public class LinkedListLauncher {
	public static void main(String[] args)
	{
		
		MyLinkedList linkedList5 = new MyLinkedList();
		linkedList5.head = linkedList5.new Node(12);
		linkedList5.append(15);
		linkedList5.append(10);
		linkedList5.append(11);
		linkedList5.append(5);
		linkedList5.append(6);
		linkedList5.append(2);
		linkedList5.append(3);
		linkedList5.traversal();
		linkedList5.deleteNodesHavingBiggerRightValue();
		linkedList5.traversal();
		
	}
	
	
	
	

}
