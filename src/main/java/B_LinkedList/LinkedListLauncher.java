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
		//linkedList5.traversal();
		//System.out.println(removeDups(linkedList5));
		removeDupsWithNoExtraSpace(linkedList5);
	}
	//CTCI Linked list problems
	
	public static HashSet<Integer> removeDups(MyLinkedList list){
		if(list == null)
			return null;
		MyLinkedList.Node temp = list.head;
		HashSet<Integer> set = new HashSet<Integer>();
		while(temp != null){
			set.add(temp.data);
			temp = temp.next;
		}
		return set;
	}
	
	public static MyLinkedList removeDupsWithNoExtraSpace(MyLinkedList list){
		if(list == null)
			return null;
		MyLinkedList.Node p1 = list.head;
		if(p1.next == null)
			return list;
		MyLinkedList.Node p2 = p1.next;
		if(p2.next == null && p1.data == p2.data)
			return list;
		MyLinkedList.Node p3 = p2.next;
		while(p1 != null){
			while(p3 != null){
				if(p1.data != p3.data){
					p2 = p2.next;
					p3 = p3.next;
				}
				else{ 
					if(p3.next != null)
						p2.next = p3.next;
				else
					p2.next = null;
				p3 = p3.next;
				}
			}
			p1 = p1.next;
		}
		list.traversal();
		return list;
	}
	
	
	

}
