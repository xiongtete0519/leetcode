package LanQiaoBei.九进制转十进制;

public class Main {

    public static int parse9(String s){
        char[] chars = s.toCharArray();
        int sum=0;
        int f=1;
        for (int i = 0; i < chars.length; i++) {
           sum+=Integer.parseInt(String.valueOf(chars[chars.length-i-1]))*f;
           f=f*9;
        }
        return sum;
    }
    public static int parse9(Integer num){
        int f=1;
        int result=0;
        while(num!=0){
            result+=num%10*f;
            f=f*9;
            num=num/10;
        }
        return result;

    }

    public static void main(String[] args) {
        //将9进制数字(2022)转为10进制是多少
        String s="2022";
        Integer result=Integer.parseInt(s,9);
        System.out.println(result);
        System.out.println(parse9(s));
        System.out.println(parse9(2022));
    }
}
