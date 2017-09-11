package B_LinkedList;

import java.util.HashSet;

public class LinkedListLauncher {
	public static void main(String[] args)
	{
		
		MyLinkedList linkedList5 = new MyLinkedList();
		linkedList5.head = linkedList5.new Node(12);
		linkedList5.append(5);
		linkedList5.append(1);
		linkedList5.append(1);
		linkedList5.append(5);
		linkedList5.append(6);
		linkedList5.append(2);
		linkedList5.append(3);
		linkedList5.traversal();
		//linkedList5.deleteNodesHavingBiggerRightValue();
		linkedList5.traversal();
		System.out.println(removeDups(linkedList5));
	}
	//CTCI Linked list problems
	
	public static HashSet<Integer> removeDups(MyLinkedList list){
		if(list == null)
			return null;
		MyLinkedList.Node temp = list.head;
		HashSet<Integer> set = new HashSet<Integer>();
		while(temp.next != null){
			set.add(temp.data);
			temp = temp.next;
		}
		return set;
	}
	
	public static HashSet<Integer> removeDupsWithNoExtraSpace(MyLinkedList list){
		if(list == null)
			return null;
		MyLinkedList.Node temp = list.head;
		HashSet<Integer> set = new HashSet<Integer>();
		while(temp.next != null){
			set.add(temp.data);
			temp = temp.next;
		}
		return set;
	}
	
	
	

}
