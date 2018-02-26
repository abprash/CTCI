package b_LinkedList;



public class MyLinkedList {
	// insert
	// remove
	// insert at particular index
	Node head;

	class Node {
		int data;
		Node next;

		public Node(int d) {
			this.data = d;
		}
	}

	/*
	 * public Node add(int data) { if(this.head == null) { this.head.data =
	 * data; return this.head; } Node iterator = head; while(iterator != null) {
	 * iterator = iterator.next; } Node newNode = new Node(data); iterator.next
	 * = newNode; return head; }
	 */
	public void traversal() {
		Node pointer = this.head;
		while (pointer != null) {
			System.out.print(pointer.data + "-->");
			pointer = pointer.next;
		}
		System.out.print("null\n");
	}

	// three insert methods
	// insert in the beginning
	// insert in the end
	// insert after a particular position

	public void push(int newData) {
		// allocate new node and assign data
		Node newHead = new Node(newData);
		// new node next is head
		newHead.next = this.head;
		this.head = newHead;
	}

	public void insertAfter(int position, int newData) {
		Node pointer = this.head;
		// allocate new node and assign data
		Node newNode = new Node(newData);
		for (int i = 0; i < position; i++) {
			pointer = pointer.next;
		}
		Node nextNode = pointer.next;
		pointer.next = newNode;
		newNode.next = nextNode;
	}

	public void insertAfterNode(Node prevNode, int newData) {
		// check if prevNode is valid
		if (prevNode == null) {
			System.out.println("Prev node cannot be null");
			return;
		}
		// allocate new node and assign data
		Node newNode = new Node(newData);
		newNode.next = prevNode.next;
		prevNode.next = newNode;
	}

	public void append(int newData) {
		if (this.head == null) {
			this.head = new Node(newData);
			return;
		}
		Node pointer = this.head;
		while (pointer.next != null) {
			pointer = pointer.next;
		}
		Node newNode = new Node(newData);
		pointer.next = newNode;
	}

	public void deleteNode(int key) {
		if (this.head.data == key) {
			this.head = this.head.next;
			return;
		}
		// we maintain two pointers prev and pointer
		Node pointer = this.head, prev = null;
		while (pointer != null && pointer.data != key) {
			// keep going
			prev = pointer;
			pointer = pointer.next;
		}
		// if pointer is null we have reached the end of the list and no data is
		// found
		if (pointer == null)
			return;
		// we have found the data
		// unlink from the chain
		prev.next = pointer.next;
	}

	public void deletePosition(int position) {
		// if position == 0, delete head
		if (position < 0)
			return;
		if (position == 0) {
			this.head = this.head.next;
			return;
		}
		Node curr = this.head, prev = null;
		while (curr != null && position > 0) {
			prev = curr;
			curr = curr.next;
			position--;
		}

		if (curr == null)
			return;
		prev.next = curr.next;
	}

	public int findLengthIterative() {
		// get the length of the linked list
		int length = 0;
		if (this.head == null)
			return length;
		Node curr = this.head;
		while (curr != null) {
			length++;
			curr = curr.next;
		}
		return length;
	}

	public int findLengthRecursive(Node headNow) {
		int length = 0;
		if (headNow == null)
			return 0;
		return 1 + findLengthRecursive(headNow.next);
	}

	/*
	 * public void swapNodes(int a, int b) { if (a == b) return; // check if
	 * both the elements are there if (this.head == null) return; Node pointer1
	 * = this.head, pointer2 = this.head.next; Node prev1 = null, prev2 = null;
	 * // assuming none are heads and tails while ((pointer1 != null &&
	 * pointer1.data != a) || (pointer2 != null && pointer2.data != b)) { if
	 * (pointer1 != null && pointer1.data != a ) { prev1 = pointer1; pointer1 =
	 * pointer1.next; } if (pointer2 != null && pointer2.data != b) { prev2 =
	 * pointer2; pointer2 = pointer2.next; } } if (pointer1 == null || pointer2
	 * == null) return; if (prev1 == null || prev2 == null) {
	 * System.out.println("head"); // one of them is a head // so there is no
	 * prev pointer for one if (prev1 == null && prev2 != null) { Node temp =
	 * pointer1.next; prev2.next = pointer1; pointer1.next = pointer2.next;
	 * pointer2.next = temp; } } else { Node temp = pointer1.next; prev2.next =
	 * pointer1; pointer1.next = pointer2.next; prev1.next = pointer2;
	 * pointer2.next = temp; } }
	 */

