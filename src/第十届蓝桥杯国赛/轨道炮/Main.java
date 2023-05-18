package 第十届蓝桥杯国赛.轨道炮;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        //记录每个单位的坐标并实时变化
        int[][] coordinate = new int[n][2];
        //记录每个单位的速度以及移动方向   U:20,D:3,L:11,R:17
        int[][] move=new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            coordinate[i][0]=Integer.parseInt(s[0]);
            coordinate[i][1]=Integer.parseInt(s[1]);
            move[i][0]=Integer.parseInt(s[2]);  //vi
            move[i][1]=s[3].charAt(0)-'A';   //方向
        }

        int ans=1;
        int count=1000;
        while(count-->0){
            ans=Math.max(ans,check(coordinate));
            for (int i = 0; i < n; i++) {   //每个敌方单位坐标变化
                if(move[i][1]==20){ //上
                    coordinate[i][1]+=move[i][0];
                }else if(move[i][1]==3){    //下
                    coordinate[i][1]-=move[i][0];
                }else if(move[i][1]==11){//左
                    coordinate[i][0]-=move[i][0];
                }else{  //右
                    coordinate[i][0]+=move[i][0];
                }
            }
        }
        System.out.println(ans);
        br.close();
    }
    //返回用一行或者同一列的最大元素个数
    public static int check(int[][] arr) {
        int max=1;
        int n=arr.length;
        //利用Map集合，键记录坐标，值记录同坐标的个数
        HashMap<Integer, Integer> xCount = new HashMap<>();
        HashMap<Integer, Integer> yCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x=arr[i][0];    //横坐标
            int y=arr[i][1];    //纵坐标
            //记录个数
            xCount.put(x,xCount.getOrDefault(x,0)+1);
            yCount.put(y,yCount.getOrDefault(y,0)+1);
        }
        //同行
        for (Integer x : xCount.values()) {
            max=Math.max(max,x);
        }
        //同列
        for (Integer y : yCount.values()) {
            max=Math.max(max,y);
        }
        //返回在同一行或同一列的最大个数
        return max;
    }
}
