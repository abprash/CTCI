package chap_4;

import java.util.*;
public class ListOfDepths {
	
	
	public ArrayList<ArrayList<Integer>> bfs(TreeNode root){
		ArrayList<ArrayList<Integer>> ans  = new ArrayList<ArrayList<Integer>>();
		
		if(root == null)
			return ans;
		ans.add(new ArrayList<Integer>());
		helper(ans, root, 0 );
		
		System.out.println(ans);
		return ans;
	}
	
	public void helper(ArrayList<ArrayList<Integer>> ans, TreeNode root, int depth){
		if(root == null)
			return;
		//check if ans is of depth length
		if(ans.size() > depth){
			ans.get(depth).add(root.val);
		}else{
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(root.val);
			ans.add(temp);
		}
		//go further down
		helper(ans, root.left, depth+1);
		helper(ans, root.right, depth+1);
		
	}
	
	public static void main(String[] args){
		int[] nums = {0,1,2,3,4,5,6,7,8,9,10};
		TreeNode root = new MinimalTree().minimalTree(nums);
		new ListOfDepths().bfs(root);
	}
}
