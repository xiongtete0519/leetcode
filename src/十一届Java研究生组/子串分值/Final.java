package 十一届Java研究生组.子串分值;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//计算贡献度
public class Final {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] chars = str.toCharArray();
        long res=0;
        for (int i = 0; i <chars.length; i++) {
            int left=0;
            int right=0;
            //往左边移动的步数
            for (int j=i-1;j>=0&&chars[i]!=chars[j];j--){
                left++;
            }
            //往右边移动的步数
            for (int j = i+1; j <chars.length&&chars[i]!=chars[j]; j++) {
                right++;
            }
            res+=(left+1)*(right+1);
        }
        System.out.println(res);
        br.close();
    }
}
