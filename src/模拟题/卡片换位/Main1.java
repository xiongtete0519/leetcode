package 模拟题.卡片换位;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;

public class Main1 {
    //定义方向
    public static int[][] dirs={
            {0,1},  //右
            {1,0},  //下
            {0,-1}, //左
            {-1,0}  //上
    };
    public static String str1;
    public static String str2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = br.readLine();
        String str = str1.concat(str2);
        bfs(str);
        br.close();
    }
    public static void bfs(String str){
        LinkedList<Node> queue = new LinkedList<>();//存放当前的一些数据(空格的位置、地图、步数)
        HashSet<String> set = new HashSet<>();  //判断当前的地图是否已经存在过了
        //初始数据准备
        int pos = str.indexOf(' ');//找到空格位置
        //pos/3为原先二维中的行坐标，pos%3是列坐标
        Node node = new Node(pos / 3, pos % 3, str, 0);
        //标记A和B的位置
        int posA = str.indexOf('A');
        int posB = str.indexOf('B');

        queue.offer(node);  //入队
        set.add(node.currStr);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            for (int[] dir : dirs) {    //开始向四个方向扩展
                int x = curr.curX + dir[0];
                int y = curr.curY + dir[1];
                if(x<0||x>1||y<0||y>2){ //判断是否越界
                    continue;
                }
                String tempStr = curr.currStr;
                //空格和相邻位置交换，产生新的地图  (两个位置互换)
                char[] tempChar = tempStr.toCharArray();
                tempChar[curr.curX*3+curr.curY]=tempStr.charAt(x*3+y);
                tempChar[x*3+y]=tempStr.charAt(curr.curX*3+curr.curY);
                String s=new String(tempChar);

                //当前最新生成的数据
                Node tmp = new Node(x,y, s, curr.curStep + 1);
                if(s.charAt(posA)=='B'&&s.charAt(posB)=='A'){
                    System.out.println(tmp.curStep);
                    return;
                }
                //判断这个地图是否重复
                if(!set.contains(tmp.currStr)){
                    set.add(tmp.currStr);
                    queue.offer(tmp);
                }
            }
        }
    }
}
class Node{
    int curX;   //当前空格所在位置
    int curY;
    String currStr; //当前的字符串(地图情景)
    int curStep;    //当前移动了多少步

    public Node() {
    }

    public Node(int curX, int curY, String currStr, int curStep) {
        this.curX = curX;
        this.curY = curY;
        this.currStr = currStr;
        this.curStep = curStep;
    }
}
