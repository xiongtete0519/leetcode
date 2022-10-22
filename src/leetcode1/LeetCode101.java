package leetcode1;
//对称二叉树
public class LeetCode101 {
    public  boolean isSymmetric(TreeNode root){
        return check(root,root);
    }

    /**
     *通过同步移动两个指针的方法来遍历树，p和q一开始都指向这棵树的根，随后
     * p右移时，q左移，p左移时,q右移。
     * 每次检查当前p和q节点的值是否相等，如果相等再判断左右子树是否对称。
     */
    public boolean check(TreeNode p,TreeNode q){
        if(p==null&&q==null){
            return true;
        }
        if(p==null||q==null){
            return false;
        }
        return p.val==q.val&&check(p.left,q.right)&&check(p.right,q.left);
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(2);
        TreeNode t2 = new TreeNode(2);
        TreeNode t1 = new TreeNode(1,t2,t3);
        LeetCode101 code101 = new LeetCode101();
        System.out.println(code101.isSymmetric(t1));
    }
}
