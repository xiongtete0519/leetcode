package 十届Java研究生组.最短路;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Bellman-Ford算法
 * 假设起点为s，dis[v]表示s到v的最短距离
 * w[j]是边j的长度,j连接u和v
 */
public class Main {
  private static List<int[]> edges = new ArrayList<>();

  private static void add(char u, char v, int w) {
      edges.add(new int[]{u, v, w});
      edges.add(new int[]{v, u, w});
  }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        add('A', 'C', 1);
        add('A', 'D', 1);
        add('A', 'E', 1);
        add('D', 'E', 1);
        add('E', 'I', 1);
        add('D', 'H', 1);
        add('H', 'I', 1);
        add('B', 'G', 1);
        add('F', 'G', 1);
        add('F', 'J', 1);
        add('K', 'N', 1);
        add('L', 'M', 1);
        add('N', 'P', 1);
        add('P', 'O', 1);
        add('O', 'Q', 1);
        add('Q', 'M', 1);
        add('L', 'R', 1);
        add('S', 'R', 1);
        add('M', 'S', 1);

        add('A', 'B', 2);
        add('B', 'J', 2);
        add('D', 'I', 2);
        add('D', 'G', 2);
        add('G', 'K', 2);
        add('K', 'P', 2);
        add('J', 'S', 2);
        add('M', 'N', 2);
        add('H', 'L', 2);

        add('E', 'I', 3);
        add('I', 'M', 3);
        add('G', 'I', 3);
        add('C', 'D', 3);
        add('C', 'G', 3);
        add('C', 'F', 3);
        add('O', 'R', 3);
        add('K', 'L', 3);

        int n = edges.size();
        int[] dist = new int[128];

        //初始化
        Arrays.fill(dist, Integer.MAX_VALUE >> 1);
        dist['A'] = 0;
        for (int i = 0; i <n-1; i++) {
          for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[v] = Math.min(dist[v], dist[u] + w);
          }
        }
        System.out.println(dist['S']);

        scan.close();
    }
}