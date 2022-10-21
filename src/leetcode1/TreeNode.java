package leetcode1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//二叉树的中序遍历
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode() {
    }
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    //方法一：递归
    public List<Integer> inorderTraversal(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        inorder(root,result);
        return result;
    }
    public void inorder(TreeNode root,List<Integer> result){
        if(root==null){
            return;
        }
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }
    //方法二：用栈模拟
    public List<Integer> inorderTraversal1(TreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while(root!=null||!stk.isEmpty()){
            while(root!=null){
                //入栈
                stk.push(root);
                root=root.left;
            }
            //出栈
            root=stk.pop();
            res.add(root.val);  //记录出栈结点
            root=root.right;    //访问右孩子
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.right=treeNode2;
        treeNode2.left=treeNode3;
        List<Integer> list = treeNode.inorderTraversal(treeNode1);
        list.forEach(System.out::println);
    }
}
