package chap_4;

public class ValidateBST {


	
	public boolean validateBST(TreeNode root){
		if(root == null)
			return true;
		else
			return helper(root, null, null);
	}
	
	public boolean helper(TreeNode root, Integer min, Integer max){
		if(root == null)
			return true;
		if((min != null && root.val <= min) || (max != null && root.val >= max))
			return false;
		else
			return helper(root.left, min,  root.val) && helper(root.right, root.val, max);
	}
	
	
	
	
	//************************************
	
	//good attempt, but it was still wrong
	
	public boolean validateBST2(TreeNode root){
		if(root == null)
			return true;
		else
			return helper2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public boolean helper2(TreeNode root, int min, int max){
		if(root == null)
			return true;
		if(root.val > min && root.val < max){
			//go on
			return helper2(root.left, min, root.val) && helper(root.right, root.val, max);
		}
		else
			return false;
	}
}
