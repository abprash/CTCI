package chap_4;

public class MinimalTree {
	//given an increasing unique sequence,
	//convert it into a minimal BST
	//height should be as minimal as possible
	
	public TreeNode minimalTree(int[] nums){
		if(nums == null || nums.length == 0)
			return null;
		return helper(nums, 0, nums.length-1);
	}
	
	public TreeNode helper(int[] nums, int start, int end){
		if(nums == null || nums.length == 0)
			return null;
		TreeNode root = null;
		if(start < end){
			int mid = (start + end)/2;
			root = new TreeNode(nums[mid]);
			if(start == mid-1)
				root.left = new TreeNode(nums[start]);
			else
				root.left = helper(nums, start, mid-1);
			//similarly for the right child
			if(mid+1 == end)
				root.right = new TreeNode(nums[end]);
			else
				root.right = helper(nums, mid+1, end);
		}
		return root;
	}
	
	
	public static void dfs(TreeNode root){
		if(root == null)
			return;
		//inorder should be the exact same array 
		dfs(root.left);
		System.out.println(root.val);
		dfs(root.right);
	}
	public static void main(String[] args){
		int[] nums = {0,1,2,3,4,5,6,7,8,9,10};
		TreeNode root = new MinimalTree().minimalTree(nums);
		dfs(root);
		
	}
}

class TreeNode{
	int val;
	TreeNode left, right;
	
	public TreeNode(int x){
		this.val = x;
	}
}
