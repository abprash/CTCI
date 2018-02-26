package b_LinkedList;

public class LinkedListlauncher2 {
	
	//from cracking the coding interview
	public static void main(String[] args){
		MyLinkedList l1 = new MyLinkedList();
		l1.append(2);
		l1.append(9);
		l1.append(3);
		l1.append(88);
		l1.append(1);
		l1.append(35);
		l1.append(2);
		l1.append(808);
		l1.traversal();
		//l1.removeDuplicates();
		//l1.findKthLastElement(4);
		l1.traversal();
		l1.deleteMiddleNode();
		l1.traversal();
		l1 = new MyLinkedList();
		MyLinkedList l2 = new MyLinkedList();
		l1.append(7);
		l1.append(1);
		l1.append(6);
		l2.append(5);
		l2.append(9);
		l2.append(9);
		l2.append(9);
		l2.append(2);
		l1.traversal();
		l2.traversal();
		MyLinkedList l3 = l1.sumTwolists(l2);
		l3.traversal();
	}
	//eliminate duplicates
	
}
