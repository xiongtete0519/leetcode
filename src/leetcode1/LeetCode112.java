package leetcode1;

import java.util.LinkedList;

//路径总和给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。
// 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。
// 如果存在，返回 true ；否则，返回 false 。
public class LeetCode112 {
    //方法一：递归
    public boolean hasPathSum(TreeNode root,int targetSum){
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null){
            return targetSum==root.val;
        }
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
    //方法二：广度优先搜索
    //使用广度优先遍历搜索的方式，记录从根节点到当前节点的路径和
    public boolean hasPathSum1(TreeNode root,int sum){
        if(root==null){
            return false;
        }
        //使用两个队列分别存储将要遍历的节点，以及根节点到这些节点得路径和
        LinkedList<TreeNode> queNode = new LinkedList<>();
        LinkedList<Integer> queVal = new LinkedList<>();
        //根节点和值入队
        queNode.add(root);
        queVal.add(root.val);
        while(!queNode.isEmpty()){
            //节点和值出队
            TreeNode now = queNode.remove();
            int temp=queVal.remove();
            if(now.left==null&&now.right==null){    //判断叶子节点的路径和
                if(temp==sum){
                    return true;
                }
                continue;
            }
            if(now.left!=null){//左节点入队
                queNode.add(now.left);
                queVal.add(now.left.val+temp);
            }
            if(now.right!=null){//右节点入队
                queNode.add(now.right);
                queVal.add(now.right.val+temp);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.left=t2;
        t1.right=t3;
        LeetCode112 code112 = new LeetCode112();
        System.out.println(code112.hasPathSum(t1, 3));
        System.out.println(code112.hasPathSum(t1, 5));
        System.out.println(code112.hasPathSum1(t1, 3));
        System.out.println(code112.hasPathSum1(t1, 4));
    }
}
