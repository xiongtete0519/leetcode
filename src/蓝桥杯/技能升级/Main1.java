package 蓝桥杯.技能升级;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * 40%通过
 */
public class Main1 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        long n = (long)st.nval;
        st.nextToken();
        long m = (long)st.nval;
        //存放每次升级带来的攻击力
        ArrayList<Long> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st.nextToken();
            long a = (long)st.nval;
            st.nextToken();
            long b = (long)st.nval;
            //计算每个技能可以升级多少次（题目中是上取整，效果是一样的）
            int count= (int) (a%b>0?a/b+1:a/b);
            //直接将这个技能点满(点到不增加攻击力为止)
            for (int j = 0; j <count ; j++) {
                list.add(a);    //存放提升的攻击力
                a-=b;//下一次升级只能获得a-b点攻击力
                if(a<0){
                    break;
                }
            }
        }
        //将list逆序排序，并取前M个最大的数字并求和
        Long sum = list.stream()
                .sorted(Comparator.reverseOrder())//reverseOrder()返回一个与自然排序相反的比较器
                .limit(m).reduce(Long::sum)
                .orElse(0L);
        System.out.println(sum);
    }
}
