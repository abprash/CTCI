package chap_4;

public class CheckBalanced {

	
	
	public boolean isBalanced(TreeNode root) {
        //basically the height of every node does not differ by more than 1
        if(root == null)
            return true;
        int l = helper(root.left);
        int r = helper(root.right);
        return Math.abs(l-r) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(helper(root.left), helper(root.right)) + 1;
    }
    
	//****************************************************
	//check if a given tree is balanced
    public boolean isBalanced2(TreeNode root) {
        if(root == null)
			return true;
		int left = helper2(root.left);
		int right = helper2(root.right);
		if(Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right)) 
			return true;
		else
			return false;
	}
	
	public int helper2(TreeNode root){
		if(root == null)
			return 0;
		int left = helper2(root.left);
		int right = helper2(root.right);
		return 1 + Math.max(left, right);
	}
}
