package 模拟题.时间显示;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Date;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        long mills = scan.nextLong();
//        Date date = new Date(mills);
        long mills = LocalDateTime.now().toInstant(ZoneOffset.of("+0")).toEpochMilli();
        LocalDateTime now = new Date(mills).toInstant().atOffset(ZoneOffset.of("+0")).toLocalDateTime();
        System.out.println(now);

        System.out.println(Instant.now());
        System.out.println(Instant.now().atOffset(ZoneOffset.of("+8")));

        //获取默认时区
        System.out.println(OffsetDateTime.now().getOffset());
    }
}
