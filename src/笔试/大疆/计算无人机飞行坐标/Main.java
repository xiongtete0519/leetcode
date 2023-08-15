package 笔试.大疆.计算无人机飞行坐标;

import java.util.Scanner;

//RUDDLLURRR
public class Main {
    public int[] calculateFinalPositi(String instructions) {
        int x = 0;
        int y = 0;
        char[] chars = instructions.toCharArray();
        for (char c : chars) {
            if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            } else if (c == 'L') {
                x--;
            } else {
                x++;
            }
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String instructions = in.nextLine();
        int[] res = new Main().calculateFinalPositi(instructions);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
