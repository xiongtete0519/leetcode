package LanQiaoBei.特殊的数;

public class Main {
    public static void main(String[] args) {
        Integer a=8518;
        System.out.println(Integer.toBinaryString(a));
        //转十六进制字符串
        System.out.println(Integer.toHexString(a));
        System.out.println(Integer.parseInt("8518", 16));
        System.out.println(Integer.parseInt("9558", 16));

        for (int i = 10; i <Integer.MAX_VALUE; i++) {
            String s = i + "";
            int hexInt = Integer.parseInt(s, 16);
            if(hexInt%i==0){
                System.out.println(i);
                break;
            }
        }
    }
}
