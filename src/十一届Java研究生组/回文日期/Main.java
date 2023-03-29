package 十一届Java研究生组.回文日期;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        LocalDate now = LocalDate.parse(str, dtf);
        now=now.plusDays(1);
        boolean backFlag=false;
        String date1="";
        String date2="";
        while(true){
            if(huiwen(now)){
                if(!backFlag){
                    date1=dtf.format(now);
                    backFlag=true;
                }
                if(ABABBABA(now)){
                    date2=dtf.format(now);
                    break;
                }
            }
            now=now.plusDays(1);
        }
        System.out.println(date1);
        System.out.println(date2);
        br.close();
    }
    //判断回文日期
    public static boolean huiwen(LocalDate date){
        String format = dtf.format(date);
        String str = new StringBuffer(format).reverse().toString();
        return format.equals(str);
    }
    //判断是否是ABABBABA型日期
    public static boolean ABABBABA(LocalDate date){
        String s = dtf.format(date);
        char[] chars = s.toCharArray();
        if(chars[0]==chars[2]&&chars[2]==chars[5]&&chars[5]==chars[7]
        &&chars[1]==chars[3]&&chars[3]==chars[4]&&chars[4]==chars[6]){
            return true;
        }else{
            return false;
        }
    }
}
