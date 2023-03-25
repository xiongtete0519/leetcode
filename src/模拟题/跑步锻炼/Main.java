package 模拟题.跑步锻炼;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2000, 1, 1);
        LocalDate end = LocalDate.of(2020, 10, 1);
        long sum=0;
        while(true){
           if(start.getDayOfMonth()==1||start.getDayOfWeek().getValue()==1){
               sum+=2;
           }else{
               sum+=1;
           }
           if(start.getYear()==end.getYear()&&start.getMonth()==end.getMonth()
           &&start.getDayOfMonth()==end.getDayOfMonth()){
               break;
           }
           start=start.plusDays(1);
        }
        System.out.println(sum);
    }
}
