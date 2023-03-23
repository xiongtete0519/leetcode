package 蓝桥杯.顺子日期;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String[] seq={
                "012", "123","234","345","456","567","678","789"
        };
        LocalDate localDate = LocalDate.of(2022, 1, 1);
        Integer count=0;
        while(localDate.getYear()==2022){
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
            String format = dtf.format(localDate);
            for (String s : seq) {
                if(format.contains(s)){
                    count++;
                    break;//每个日期只被统计一次,20220123这个会被统计两次
                }
            }
            localDate= localDate.plusDays(1);
        }
        System.out.println(count);
    }
}
