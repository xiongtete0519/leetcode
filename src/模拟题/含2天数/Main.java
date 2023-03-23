package 模拟题.含2天数;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(1900, 1, 1);
        LocalDate end = LocalDate.of(9999, 12, 31);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        long sum=0;
        while(true){
            if(dtf.format(start).contains("2")){
                sum++;
            }
            if(start.getYear()==end.getYear()&&start.getMonthValue()==end.getMonthValue()&&
            start.getDayOfMonth()==end.getDayOfMonth()){
                System.out.println(sum);
                break;
            }else{
                start=start.plusDays(1);
            }
        }

    }
}
