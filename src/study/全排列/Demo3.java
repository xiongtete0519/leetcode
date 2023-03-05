package study.全排列;

//暴力解法
public class Demo3 {
    public static void main(String[] args) {
        int sum = 0;
        for (int a = 1; a < 10; a++) {
            for (int b = 1; b < 10; b++) {
                for (int c = 1; c < 10; c++) {
                    for (int d = 1; d < 10; d++) {
                        for (int e = 1; e < 10; e++) {
                            for (int f = 1; f < 10; f++) {
                                for (int g = 1; g < 10; g++) {
                                    for (int h = 1; h < 10; h++) {
                                        for (int i = 1; i < 10; i++) {
                                            if (a == b || a == c || a == d || a == e || a == f || a == g || a == h || a == i
                                                    || b == c || b == d || b == e || b == f || b == g || b == h || b == i
                                                    || c == d || c == e || c == f || c == g || c == h || c == i
                                                    || d == e || d == f || d == g || d == h || d == i
                                                    || e == f || e == g || e == h || e == i
                                                    || f == g || f == h || f == i
                                                    || g == h || g == i
                                                    || h == i) {    //排除掉数字相等的就行
                                                continue;
                                            }
                                            if (a + b + c + d == d + e + f + g && d + e + f + g == g + h + i + a) {
                                                sum++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("一共有" + sum / 6 + "种不同的排法");//除去镜像和旋转两次，三种重复值为：总数/2/3
    }
}
