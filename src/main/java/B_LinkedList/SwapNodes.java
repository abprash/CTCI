package B_LinkedList;

public class SwapNodes {
	public static void main(String[] args)
	{
		//aim:
		//swap two nodes of a linked list without swapping the data
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.head = linkedList.new Node(1);
		linkedList.append(25);
		linkedList.append(37);
		linkedList.append(40);
		linkedList.append(50);
		linkedList.append(60);
		linkedList.traversal();
		System.out.println();
		/*linkedList.swapNodes(2, 5);
		linkedList.swapNodes(12, 25);
		System.out.println();
		linkedList.traversal();
		linkedList.swapNodes(1, 5);
		System.out.println();
		linkedList.traversal();
		linkedList.swapNodes(6, 5);
		System.out.println();
		linkedList.traversal();
		linkedList.swapNodes(2, 1);
		System.out.println();
		linkedList.traversal();*/
		MyLinkedList linkedList2 = new MyLinkedList();
		linkedList2.head = linkedList2.new Node(10);
		linkedList2.append(11);
		linkedList2.append(30);
		linkedList2.append(41);
		linkedList2.append(50);
		linkedList2.append(69);
		linkedList2.traversal();
/*		MyLinkedList.Node finalHead = linkedList.mergeWith(linkedList2);
		while(finalHead != null)
		{
			System.out.print(finalHead.data+",");
			finalHead = finalHead.next;
		}*/
		
		//search an element in a linked list
		System.out.println(MyLinkedList.searchRecursive(linkedList.head,25));
		System.out.println(MyLinkedList.searchRecursive(linkedList.head,69));
		System.out.println(MyLinkedList.searchRecursive(linkedList.head,60));
		System.out.println(linkedList.getNthElement(1000));
		System.out.println(linkedList.getNthElement(4));
		System.out.println(linkedList.getNthElement(10));
		System.out.println(linkedList.getMiddleElement());
		System.out.println(linkedList2.getMiddleElement());
		System.out.println(linkedList.getNthFromEnd(1000));
		System.out.println(linkedList.getNthFromEnd(4));
		System.out.println(linkedList.getNthFromEnd(10));
	}

}
