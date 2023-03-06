package LanQiaoBei.山;

public class Main {
    public static void main(String[] args) {
        int left=2022;
        int right=2022222022;
        int count=0;
        long start = System.currentTimeMillis();
        for (int i = left; i <=right; i++) {
            if(judge(i)){
                count++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(count);
        System.out.println("耗时:"+(end-start));
//        System.out.println(judge(14541));
//        System.out.println(judge(145541));
//        System.out.println(judge(123456));
//        System.out.println(judge(1203021));
    }
    //判断数字是否是回文且数位上的数字先单挑不减，后单调不增
    public static boolean judge(int num){
        String numString = String.valueOf(num);
        StringBuilder s = new StringBuilder(numString);
        String s1 = String.valueOf(s);
        String s2 = String.valueOf(s.reverse());
        //先判断是否是回文串
        if(!s1.equals(s2)){
            return false;
        }
        //再判断先单调不减，再单调不增
        return judgeSort(num);
    }
    //判断单调性是否符合条件
    public static boolean judgeSort(int num){
        String numString = String.valueOf(num);
        int length = numString.length();
        int index=length/2; //奇数个数和偶数个数可一并处理
        for (int i = 1; i <= index; i++) {  //先单调不减
            if (!(numString.charAt(i) - '0' >= numString.charAt(i - 1) - '0')) {
                return false;
            }
        }
        for (int i = index + 1; i < length; i++) {  //后单调不增
            if (!(numString.charAt(i) - '0' <= numString.charAt(i - 1) - '0')) {
                return false;
            }
        }
        return true;
    }
}
