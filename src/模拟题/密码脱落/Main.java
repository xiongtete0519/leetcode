package 模拟题.密码脱落;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        String str = nextString();
        long count = findCode(str);
        System.out.println(count);
    }
    //查找对称序列需要添加的符号数量
    public static long findCode(String code){
        char[] codeChars = code.toCharArray();
        long count=0;   //计算得到的符号数量，最终返回该值
        int left=0;
        int right=codeChars.length-1;
        int leftCount=0;    //
        int rightCount=0;
        while(left<right){
            if(codeChars[left]==codeChars[right]){//相等 继续往前走
                left++;
                right--;
                continue;
            }
            leftCount=0;
            int leftCursor=left; //左工作指针，因为left是不能动的，我们使用这个游标取寻找
            while(codeChars[leftCursor]!=codeChars[right]){
                leftCursor++;   //继续向右边走
                leftCount++;    //左边要添加的字符数累加
            }
            rightCount=0;
            int rightCursor=right;  //右工作指针
            while(codeChars[rightCursor]!=codeChars[left]){
                rightCursor--;  //继续向左边走
                rightCount++;
            }
            //取最近的
            if(leftCount<rightCount){   //左边走的步数少
                left+=leftCount;    //从左往右走
            }else{  //右边走的步数少
                right-=rightCount; //从右往左走
            }
            count+=Math.min(leftCount,rightCount);
        }
        return count;
    }
    public static String nextString() throws IOException{
        st.nextToken();
        return st.sval;
    }
}
