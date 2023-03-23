package 模拟题.天干地支;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;

public class Main {
    public static HashMap<Integer, String> tiangan = new HashMap<Integer, String>(){
        {
            put(0,"jia");
            put(1,"yi");
            put(2,"bing");
            put(3,"ding");
            put(4,"wu");
            put(5,"ji");
            put(6,"geng");
            put(7,"xin");
            put(8,"ren");
            put(9,"gui");
        }
    };
    public static HashMap<Integer, String> dizhi = new HashMap<Integer, String>(){
        {
            put(0,"zi");
            put(1,"chou");
            put(2,"yin");
            put(3,"mao");
            put(4,"chen");
            put(5,"si");
            put(6,"wu");
            put(7,"wei");
            put(8,"shen");
            put(9,"you");
            put(10,"xu");
            put(11,"hai");
        }
    };
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int year = nextInt();
        //7 1 代表geng  zi  2020作为基准
        int i=6;
        int j=0;
        int cut=year-2020;
        if(cut>0){
            int tian = (i + cut) % 10;
            int di = (j + cut) % 12;
            System.out.println(tiangan.get(tian)+dizhi.get(di));
        }else{
            int tian = (i + cut) % 10 + 10;
            int di = (j + cut) % 12 + 12;
            System.out.println(tiangan.get(tian)+dizhi.get(di));
        }


    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
