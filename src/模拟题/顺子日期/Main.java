package 模拟题.顺子日期;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        long res=0;
        LocalDate start = LocalDate.of(2022, 1, 1);
        LocalDate end = LocalDate.of(2022, 12, 31);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        while (true){
            if(check(start)){
//                System.out.println(dtf.format(start));
                res++;
            }
            if(start.getYear()==end.getYear()&&start.getMonth()==end.getMonth()&&start.getDayOfMonth()==end.getDayOfMonth()){
                break;
            }
            start=start.plusDays(1);
        }
        System.out.println(res);
    }
    //校验顺子日期
    public static boolean check(LocalDate date){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        String s = dtf.format(date);
        //采用滑动窗口判断是否是顺子日期
        int left=0;
        int right=left+2;
        while(right<s.length()){
            //截取出left到right这三个数字
            String str = s.substring(left, right + 1);
            int a = Integer.parseInt(String.valueOf(str.charAt(0)));
            int b = Integer.parseInt(String.valueOf(str.charAt(1)));
            int c = Integer.parseInt(String.valueOf(str.charAt(2)));
            if(a+1==b&&b+1==c){
                return true;
            }else{
                left++;
                right++;
            }
        }
        return false;
    }
}
