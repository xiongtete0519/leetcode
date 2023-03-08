package LanQiaoBei.重合次数;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDateTime d1 = LocalDateTime.of(2022, 3, 8, 6, 13, 22);
        LocalDateTime d2 = LocalDateTime.of(2022, 3, 8, 14, 36, 20);
        System.out.println(d1);
        System.out.println(d2);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        System.out.println(formatter.format(d1));

        //先计算出经过了多少秒，没经过61秒，秒针和分针就会重合一次，最后算出的结果对61取整即可。
        int a=(14-6)*60*60+(36-13)*60-2;
        int b = a / 61;
        System.out.println(b);

    }
}
