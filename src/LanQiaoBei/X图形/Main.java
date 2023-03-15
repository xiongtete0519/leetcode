package LanQiaoBei.X图形;

import java.util.Scanner;

/**
 * 输入：
 * 8 8 LQQLQLQL LLQLLLQL LQQQLLLQ QLQLQLQQ LLLLLLQL QLQQLLQL QLLLQLLQ QLQQQLLL
 * 输出：
 * 3
 */
public class Main {
    public static int n;
    public static int m;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
         n = scan.nextInt();
         m = scan.nextInt();
         int count=0;
        char[][] arr = new char[n + 1][m + 1];
        for (int i = 1; i <arr.length ; i++) {
            String next = '0'+scan.next();
            arr[i]=next.toCharArray();
        }
//        for (char[] chars : arr) {
//            for (char aChar : chars) {
//                System.out.print(aChar+" ");
//            }
//            System.out.println();
//        }

//        System.out.println(judgeX(arr, 3, 6));
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=m ; j++) {
                count+=judgeX(arr,i,j);
            }
        }
        System.out.println(count);
    }
    //计算以坐标(r,c)为中心点可以得出几个X图形
    public static Integer judgeX(char[][] arr,int r,int c){
        int count=0;
        for (int i = 1; i <=arr.length-1-r ; i++) {
            if(r==1||r==arr.length-1||c==1||c==arr[0].length-1){
                continue;
            }
            //计算出四个点的坐标
            int x1=r-i;
            int y1=c-i;
            int x2=r-i;
            int y2=c+i;
            int x3=r+i;
            int y3=c-i;
            int x4=r+i;
            int y4=c+i;
            //判断四个顶点坐标是否越界
            if(x1>=1&&x1<=n&&x2>=1&&x2<=n&&x3>=1&&x3<=n&&x4>=1&&x4<=n
            &&y1>=1&&y1<=m&&y2>=1&&y2<=m&&y3>=1&&y3<=m&&y4>=1&&y4<=m){
                //判断是否符合X图形结构
                if(arr[x1][y1]==arr[x2][y2]&&arr[x2][y2]==arr[x3][y3]
                &&arr[x3][y3]==arr[x4][y4]&&arr[x4][y4]==arr[r][c]){
                    count++;
                } else{ //如果第一次都不是X，后面就都不用判断了
                    break;
                }
            }
        }
        return count;
    }
}
