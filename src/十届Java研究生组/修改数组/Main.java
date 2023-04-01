package 十届Java研究生组.修改数组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * 修改数组：并查集
 */
public class Main {
    public static final int MAXN=100010;
    public static int[] father;//记录每个节点的根节点
    public static int[] a; //记录最终结果
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int N = nextInt();
        father=new int[MAXN];
        a=new int[MAXN];
        init();
        for (int i = 1; i <=N; i++) {
            int x = nextInt();
            int root = find(x);
            a[i]=root;
            union(root,root+1);
        }
        Arrays.stream(a).skip(1).limit(N).forEach(x->{
            System.out.print(x+" ");
        });
    }
    //并查集初始化
    public static void init(){
        for (int i = 0; i <MAXN ; i++) {
            father[i]=i; //初始的时候根节点都指向自己
        }
    }
    //并查集查找操作：路径压缩
    public static int find(int x){
       if(father[x]==x){
           return x;
       }else{
           father[x]=find(father[x]);
           return father[x];
       }
    }
    //并查集合并操作:让x的根节点指向y的根节点
    public static void union(int x,int y){
        int xFather = find(x);
        int yFather = find(y);
        if(xFather!=yFather){
            father[xFather]=yFather;
        }
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
    public static long nextLong() throws IOException{
        st.nextToken();
        return (long)st.nval;
    }
}
