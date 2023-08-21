package 代码随想录.回溯.组合问题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合，可以将回溯法想象成一棵树
 * n相当于树的宽度，k相当于树的深度
 * 纵向递归+横向遍历
 */
public class LeetCode77 {
    List<List<Integer>> result = new ArrayList<>();   //存储组合结果
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) { //已经找到了一个合法的组合
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backtracking(n, k, i + 1);  //i+1确保不重复使用已经处理过的数字
            //递归结束的回溯，将刚刚加入的数i从组合路径path中移除，以便尝试其他组合
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        LeetCode77 code = new LeetCode77();
        int n = 4;
        int k = 2;
        System.out.println(code.combine(n, k));
    }
}
