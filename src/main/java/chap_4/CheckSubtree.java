package chap_4;

public class CheckSubtree {

	//check if t2 is a subtree of t1
	//t1 >> t2
	

    public boolean isSubtree(TreeNode s, TreeNode t) {
    	//we should try all nodes
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        if(helper(s,t))
            return true;
        else
            return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean helper(TreeNode s, TreeNode t){
        //we will only strictly check the equality here
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        return s.val == t.val && helper(s.left, t.left) && helper(s.right, t.right);
    }
}