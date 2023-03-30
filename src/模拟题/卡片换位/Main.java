package 模拟题.卡片换位;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;

public class Main {
    public static int[] dir={  //由于是一行存储的，所以方向和二维的有点差别
            -3,//上
            -1,//左
            1,//右
            3//下
    };
    public static int step=0;//步数
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        String str = str1.concat(str2);

        //获取A和B的位置
        int Aindex = str.indexOf('A');
        int Bindex = str.indexOf('B');
        bfs(str,Aindex,Bindex);
    }
    //广搜
    public static void bfs(String str,int Aindex,int Bindex){
        LinkedList<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();

        queue.offer(str);
        set.add(str);
        while(!queue.isEmpty()){
            int len = queue.size();
            while(len-->0){
                String temp = queue.poll();
                //出口
                if(temp.charAt(Aindex)=='B'&&temp.charAt(Bindex)=='A'){
                    System.out.println(step);
                    return;
                }
                //获取空格位置
                int index = temp.indexOf(' ');
                for (int i = 0; i <4; i++) {
                    int newIndex = index + dir[i];
                    //判断是否越界
                    if(newIndex<0||newIndex>temp.length()-1){
                        continue;
                    }
                    //只能上下左右交换
                    if((index%3==newIndex%3)||(index/3==newIndex/3)){
                        //交换
                        char[] tempChar = temp.toCharArray();
                        tempChar[index]=temp.charAt(newIndex);
                        tempChar[newIndex]=temp.charAt(index);
                        String s = new String(tempChar);
                        //判断该场景是否重复
                        if(!set.contains(s)){
                            set.add(s);
                            queue.offer(s);
                        }
                    }
                }
            }
            step++;
        }
    }
}