	public void swapNodes(int a, int b) {
		if (a == b)
			return;
		Node currX = this.head;
		Node prevX = null;
		while (currX != null && currX.data != a) {
			prevX = currX;
			currX = currX.next;
		}
		Node currY = this.head;
		Node prevY = null;
		while (currY != null && currY.data != b) {
			prevY = currY;
			currY = currY.next;
		}
		if (currX == null || currY == null)
			return;
		if (prevX != null)
			prevX.next = currY;
		else
			this.head = currY;

		if (prevY != null)
			prevY.next = currX;
		else
			this.head = currX;

		// now just change the next pointers
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;

	}

	public Node mergeWith(MyLinkedList l2) {
		Node head = new Node(0);
		Node p1 = this.head;
		Node p2 = l2.head;
		Node head0 = head;
		while (this != null || l2 != null) {
			if (p1 != null && p2 != null) {
				if (p1.data < p2.data) {
					head.next = p1;
					p1 = p1.next;
				} else {
					head.next = p2;
					p2 = p2.next;
				}
			} else if (p1 == null && p2 != null) {
				// append p2 to p1 and break
				head.next = p2;
				break;
			} else if (p2 == null && p1 != null) {
				// append p1 to head and break
				head.next = p1;
				break;
			}

			head = head.next;
		}
		return head0.next;
	}

	public boolean searchIterative(int element) {
		Node p1 = this.head;
		while (p1 != null) {
			if (element == p1.data)
				return true;
			p1 = p1.next;
		}
		return false;
	}

	public static boolean searchRecursive(Node head, int element) {
		if (head == null)
			return false;
		if (head.data == element)
			return true;
		else
			return searchRecursive(head.next, element);
		// return false;
	}

	public int getNthElement(int index) {
		Node p1 = this.head;
		int counter = 0;
		while (p1 != null) {
			if (counter == index - 1)
				return p1.data;
			counter++;
			p1 = p1.next;
		}
		// non existent element index
		// return 0
		return 0;
	}

