package study.全排列;

/**
 * **2017年Java组c组第三题:**
 *
 * A,2,3,4,5,6,7,8,9共9张纸牌排成一个正三角形（A按1计算）。要求每个边的和相等。 下图就是一种排法。
 *
 * 图片描述这样的排法可能会有很多。
 *
 * 如果考虑旋转、镜像后相同的算同一种，一共有多少种不同的排法呢？请你计算并提交该数字。
 *
 * - 分析：同一个三角形，旋转加镜像后会变成6种，所以最终的结果要除6
 */
//回溯法
public class Demo1 {
    public static int count=0;//符合条件的排列组合个数
    public static int[] num=new int[10];//存放数据的数组
    public static boolean[] bool=new boolean[10];//存是否存放的标志
    public static void main(String[] args) {
        dfs(1);
        System.out.println(count/3/2);
    }
    public static void dfs(int step){//初始值为1

        if(step==10){//代表9位数据都已经赋值完成
            //1246 6789 1359 是三角形三条边在数组中的下标
            if(num[1]+num[2]+num[4]+num[6] == num[6]+num[7]+num[8]+num[9] &&
                    num[1]+num[2]+num[4]+num[6] == num[1]+ num[3]+ num[5]+ num[9]){
                count++;
            }
            return;
        }
        //i从1开始方便   1-9
        for (int i = 1; i <10 ; i++) {
            if(!bool[i]){
                bool[i]=true;   //填充标志
                num[step]=i;    //填充数据
                dfs(step+1);
                bool[i]=false;
            }
        }
    }
}
