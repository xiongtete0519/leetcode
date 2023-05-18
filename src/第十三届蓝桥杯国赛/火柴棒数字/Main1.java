package 第十三届蓝桥杯国赛.火柴棒数字;

import java.util.Arrays;
import java.util.LinkedList;

//贪心
public class Main1 {
//    public static int[][] pp={
//            {1,2},
//            {7,3},
//            {4,4},
//            {5,5},
//            {3,5},
//            {2,5},
//            {9,6},
//            {6,6},
//            {0,6},
//            {8,7}
//    };
    public static int[][] pp={
        {0,6},
        {1,2},
        {2,5},
        {3,5},
        {4,4},
        {5,5},
        {6,6},
        {7,3},
        {8,7},
        {9,6},
    };
    public static void main(String[] args) {
        //按照消耗的火柴棒数量从小到大排序，数量相同的按数字本身大小排序，大的排前面
        Arrays.sort(pp, (o1, o2) -> {
            if(o1[1]==o2[1]){
                return o2[0]-o1[0];
            }
            return o1[1]-o2[1];
        });

        LinkedList<Integer> ret = new LinkedList<>();
        int t=300;
        for (int i = 0; i <10 ; i++) {
            int k=0;
            if(t>=10*pp[i][1]){//是否能装下10个
                t-=10*pp[i][1];//剪掉第i个数字放10个消耗的火柴棒
                k=10;
            }else if(t>=pp[i][1]){
                k=t/pp[i][1];   //第i个数字能装几个
                t-=k*pp[i][1];  //剪掉消耗的火柴棒数量
            }
            for (int j = 0; j <k ; j++) {   //数字依次入队列
                ret.add(pp[i][0]);
            }
        }
        //队列进行逆序，较大的数字放在左边
        ret.sort((o1,o2)->o2-o1);
//        System.out.println(t);//剩余的火柴棒
        ret.forEach(System.out::print);//输出最大的数
    }
}
