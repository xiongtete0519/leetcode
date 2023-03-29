package 十一届Java研究生组.跑步锻炼;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2000, 1, 1);
        LocalDate end = LocalDate.of(2020, 10, 1);
        long sum=0;
        while(true){
            if (start.getDayOfWeek().getValue()==1||start.getDayOfMonth()==1){
                sum+=2;
            }else{
                sum++;
            }
            if(start.getYear()==end.getYear()&&start.getMonth()==end.getMonth()
            &&start.getDayOfMonth()==end.getDayOfMonth()){
                System.out.println(sum);
                break;
            }
            start=start.plusDays(1);
        }
    }
}
