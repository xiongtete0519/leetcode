package 国赛打游击.完全日期;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2001, 1, 1);
        LocalDate end = LocalDate.of(2021, 12, 31);
        long count=0;
        while(true){
            int num = fun(start);
            if(check(num)){
                count++;
            }
            if(start.getYear()==end.getYear()&&start.getMonth()==end.getMonth()&&
            start.getDayOfMonth()==end.getDayOfMonth()){
                System.out.println(count);
                break;
            }
            start=start.plusDays(1);
        }
    }
    //计算日期中各位数字之和
    public static int fun(LocalDate localDate){
        int res=0;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        String str = dtf.format(localDate);
        for (int i = 0; i <str.length() ; i++) {
            int tmp = Integer.parseInt(String.valueOf(str.charAt(i)));
            res+=tmp;
        }
        return res;
    }
    //完全平方数判断
    public static boolean check(int n){
        int sqrt = (int)Math.sqrt(n);
        return sqrt*sqrt==n;
    }
}
