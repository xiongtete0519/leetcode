package 十届Java研究生组.立方和;

public class Main {
    public static void main(String[] args) {
        long res=0;
        for (int i = 1; i <=2019 ; i++) {
            if(check(i)){
                res+=i*i*i;
            }
        }
        System.out.println(res);
    }
    //判断数字中是否含有2019
    public static boolean check(int n){
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int tmp = Integer.parseInt(String.valueOf(chars[i]));
            if(tmp==2||tmp==0||tmp==1||tmp==9){
               return true;
            }
        }
        return false;
    }
}
