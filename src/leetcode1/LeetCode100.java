package leetcode1;
//leetcode100:相同的树：判断两个二叉树是否相同
//如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
public class LeetCode100 {
    public boolean isSameTree(TreeNode p,TreeNode q){
        if(p==null&&q==null)
            return true;
        if((p==null&&q!=null)||(p!=null&&q==null))
            return false;
        if(p.val==q.val)
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        else
            return false;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left=t2;
        t1.right=t3;

        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(3);
        t4.left=t5;
        t4.right=t6;
        LeetCode100 code100 = new LeetCode100();
        System.out.println(code100.isSameTree(t1, t4));
    }
}