	public int getMiddleElement() {
		Node fast = this.head;
		Node slow = this.head;
		while (fast.next != null && fast.next.next != null) {
			// if(fast.next!= null)
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow.data;
	}

	public Node getMiddleNode() {
		Node fast = this.head;
		Node slow = this.head;
		while (fast.next != null && fast.next.next != null) {
			// if(fast.next!= null)
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	// Method to get the nth node from the end of the list
	public int getNthFromEnd(int n) {
		Node p1 = this.head;
		Node p2 = this.head;
		int counter = 0;
		while (p1 != null && p2 != null) {
			if (counter <= n - 1) {
				// move the p1 alone
				p1 = p1.next;
			} else {
				p1 = p1.next;
				p2 = p2.next;
			}
			counter++;

		}
		return p2.data;
	}

	/*
	 * to print the elements of list in reverse
	 */
	public void printReverse(Node head) {
		//
		if (head != null) {
			printReverse(head.next);
			System.out.println(head.data);
		}

	}

	public Node reverseListIterative() {
		Node prev = null;
		Node next1 = null;
		Node curr = this.head;
		while (curr != null) {
			// we basically make the curr's pointer to point to the prev node
			next1 = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next1;
		}
		return prev;
	}

	public Node reverseRecursive(Node curr, Node prev) {
		if (curr == null) {
			return prev;
		} else {
			// if they both are not null
			// if curr is not null then prev is also not null
			// make a next node
			Node next = curr.next;
			// make the curr point to prev
			curr.next = prev;
			// now do the same to next and curr again
			return reverseRecursive(next, curr);
		}
	}

	/*
	 * public boolean checkIfPalindrome() { //to check if the linked list is a
	 * palindrome if(this.head == null) return false; else { Node pointer1 =
	 * this.head; //go till the middle of the list Node middle =
	 * this.getMiddleNode(); //can be both odd and even length of palindrome
	 * Node newmiddle = reverseRecursive(middle, null); while(newmiddle != null
	 * && pointer1!= null) { if(newmiddle.data != pointer1.data) return false;
	 * newmiddle = newmiddle.next; pointer1 = pointer1.next; } return true; } }
	 */

	public int findIntersection(MyLinkedList l2) {
		// find the length of both the lists
		int count1 = 0, count2 = 0;
		Node p1 = this.head;
		Node p2 = l2.head;
		Node tp1 = this.head;
		Node tp2 = l2.head;
		while (p1 != null && p2 != null) {
			count1++;
			count2++;
			p1 = p1.next;
			p2 = p2.next;
		}
		// get diff
		int diff = Math.abs(count1 - count2);
		// now traverse the exact amount of nodes from the smaller list and get
		// the intersection
		if (count1 < count2) {
			// list1 is smaller
			while (count1 >= diff) {
				count1--;
				tp1 = tp1.next;
			}
			return tp1.data;
		} else {
			while (count2 >= diff) {
				count2--;
				tp2 = tp2.next;
			}
			return tp2.data;
		}
	}

	/////////////////////////////////////////
	public boolean checkIfPalindrome() {
		// runs in O(n) time and with O(1) space
		// much better than using a stack
		// we use fast and slow pointer
		// the fast and slow pointer help in splitting the list into 2
		// now we reverse the second half and compare with the first half

		// find the middle of the list
		// fast and slow pointer
		Node fast_ptr = this.head;
		Node slow_ptr = this.head;
		Node prev_slow_ptr = this.head;
		Node midNode = null;
		while (fast_ptr != null && fast_ptr.next != null) {
			// just make them skip 2s and 1s
			fast_ptr = fast_ptr.next.next;
			prev_slow_ptr = slow_ptr;
			slow_ptr = slow_ptr.next;

		}
		// check if fastptr is null
		// if null, then there are even number of elements
		// else there are an odd number and we need an additional mid node
		if (fast_ptr != null) {
			// there are odd number of nodes
			midNode = slow_ptr;
			slow_ptr = slow_ptr.next;
		}

		Node secondHalf = slow_ptr;
		prev_slow_ptr.next = null;

		// now secondhalf and head node are the start of the 2 equal lists
		// halves
		// now just reverse the second half
		Node temp = reverse(secondHalf);
		// now compare both the lists
		boolean res = compareLists(this.head, temp);
		secondHalf = reverse(temp);
		// now if there is a mid node attach it before the second half
		if (midNode != null) {
			prev_slow_ptr.next = midNode;
			midNode.next = secondHalf;
		} else
			prev_slow_ptr.next = secondHalf;
		return res;
	}

	public boolean compareLists(Node head1, Node head2) {
		Node temp1 = head1;
		Node temp2 = head2;

		while (temp1 != null && temp2 != null) {
			if (temp1.data == temp2.data) {
				temp1 = temp1.next;
				temp2 = temp2.next;
			} else
				return false;
		}

		/* Both are empty reurn 1 */
		if (temp1 == null && temp2 == null)
			return true;

		/*
		 * Will reach here when one is NULL and other is not
		 */
		return false;
	}

	public Node reverse(Node secondHalf) {
		// we are going to reverse the list from the given node
		Node curr = secondHalf;
		Node prev = null;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	//////////////////////////

	public int getIntersectingNode(MyLinkedList l2) {
		// get the lengths of both the lists
		int length1 = this.findLengthIterative();
		int length2 = l2.findLengthIterative();
		int diff = Math.abs(length2 - length1);
		// System.out.println(x);
		int biggerLength = 0;
		MyLinkedList biggerList = null;
		if (length1 > length2)
			biggerLength = length1;
		else
			biggerLength = length2;

		Node pointer2 = null;
		if (biggerLength == length1) {
			biggerList = this;
			pointer2 = l2.head;
			// go down d places in this list and then start traversing both
			// lists simultaneously
			// to get where they intersect
		} else {
			biggerList = l2;
			pointer2 = this.head;
		}
		int count = 0;
		Node pointer1 = biggerList.head;
		while (count < diff) {
			pointer1 = pointer1.next;
			count++;
		}
		// now simultaneously traverse until both lists until the common object
		// is found
		while (pointer1 != null && pointer2 != null) {
			if (pointer1.data == pointer2.data)
				return diff;
			pointer1 = pointer1.next;
			pointer2 = pointer2.next;
		}
		return diff;
	}

	public Node eliminateDuplicatesInSortedList() {
		Node prev = null;
		Node curr = this.head;
		Node next = null;
		if (curr.next != null)
			next = curr.next;
		else
			return curr;
		// check if the current element and next element are equal
		while (next != null) {
			if (curr.data == next.data) {
				// ignore the next
				// point the curr to next.next
				curr.next = next.next;
				next = next.next;
			} else {
				curr = curr.next;
				next = next.next;
			}
		}
		return this.head;
	}

	public Node pairwiseSwapIterative() {
		if (this.head == null || this.head.next == null)
			return this.head;
		Node prev = this.head;
		Node curr = this.head.next;
		Node newHead = curr;
		while (true) {

			Node next = curr.next;
			if (next == null || next.next == null) {
				prev.next = next;
				break;
			}
			curr.next = prev;
			prev.next = next.next;
			prev = next;
			curr = prev.next;

		}
		// prev.next = curr;

		return newHead;
	}

	public void moveLastElementToFirst() {
		// move last element to first
		// get the last element
		if (this.head == null || this.head.next == null)
			return;
		Node prev = this.head;
		Node curr = this.head;
		while (curr.next != null) {
			prev = curr;
			curr = curr.next;
		}
		System.out.println("prev--" + prev.data);
		System.out.println("curr--" + curr.data);
		prev.next = null;
		curr.next = this.head;
		this.head = curr;
	}

	public MyLinkedList sortedIntersect(MyLinkedList l2) {

		Node p1 = this.head;
		Node p2 = l2.head;
		MyLinkedList result = new MyLinkedList();
		// result.head = new Node(0);
		while (p1 != null && p2 != null) {
			System.out.println("p1 = " + p1.data);
			System.out.println("p2 = " + p2.data);
			if (p1.data == p2.data) {
				// System.out.println(p1.data);
				// System.out.println(p2.data);
				result.append(p1.data);
				p1 = p1.next;
				p2 = p2.next;
			} else if (p1.data < p2.data) {
				// move p1 alone
				p1 = p1.next;
			} else if (p1.data > p2.data) {
				p2 = p2.next;
			}
		}
		return result;
	}

	public void deleteAlternateIterative() {
		if (this.head == null || this.head.next == null)
			return;
		// make first node point to thir node and so on
		Node prev = this.head;
		Node curr = prev.next;
		while (prev != null && prev.next != null) {
			Node next = prev.next.next;

			prev.next = next;
			prev = prev.next;
		}
	}

	public Node deleteAlternateRecursive(Node head) {
		if (head == null || head.next == null)
			return head;
		head.next = head.next.next;
		return deleteAlternateRecursive(head.next);
	}

	public void deleteAlternateIntoTwoList() {
		if (this.head == null || this.head.next == null)
			return;
		// make first node point to thir node and so on
		Node prev = this.head;
		Node curr = prev.next;
		MyLinkedList l2 = new MyLinkedList();
		while (prev != null && prev.next != null) {
			Node next = prev.next.next;
			l2.append(prev.next.data);
			prev.next = next;
			prev = prev.next;
		}
		System.out.println("new list");
		l2.traversal();
	}

	public Node reverseListOfGivenSize(Node head1, int size) {
		// reverse first size elements
		Node curr = head1;
		Node prev = null;
		Node next = null;
		int counter = 0;
		while (counter < size && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			counter++;
		}
		// now make the head node of this iteration to point to the rev of the
		// next set of size nodes
		if (next != null)
			head1.next = reverseListOfGivenSize(next, size);
		// return the prev node as final head is changed
		return prev;
	}

	public Node kAlternateReverse(Node head, int k) {
		// reverse the first k nodes
		Node curr = head;
		Node prev = null;
		Node next = null;
		int counter = 0;
		while (counter < k && curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			counter++;
		}
		counter = 0;
		// System.out.println("next.data-"+next.data);

		// so now head.next points to next so that this link is still available
		head.next = next;
		// now we have to skip the next k+1 to k+k nodes
		while (counter < k - 1 && next != null) {
			System.out.println(next.data);
			next = next.next;
			counter++;
		}
		// make curr node as the next node so that curr.next points to next
		// recursion result
		curr = next;
		if (curr != null) {
			curr.next = kAlternateReverse(curr.next, k);
		}
		return prev;

	}
	// segregate odd and even nos in a list

	// delete nodes which have a greater value on the RHS
	public void deleteNodesHavingBiggerRightValue() {
		// reverse the list
		Node prev = null;
		Node curr = this.head;
		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		this.head = prev;

		// now delete the nodes which have a smaller rhs value
		// prev = null;
		curr = this.head;
		Node next = curr.next;
		while (next != null) {
			System.out.println("->" + curr.data);
			if (curr.data > next.data) {
				// delete next node
				curr.next = next.next;
				if (curr != null)
					curr = next.next;
				// checking if its the last node
				if (curr == null)
					break;
				else
					next = curr.next;
			} else {
				curr = curr.next;
				next = next.next;
			}
		}
		// reverse it again
		prev = null;
		curr = this.head;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		this.head = prev;
	}

	public void removeDuplicates() {
		if (this.head == null)
			return;
		if (this.head.next == null)
			return;
		Node pointer = this.head;
		Node prev = this.head;
		Node curr = this.head.next;
		while (pointer != null) {
			prev = pointer;
			curr = prev.next;
			while (curr != null) {
				if (pointer.data == curr.data) {
					if (curr.next != null) {
						Node next = curr.next;
						prev.next = next;
						curr = next;
					} else {
						prev.next = null;
						break;
					}
				} else {
					// increment both the pointers as usual
					prev = prev.next;
					curr = curr.next;
				}
			}
			pointer = pointer.next;
		}
	}

	//find the kth to last element in a linked list
	public void findKthLastElement(int k){
		if(k<0){
			System.out.println("Invalid arg");
			return;
		}
		//returns the element num.
		//reverse the list
		Node prev = this.head;
		Node curr = prev.next;
		Node pointer = this.head;
		while(curr != null){
			Node next = curr.next;
			if(next != null){
			curr.next = prev;
			prev = curr;
			curr = next;
			}
			else 
				break;
		}
		pointer.next = null;
		this.head = prev;
		System.out.println("entered kth last element is : "+k);
		int i = 1;
		pointer = this.head;
		while(i < k && pointer != null){
			pointer = pointer.next;
			i++;
		}
		if(pointer==null && i!=k-1){
			//no such elt exists
			System.out.println("none exists");
		}
		else
		System.out.println(pointer.data);
		//should reverse the list back
	}
	
	//delete the middle node in the list
	public void deleteMiddleNode(){
		//use slow and fast pointer to do this effectively
		Node prevSlow = null, afterSlow = null;
		Node fast = this.head;
		Node slow = this.head;
		while(fast != null && fast.next != null){
			prevSlow = slow;
			slow = slow.next;
			afterSlow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("middle node is "+slow.data);
		prevSlow.next = afterSlow;
	}
	
	public MyLinkedList sumTwolists(MyLinkedList l2){
		//clarify the question properly
		//cases to consider
		//both the lsits null - return null
		//either list null - return the other one blindly
		//non equal lenghts of nos
		if(this == null && l2 == null)
			return null;
		if(this == null || l2 == null){
			if(this == null)
				return l2;
			if(l2 == null)
				return this;
		}
		Node p1 = this.head;
		Node p2 = l2.head;
		int carry = 0;
		int sum = 0;
		MyLinkedList l3 = new MyLinkedList();
		while(p1 != null && p2 != null){
			//System.out.println("sum "+sum);
			//System.out.println("Carry"+carry);
			if(carry>0){
				sum= sum + 1;
				carry  = 0;
			}
			 int d1 = p1.data;
			 int d2 = p2.data;
			 sum += d1+d2;
			 if(sum >= 10){
				 carry = 1;
				 sum=sum-10;
			 }
			 //System.out.println("SUM "+sum);
			 l3.append(sum);
			 sum = 0;
			 p1 = p1.next;
			 p2 = p2.next;
		}
		//handling for unequal length lists
		if(p1 != null || p2 != null){
			//one may be non null
			while(p1 != null){
				int d1 = p1.data;
				if(d1+carry >= 10){
					l3.append(d1+carry-10);
					carry = 1;
				}
				else{
					l3.append(d1+carry);
					carry = 0;
				}
				p1 = p1.next;
			}
			while(p2 != null){
				int d2 = p2.data;
				if(d2+carry >= 10){
					l3.append(d2+carry-10);
					carry = 1;
				}
				else{
					l3.append(d2+carry);
					carry  = 0;
				}
				p2 = p2.next;
			}
		}
		if(carry > 0)
			l3.append(carry);
		return l3;
	}
}
