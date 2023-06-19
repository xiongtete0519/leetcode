package 笔试.携程2022春招笔试第一批.码风修改;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str=str.replaceAll("\\s","");
        if(str.contains("=")){
            String[] split = str.split("=");
            System.out.println(split[0].trim()+" = "+split[1]);
        }else if(str.contains(">")){
            String[] split = str.split(">");
            System.out.println(split[0].trim()+" > "+split[1]);
        }else{
            String[] split = str.split("<");
            System.out.println(split[0].trim()+" < "+split[1]);
        }

        br.close();
    }
}
