package leetcode;
//二进制求和
public class LeetCode67 {
    //先转换成十进制，求和之后再转换成二进制
    //字符串太长就有问题
    public static String addBinary(String a,String b){
        return Integer.toBinaryString(
                Integer.parseInt(a,2)+Integer.parseInt(b,2)
        );
    }
    public static String addBinary1(String a,String b){
        //进位标志
        int flag=0;
        //先用0补齐，让两个字符串一样长
        while(a.length()<b.length()){
            a="0"+a;
        }
        while(a.length()>b.length()){
            b="0"+b;
        }
        String result ="";
        for (int i = a.length()-1; i >=0 ; i--) {
            int value=Integer.parseInt(String.valueOf(a.charAt(i)))
                    +Integer.parseInt(String.valueOf(b.charAt(i)))+flag;
            if(value>=2){   //有进位
                value-=2;
                flag=1;
            }else{
                flag=0;
            }
            result=value+result;
        }
        if(flag==1){    //如果最高位也有进位
            result="1"+result;
        }
        return result;
    }

    public static void main(String[] args) {
        String a="11";
        String b="1";
        System.out.println(addBinary1(a, b));
    }
}
