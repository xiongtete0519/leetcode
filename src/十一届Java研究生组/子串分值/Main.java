package 十一届Java研究生组.子串分值;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
//40%
public class Main {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        System.out.println(sum(str));
        br.close();
    }
    public static long sum(String str){
        long res=0;
        for (int i = 0; i <str.length(); i++) { //不断地截取子串并判断就行
            for (int j = i; j <str.length() ; j++) {
                res+=score(str.substring(i,j+1));
            }
        }
        return res;
    }
    //计算分值:统计恰好出现一次的字符个数
    public static long score(String str){
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i <str.length() ; i++) {
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        return map.entrySet().stream().filter(x->x.getValue()==1).count();
    }

}
