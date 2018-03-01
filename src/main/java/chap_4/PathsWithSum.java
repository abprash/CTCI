package chap_4;

public class PathsWithSum {

	int count = 0;
	//parent to child path sums, should sum to sum,
	//no v shaped paths included
	//not necessarily from root to leaf. just some route from parent to child
	public int pathsWithSums(TreeNode root, int sum){
		if(root == null)
			return 0;
		helper(root, 0, sum);
		pathsWithSums(root.left, sum);
		pathsWithSums(root.right, sum);
		return count;
	}

	public void helper(TreeNode root, int sumSoFar, int sum){
		if(root == null)
			return;
		//add the curr node value
		sumSoFar += root.val;
		if(sumSoFar == sum)
			count++;
		//go further down
		helper(root.left, sumSoFar,sum);
		helper(root.right, sumSoFar,sum);
			
	}
}
