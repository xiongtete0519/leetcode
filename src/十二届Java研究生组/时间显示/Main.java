package 十二届Java研究生组.时间显示;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException{
        long mill= nextLong();
        //毫秒值转LocalDateTime
        LocalDateTime dateTime = new Date(mill).toInstant().atOffset(ZoneOffset.of("+0")).toLocalDateTime();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time = dtf.format(dateTime);
        System.out.println(time);
        //LocalDateTime转毫秒值
//        System.out.println(dateTime.toInstant(ZoneOffset.of("+0")).toEpochMilli());

    }
    public static long nextLong() throws IOException {
        st.nextToken();
        return (long)st.nval;
    }
    public static String nextString() throws IOException {
        st.nextToken();
        return st.sval;
    }
}
