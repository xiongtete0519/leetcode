package 模拟题.日期问题;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Objects;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] split = s.split("/");
        String A=split[0];
        String B=split[1];
        String C=split[2];
        //可能的三种方式只能是ABC、BCA、CBA
        //ABC
        LocalDate date1 = generateDate(A, B, C);
        LocalDate date2 = generateDate1(A, B, C);
        LocalDate date3 = generateDate2(A, B, C);
        Stream.of(date1, date2, date3)
                .distinct()
                .filter(Objects::nonNull)
                .sorted(LocalDate::compareTo)
                .forEach(System.out::println);
    }
    //年月日
    public static LocalDate generateDate(String A, String B, String C){
        int year = Integer.parseInt(A);
        int month = Integer.parseInt(B);
        int day = Integer.parseInt(C);
        try {
            if(year>=60&&year<=99){
                return LocalDate.of(1900+year,month,day);
            }else{
                return LocalDate.of(year+2000,month,day);
            }
        } catch (Exception e) {
            return null;
        }
    }
    //月日年
    public static LocalDate generateDate1(String A,String B,String C){
        int month = Integer.parseInt(B);
        int day = Integer.parseInt(A);
        int year = Integer.parseInt(C);
        try {
            if(year>=60&&year<=99){
                return LocalDate.of(1900+year,month,day);
            }else{
                return LocalDate.of(year+2000,month,day);
            }
        } catch (Exception e) {
            return null;
        }
    }
    //日月年
    public static LocalDate generateDate2(String A,String B,String C){
        int day = Integer.parseInt(B);
        int month = Integer.parseInt(A);
        int year = Integer.parseInt(C);
        try {
            if(year>=60&&year<=99){
                return LocalDate.of(1900+year,month,day);
            }else{
                return LocalDate.of(year+2000,month,day);
            }
        } catch (Exception e) {
            return null;
        }
    }
}