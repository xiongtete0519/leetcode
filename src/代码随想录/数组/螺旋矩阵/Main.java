package 代码随想录.数组.螺旋矩阵;


import java.util.Arrays;

public class Main {

    public static int[][] generateMatrix(int n) {
        int loop=0; //控制循环次数
        int[][] res=new int[n][n];
        int start=0;    //每次循环的起始点
        int count=1;    //定义填充数字
        int i,j;
        while(loop++<n/2){  //判断边界后，loop从1开始
            //模拟上侧从左到右
            for (j = start; j <n-loop ; j++) {
                res[start][j]=count++;
            }
            //右侧从上到下
            for (i = start; i <n-loop ; i++) {
                res[i][j]=count++;
            }
            //下侧从下到上
            for(;j>=loop;j--){
                res[i][j]=count++;
            }
            //左侧从下到上
            for(;i>=loop;i--){
                res[i][j]=count++;
            }
            start++;
        }
        //如果n为奇数，需要单独给矩阵最中间的位置赋值
        if(n%2==1){
            res[start][start]=count;
        }
        return res;
    }

    /**
     * 当count<=target时，始终按照从左至右、从上到下、从右到左、从下到上的填入顺序循环
     * 每次填入后:
     *      执行count++,得到下一个需要填入的数组
     *      更新边界：例如从左到右填完后，上边界top++,相当于上边界向内缩1
     */
    public static int[][] generateMatrix1(int n) {
        int left=0;     //左边界
        int right=n-1;  //右边界
        int top=0;      //上边界
        int bottom=n-1; //下边界
        int count=1,target=n*n;
        int[][] res=new int[n][n];

        while(count<=target){
            //从左到右填充，相当于缩小上边界
            for (int j = left; j <=right; j++) {
                res[top][j]=count++;
            }
            top++;   //缩小上边界
            //从上到下填充,相当于缩小右边界
            for (int i = top; i <=bottom ; i++) {
                res[i][right]=count++;
            }
            right--;    //缩小右边界
            //从右向左填充，相当于缩小下边界
            for (int j = right; j >=left ; j--) {
                res[bottom][j]=count++;
            }
            bottom--;   //缩小下边界
            //从下向上填充，相当于缩小左边界
            for (int i = bottom; i >=top ; i--) {
                res[i][left]=count++;
            }
            left++; //缩小左边界
        }
        return res;
    }
    public static void main(String[] args) {
//        int[][] ints = generateMatrix(4);
        int[][] ints = generateMatrix1(3);
        for (int[] anInt : ints) {
            System.out.println(Arrays.toString(anInt));
        }
    }
}
