package 模板题.蓝桥幼儿园;

import java.util.Scanner;

public class Main {
    public static int[] fa;
    //初始化
    public static void init(int n){
        fa=new int[n+1];
        for (int i = 1; i <=n ; i++) {
            fa[i]=i;
        }
    }
    //查询:找到i的祖先直接返回
    public static int find(int i){
        if(fa[i]==i){
            return i;
        }else{
            fa[i]=find(fa[i]);
            return fa[i];
        }
    }

    //合并:让i的祖先指向j的祖先
    public static void union(int i,int j){
        int i_father = find(i);//找到i的祖先
        int j_father = find(j);//找到j的祖先
        fa[i_father]=j_father;  //让i的祖先指向j的祖先
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        init(N);
        for (int i = 0; i <M; i++) {
            int op = scan.nextInt();
            int x = scan.nextInt();
            int y = scan.nextInt();
            if(op==1){
                union(x,y);
            }else{
                if(find(x)==find(y)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
        scan.close();
    }
}
//5 5
//2 1 2
//NO
//1 1 3
//2 1 3
//YES
//1 2 3
//2 1 2
//YES