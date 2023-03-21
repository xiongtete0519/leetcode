package LanQiaoBei.技能升级;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 30%通过
 * 问M此最多可以增加多少攻击力，我们直接将每个技能都点满(点到不能再继续增加攻击力为止)
 * 每升级一次技能，我们都需要将这次升级所提升的攻击力存到一个list里面，还需要更新一下该技能下一次能提升多少攻击力
 * 除此之外，还要考虑每个技能最多可以升级多少次，这个次数就是我们对每个技能升级的遍历次数
 * 最后所有的技能都升级完(点满，不再增加攻击力了)，那我们只需要取集合中前M个最大的数字并求和，
 * 即可得到升级M次技能最大所能提升的攻击力
 */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        //存放每次升级带来的攻击力
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            //计算每个技能可以升级多少次（题目中是上取整，效果是一样的）
            int count=a%b>0?a/b+1:a/b;
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
        Integer sum = list.stream()
                .sorted(Comparator.reverseOrder())//reverseOrder()返回一个与自然排序相反的比较器
                .limit(m)
                .reduce(Integer::sum)
                .orElse(0);
        System.out.println(sum);
    }
}
