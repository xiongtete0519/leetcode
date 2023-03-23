package 蓝桥杯;
//门牌制作
public class Door {
    public static void main(String[] args) {
        int count=0;
        for (int i = 1; i <2021; i++) {
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j)=='2'){
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
