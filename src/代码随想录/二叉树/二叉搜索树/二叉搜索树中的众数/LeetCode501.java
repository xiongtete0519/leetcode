package 代码随想录.二叉树.二叉搜索树.二叉搜索树中的众数;

import 代码随想录.二叉树.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode501 {

    public static int[] findMode(TreeNode root) {
        //用键值对统计值和出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return new int[]{};
        }
        //利用遍历记录频率，和遍历方式无关，这里使用层序遍历
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                //记录出现次数
                map.put(node.val, map.getOrDefault(node.val, 0) + 1);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        //根据出现次数排序
        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream()
                .sorted((x1, x2) -> x2.getValue() - x1.getValue())
                .collect(Collectors.toList());
        Integer value = collect.get(0).getValue();
        //取出出现次数相同的数，并用数组收集
        int[] array = collect.stream()
                .filter(x -> x.getValue().intValue() == value.intValue())
                .mapToInt(Map.Entry::getKey)
                .toArray();

        return array;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        node1.right = node2;
        node2.left = node3;

        TreeNode node = new TreeNode(0);

//        int[] arr = findMode(node1);
        int[] arr = findMode(node);
        System.out.println(Arrays.toString(arr));
    }
}
