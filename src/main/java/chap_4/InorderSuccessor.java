package chap_4;

public class InorderSuccessor {

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null)
            return null;
        if(root.val <= p.val){
            //the root value is smaller than p, so we have to go right
            return inorderSuccessor(root.right, p);
        }
        else{
            //root value is bigger, so go left now
            TreeNode left = inorderSuccessor(root.left, p);
            if(left != null)
                return left;
            else
                return root;
        }
    }
}
