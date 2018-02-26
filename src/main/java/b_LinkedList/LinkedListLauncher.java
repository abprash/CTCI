package b_LinkedList;

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
		//removeDupsWithNoExtraSpace(linkedList5);
		//linkedList5.traversal();
		System.out.println(findKthToLast(4,linkedList5));
		
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
		/*if(list == null)
			return null;*/
		MyLinkedList.Node p1 = list.head;
		/*if(p1.next == null)
			return list;*/
		MyLinkedList.Node p2 = p1.next;
		System.out.println(p1.data);
		System.out.println(p2.data);
		while(p1 != null){
			while(p2.next != null){
					if(p2.next.data == p1.data){
						p2.next = p2.next.next;
					}
					else
						p2 = p2.next;
			}
			p1 = p1.next;
		}
		System.out.println("--");
		list.traversal();
		return list;
	}
	
	//return Kth to last
	//not the intended solution
	/*public static int findKthToLast(int k, MyLinkedList list){
		//considerations
		//k should be less than the length of the list
		//find length of list
		//one pass
		//second pass
		//subtract l - k and go until there and return
		//find length
		int length = 0;
		if(list == null)
			return 0;
		MyLinkedList.Node curr = list.head;
		while(curr != null){
			length++;
			curr = curr.next;
		}
		if(k > length)
			return 0;
		if(k == length)
			return list.head.data;
		curr = list.head;
		for(int i=0; i<(length-k); i++){
			curr = curr.next;
		}
		//
		return curr.data;
	}*/
	public static int findKthToLast(int k, MyLinkedList list){
		if(list == null)
			return -9999;
		
	}
	
	

}
