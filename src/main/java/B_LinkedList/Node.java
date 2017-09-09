package B_LinkedList;

public class Node{
		int data;
		Node left, right;
		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;	
	}

}

class MyBinaryTree
{
	Node root;
	public MyBinaryTree(int d)
	{
		if(root == null){
			this.root = new Node(d);
		}
		else
			this.root.data = d;
	}
	public MyBinaryTree(){
		this.root = new Node(0);
	}
}


