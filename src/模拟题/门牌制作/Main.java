package 模拟题.门牌制作;


public class Main {
                public static void main(String[] args) {
                    long sum=0;
                    for (int i = 1; i <=2020; i++) {
                        sum+=count(i);
                    }
                    System.out.println(sum);
                }
                //统计字符中有几个字符2
                public static long count(int n){
                    long sum=0;
                    String s = String.valueOf(n);
                    char[] chars = s.toCharArray();
                    for (int i = 0; i < chars.length; i++) {
                        if(chars[i]=='2'){
                            sum++;
                        }
        }
        return sum;
    }
}
