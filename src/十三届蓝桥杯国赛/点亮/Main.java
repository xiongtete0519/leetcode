package 十三届蓝桥杯国赛.点亮;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;//棋盘大小
    static List<int[]> blacks;
    static int[][] fx = {
            {-1, 0},    //上
            {1, 0},     //下
            {0, -1},    //左
            {0, 1}      //右
    };
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        char[][] e = new char[N][N];
        in.nextLine();
        for (int i = 0; i < N; i++) {
            e[i] = in.nextLine().toCharArray();
        }
        solve1(e);
    }

    public static boolean check(char[][] e) {
        boolean[][] vis = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (e[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        for (int l = 1; ; l++) {
                            int dx = i + fx[k][0] * l;
                            int dy = j + fx[k][1] * l;
                            if (dx < 0 || dy < 0 || dx >= N || dy >= N) break;
                            if (e[dx][dy] == 'O') return false;
                            if (e[dx][dy] != '.') break;
                            vis[dx][dy] = true;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (vis[i][j] == false && e[i][j] == '.') return false;
            }
        }
        return true;
    }

    public static void solve1(char[][] e) {
        N = e.length;
        List<int[]> whites = new ArrayList<>(); //白格坐标
        blacks = new ArrayList<>(); //黑格坐标
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (e[i][j] == '.') {
                    whites.add(new int[]{i, j});
                } else {
                    if (Character.isDigit(e[i][j])){
                        //带数字的黑格坐标
                        blacks.add(new int[]{i, j, e[i][j] - '0'});
                    } else{
                        //没有数字标识的黑色格子坐标
                        blacks.add(new int[]{i, j, -1});
                    }
                }
            }
        }
        int szWhite = whites.size();    //白色格子的数量
        int all = (1 << szWhite) - 1;   //(2^szWhite)-1
        for (int state = 0; state <= all; ++state) {
            int sta = state;

            for (int i = 0; i < szWhite; i++, sta >>= 1) {
                if ((sta & 1) == 1) {
                    int[] p = whites.get(i);
                    e[p[0]][p[1]] = 'O';
                }
            }
            if (judge(e)) {

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        System.out.print(e[i][j]);
                    }
                    System.out.println();
                }
//                System.out.println(Arrays.deepToString(e));
                return;
            }
            sta = state;
            for (int i = 0; i < szWhite; i++, sta >>= 1) {
                if ((sta & 1) == 1) {
                    int[] p = whites.get(i);
                    e[p[0]][p[1]] = '.';
                }
            }
        }
    }
    public static boolean judge(char[][] e) {
        //检查所有黑色格子是否满足
        for (int[] blk : blacks) {
            int tot = 0;
            for (int i = 0; i < 4; i++) {
                int dx = blk[0] + fx[i][0];
                int dy = blk[1] + fx[i][1];
                if (dx < 0 || dy < 0 || dx >= N || dy >= N) continue;
                if (e[dx][dy] == 'O') tot++;
            }
            if (blk[2] != -1 && tot != blk[2]) return false;
        }
        //check检查是否照亮全部
        return check(e);
    }

}