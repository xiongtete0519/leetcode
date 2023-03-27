package 模拟题.猜生日;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        for (int i = 1900; i <=2012 ; i++) {    //遍历年
            for (int j = 1; j <=30; j++) {      //遍历日
                LocalDate date = LocalDate.of(i, 6, j);
                int num = Integer.parseInt(dtf.format(date));
                if(num%2012==0&&num%3==0&&num%12==0){
                    System.out.println(num);
                    return;
                }
            }
        }
    }
}
