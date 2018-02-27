package chap_4;

public class CommonAncestor {
	//to find the first common ancestor
	//lowest common ancestor between two nodes
	
	public TreeNode getLCA(TreeNode root, TreeNode p, TreeNode q){
		if(root == null || p == root || q == root)
			return root;
		TreeNode left = getLCA(root.left, p, q);
		TreeNode right = getLCA(root.right, p, q);
		
		if(left != null && right != null)
			return root;
		
		else{
			return left != null ? left : right;
		}
	}
}
