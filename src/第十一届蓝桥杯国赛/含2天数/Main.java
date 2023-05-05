package 第十一届蓝桥杯国赛.含2天数;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(1900, 1, 1);
        LocalDate end = LocalDate.of(9999, 12, 31);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        long res=0;
        while(true){
            String s = dtf.format(start);
            //判断是否含有2
            if(s.contains("2")){
                res++;
            }
            if(start.getYear()==end.getYear()&&start.getMonth()==end.getMonth()&&start.getDayOfMonth()==end.getDayOfMonth()){
                break;
            }
            start=start.plusDays(1);
        }
        System.out.println(res);
    }
}
