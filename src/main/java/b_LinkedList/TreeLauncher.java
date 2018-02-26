package b_LinkedList;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TreeLauncher {
	public static void main(String[] args) {
		// declare a tree with 4 nodes
		StringBuilder sb = new StringBuilder();
		String x = new String();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		Comparator<Integer> c2;
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		inOrderTraversal(root);
		System.out.println();
		preOrderTraversal(root);
		System.out.println();
		postOrderTraversal(root);
		System.out.println();
		BFS(root);
	}

	public static void traversal(Node n) {
		if (n == null)
			return;
		else {
			System.out.println(n.data);
		}
		if (n.left != null)
			System.out.println("left -" + n.left.data);
		if (n.right != null)
			System.out.println("right -" + n.right.data);
		traversal(n.left);
		traversal(n.right);
	}

	public static void inOrderTraversal(Node n) {
		// left
		// root
		// right
		if (n == null)
			return;
		if (n.left != null) {
			// System.out.print(n.left.data+" ");
			inOrderTraversal(n.left);
		}
		System.out.print(" " + n.data);
		if (n.right != null) {
			// System.out.print(" "+n.right.data);
			inOrderTraversal(n.right);
		}
	}

	public static void preOrderTraversal(Node curr) {
		if (curr == null)
			return;
		System.out.print(" " + curr.data);
		if (curr.left != null)
			preOrderTraversal(curr.left);
		if (curr.right != null)
			preOrderTraversal(curr.right);
	}

	public static void postOrderTraversal(Node n) {
		if (n == null)
			return;
		if (n.left != null)
			postOrderTraversal(n.left);
		if (n.right != null)
			postOrderTraversal(n.right);
		System.out.print(" " + n.data);
	}

	public static void DFS(Node n) {
		if (n == null)
			return;
		System.out.println(n.data);
		if (n.left != null)
			DFS(n.left);
		if (n.right != null)
			DFS(n.right);
	}

	static Queue<Node> queue = new LinkedList<Node>();

	public static void BFS(Node n) {
		if (n == null)
			return;
		System.out.println(n.data);
			if (n.left != null)
				queue.add(n.left);
			if (n.right != null)
				queue.add(n.right);
			// take the first node from the queue
		if(!queue.isEmpty()){
			Node temp = queue.remove();
			BFS(temp);
			//add its children
		}
		
	}
}
