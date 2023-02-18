package leetcode1;

import java.util.ArrayList;
import java.util.List;

public class LeetCode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        postorder(root,res);
        return res;
    }
    public void postorder(TreeNode root,List<Integer> res){
        if(root==null){
            return;
        }
        postorder(root.left,res);
        postorder(root.right,res);
        res.add(root.val);
    }

    public static void main(String[] args) {
        LeetCode145 leetCode145 = new LeetCode145();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right=node2;
        node2.left=node3;
        List<Integer> list = leetCode145.postorderTraversal(node1);
        list.forEach(System.out::println);
    }
}
