package 国赛复习.部分省赛复习.修改数组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

public class Main {
    public static final int MAXN=1000000;
    public static int n;
    //并查集数组，father[i]
    public static int[] father=new int[MAXN+10];
    public static int[] a=new int[MAXN+10];
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException{
        n=nextInt();
        init();
        for (int i = 1; i <=n ; i++) {
            int x=nextInt();
            int root=find(x);
            a[i]=root;  //保存结果
            union(root,root+1); //执行合并
        }
        Arrays.stream(a).skip(1).limit(n).forEach(x->{
            System.out.print(x+" ");
        });
    }
    //并查集初始化：每个节点刚开始的父节点都指向自己
    public static void init(){
        for (int i = 1; i <=MAXN ; i++) {
            father[i]=i;
        }
    }
    //查找父节点：路径压缩，否则会超时
    public static int find(int x){
        if(father[x]==x){
            return x;
        }else{
            //注意在不断查找根节点的过程中要路径压缩
            father[x]=find(father[x]);
            return father[x];
        }
    }
    //并查集合并操作
    public static void union(int x,int y){
        int father_x = find(x); //找到x的祖先
        int father_y = find(y);//找到y的祖先
        if(father_x!=father_y){
            father[father_x]=father_y;  //让x的祖先指向y的祖先
        }
    }
    public static int nextInt() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }
    public static long nextLong() throws IOException{
        st.nextToken();
        return (long)st.nval;
    }
}
