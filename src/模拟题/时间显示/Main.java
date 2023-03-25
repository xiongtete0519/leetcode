package 模拟题.时间显示;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long time = scan.nextLong();

        //将此瞬间转换为1970-01-01T00：00：00Z的时期的毫秒数。
//        long time = now.toInstant(ZoneOffset.of("+8")).toEpochMilli();
//        System.out.println(time);
//        LocalDateTime dateTime = new Date(time).toInstant().atOffset(ZoneOffset.of("+8")).toLocalDateTime();
//        System.out.println(dateTime);
        //时间戳转LocalDateTime 这里用的是格林威治时间,不是北京时间,不是东八区
        LocalDateTime test = new Date(time).toInstant().atOffset(ZoneOffset.of("+0")).toLocalDateTime();
//        LocalDateTime test = new Date(46800999L).toInstant().atOffset(ZoneOffset.of("+0")).toLocalDateTime();
//        LocalDateTime test1 = new Date(1618708103123L).toInstant().atOffset(ZoneOffset.of("+0")).toLocalDateTime();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        String format = dtf.format(test);
        System.out.println(format);

    }
}
