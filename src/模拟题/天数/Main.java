package 模拟题.天数;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;


public class Main {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(1949, 10, 1);
        LocalDate end = LocalDate.of(2022, 1, 1);

        Period between = Period.between(start, end);
//        System.out.println(between.getYears());
//        System.out.println(between.getMonths());
//        System.out.println(between.getDays());
        //方法1
        System.out.println(ChronoUnit.DAYS.between(start, end));
//        System.out.println(ChronoUnit.YEARS.between(start, end));

        //方法2
//        int count=0;
//        while (start.getYear() != 2022 || start.getMonth().getValue() != 1
//                || start.getDayOfYear() != 1) {
//            //一天一天加
//            start = start.plusDays(1);
//            count++;
//        }
//        System.out.println(count);
    }
}
