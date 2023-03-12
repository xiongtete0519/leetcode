package study.并查集;

import java.util.Scanner;


//并查集
public class Union {
    private static int[] fa;
    //1.初始化
    public static void init(int n){
        fa=new int[n+1];
        //假设有编号未1-n的n个元素，我们用一个数组fa[]存储每个元素的父节点
        //开始的时候，我们先将它们的父节点设为自己
        for (int i = 1; i <=n ; i++) {
            fa[i]=i;
        }
    }
    //2.查询：找到i的祖先直接返回，未进行路径压缩(很容易超时)
//    public static int find(int i){
//        if(fa[i]==i){   //递归出口，当打打了祖先位置，就返回祖先
//            return i;
//        }else{
//            return find(fa[i]);//不断往上查找祖先
//        }
//    }
    //2.查询：路径压缩版本
    public static int find(int i){
        if(fa[i]==i){
            return i;
        }else{
            fa[i]=find(fa[i]);  //这一步进行了路径压缩
            return fa[i];   //返回父节点
        }
    }
    //3.合并
    public static void union(int i,int j){
        int i_father=find(i);//找到i的祖先
        int j_father=find(j);//找到j的祖先
        fa[i_father]=j_father;  //i的祖先指向j的祖先(i、j换下也可以)
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); //n个数字
        int m = scan.nextInt(); //m组关系
        init(n);
        for (int i = 1; i <=m ; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            union(x,y);
        }
        int q = scan.nextInt(); //q组询问
        for (int i = 1; i <=q ; i++) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            if(find(x)==find(y)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        scan.close();
    }
}
//10 7
//2 4
//5 7
//1 3
//8 9
//1 2
//5 6
//2 3
//3
//3 4
//7 10
//8 9