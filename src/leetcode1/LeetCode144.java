package leetcode1;

import java.util.ArrayList;
import java.util.List;

//二叉树的前序遍历
public class LeetCode144 {
    public List<Integer> preorderTraversal(TreeNode root){
        ArrayList<Integer> treeNodes = new ArrayList<>();
        preorder(root,treeNodes);
        return treeNodes;
    }
    public void preorder(TreeNode root,List<Integer> res ){
        if(root==null){
            return;
        }
        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);

    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right=t2;
        t2.left=t3;
        LeetCode144 code144 = new LeetCode144();
        List<Integer> list = code144.preorderTraversal(t1);
        System.out.println(list);
    }
}
