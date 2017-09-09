package B_LinkedList;

public class LinkedListLauncher {
	public static void main(String[] args)
	{
		MyLinkedList linkedList = new MyLinkedList();
		linkedList.head = linkedList.new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		linkedList.head.next = two;
		two.next = three;
		linkedList.push(0);
		linkedList.insertAfter(3, 4);
		linkedList.append(5);
		linkedList.insertAfterNode(linkedList.head.next, 10);
		linkedList.traversal();
		System.out.println();
		System.out.println(linkedList.findLengthIterative());
		//linkedList.deleteNode(4);
		//linkedList.deleteNode(4);
		linkedList.deletePosition(4);
		linkedList.deletePosition(400);
		System.out.println(linkedList.findLengthIterative());
		System.out.println(linkedList.findLengthRecursive(linkedList.head));
		linkedList.traversal();
		
/*		System.out.println(MyLinkedList.searchRecursive(linkedList.head,25));
		System.out.println(MyLinkedList.searchRecursive(linkedList.head,69));
		System.out.println(MyLinkedList.searchRecursive(linkedList.head,60));
		System.out.println(linkedList.getNthElement(1000));
		System.out.println(linkedList.getNthElement(4));
		System.out.println(linkedList.getNthElement(10));
		System.out.println(linkedList.getMiddleElement());
		System.out.println(linkedList2.getMiddleElement());
		System.out.println(linkedList.getNthFromEnd(1000));
		System.out.println(linkedList.getNthFromEnd(4));
		System.out.println(linkedList.getNthFromEnd(10));*/
		//linkedList.printReverse(linkedList.head);
		/*MyLinkedList.Node finalHead = linkedList.reverseListIterative();
		while(finalHead != null)
		{
			System.out.print(finalHead.data+",");
			finalHead = finalHead.next;
		}*/
		/*MyLinkedList.Node finalHead1 = linkedList.reverseRecursive(linkedList.head, null);
		while(finalHead1 != null)
		{
			System.out.println("recursive");
			System.out.print(finalHead1.data+",");
			finalHead1 = finalHead1.next;
		}*/
		System.out.println("before checking\n");
		linkedList.traversal();
		System.out.println("\n\n");
		System.out.println("ll1---"+linkedList.checkIfPalindrome());
		linkedList.traversal();
		MyLinkedList linkedList3 = new MyLinkedList();
		linkedList3.head = linkedList3.new Node(1);
		linkedList3.append(3);
		linkedList3.append(4);
		linkedList3.append(5);
		linkedList3.append(9);
		linkedList3.append(5);
		linkedList3.append(4);
		linkedList3.append(3);
		linkedList3.append(1);
		System.out.println("\n\n");
		linkedList3.traversal();
		System.out.println("ll3---"+linkedList3.checkIfPalindrome());
		linkedList3.traversal();
		MyLinkedList linkedList4 = new MyLinkedList();
		linkedList4.head = linkedList4.new Node(1);
		linkedList4.append(2);
		linkedList4.append(3);
		linkedList4.append(4);
		linkedList4.append(5);
		linkedList4.append(915);
		linkedList4.append(926);
		linkedList4.append(937);
		linkedList4.append(948);
		linkedList4.append(949);
		linkedList4.append(950);
		linkedList4.append(9500);
		//linkedList4.append(9501);
		linkedList4.traversal();
		int result = linkedList3.getIntersectingNode(linkedList4);
		//System.out.println("\nintersecting-->"+result);
		//System.out.println(new Integer(4).toString().hashCode());
		//System.out.println("4".hashCode());
		Node finalHead1 = linkedList4.pairwiseSwapIterative();
		System.out.println();
		while(finalHead1 != null)
		{
			//System.out.println("recursive");
			System.out.print(finalHead1.data+",");
			finalHead1 = finalHead1.next;
		}
		/*linkedList5.head = linkedList5.new Node(89);
		linkedList5.append(810);
		linkedList5.append(811);
		linkedList5.append(893);
		linkedList5.append(914);*/
		//linkedList5.moveLastElementToFirst();
		linkedList4.traversal();
		System.out.println("\n\nup 4, bottom 5\n\n");
		//linkedList5.traversal();
		//MyLinkedList newList = linkedList4.sortedIntersect(linkedList5);
		System.out.println();
		//newList.traversal();
		//linkedList4.traversal();
		/*linkedList4.deleteAlternateIterative();
		linkedList4.traversal();
		linkedList4.deleteAlternateRecursive(linkedList4.head);
		linkedList4.traversal();*/
		//linkedList4.deleteAlternateIntoTwoList();
		linkedList4.traversal();
		Node reversedInBatches = linkedList4.kAlternateReverse(linkedList4.head, 3);
		//linkedList4.traversal();
		System.out.println("before\n");
		while(reversedInBatches != null)
		{
			
			System.out.print(reversedInBatches.data+",");
			reversedInBatches = reversedInBatches.next;
		}
		System.out.println("after\n");
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
		//linkedList5.deleteNodesHavingBiggerRightValue();
		linkedList5.traversal();		
	}
	
	
	
	

}
