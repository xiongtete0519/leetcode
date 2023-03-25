package 模拟题.删除字符;


import java.util.*;

/**
 * 字典序这个东西，最左边位置的字母决定性最大，
 * 然后越往右边影响程度越小 所以要确定从左往右的第index个字母
 * 由于只能删除t个，所以从最左边开始，数t个字母，找到最小的字母，让他前移
 * 接着t要减去删掉字母的个数 确认第二个位置的字母要从第一个确定字母之后开始找，重复操作 直至删除次数用完
 */
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String word = scan.next();
        int t = scan.nextInt();//删除字母的数量
        char min;
        char current;//存储当前遍历到的字母
        //从左到右t个字母中最小字母的位置，找到将其保存，并且删除它之前的所有字母
        //之后的字母去它后面寻找
        int index=0;
        String result="";//存储结果单词
        while(t>0){
            min='Z';
            for (int i = 0; i <=t; i++) {
                current=word.charAt(i);
                if(current<min){
                    min=current;
                    index=i;
                }
            }
            //获取到t个字母里面的最小字母之前的字母数，删除操作
            //第一趟确定第一小的字母，第二趟确定第二小，以此类推
            word=word.substring(index+1);
            result+=min;
            t-=index;   //还能删除的字母数量
        }
        //记得把word剩余的字母补上
        System.out.println(result+word);
        scan.close();
    }
}
