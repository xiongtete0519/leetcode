package 模拟题.时长计算;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String start = scan.next();
        String end = scan.next();
        DateTimeFormatter sdf = DateTimeFormatter.ofPattern("HH:mm:ss");
        //开始时间
        LocalTime startTime = LocalTime.parse(start, sdf);
        //结束时间
        LocalTime endTime = LocalTime.parse(end, sdf);
//        System.out.println(startTime);
//        System.out.println(endTime);
        //获取一个 Duration表示两个时间对象之间的持续时间。
        Duration between = Duration.between(startTime, endTime);
        //获取次持续时间内的总描述
        long seconds = between.getSeconds();
        //计算经过了几个小时
        long hour=seconds/60/60;
        //经过了多少分钟
        long minute=(seconds-(hour*60*60))/60;
        //经过了多少秒
        long second=seconds-(hour*60*60)-(minute*60);
//        System.out.println("hour="+hour);
//        System.out.println("minute="+minute);
//        System.out.println("second="+second);
        //用hour、minute和second创建LocalTime对象，最后格式化输出
        LocalTime localTime = LocalTime.of((int)hour, (int)minute, (int)second);
        String format = localTime.format(sdf);
        System.out.println(format);
        scan.close();
    }
}
