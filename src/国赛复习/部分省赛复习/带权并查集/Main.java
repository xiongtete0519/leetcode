package 国赛复习.部分省赛复习.带权并查集;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Main {
    public static int[] father; //记录每个节点的父节点
    public static long[] value; //value[i]表示i到其根节点的路径长度
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        int N=nextInt();    //数组长度
        int M=nextInt();    //已知的部分和数量
        int Q=nextInt();    //询问的部分和数量
        father=new int[N+1];
        init(N);
        value=new long[N+1];

        //已知的部分和
        for (int i = 0; i < M; i++) {
            int left=nextInt();
            int right=nextInt();
            long s=nextLong();
            left--;
            union(left,right,s);
        }
        //询问的部分和
        for (int i = 0; i<Q; i++) {
            int left=nextInt();
            int right=nextInt();
            left--;
            int leftFather=findFather(left);
            int rightFather=findFather(right);
            //两个根节点不同，说明不在一个连通块中，不能确定部分和
            if(leftFather!=rightFather){
                System.out.println("UNKNOWN");
            }else{
                System.out.println(value[left]-value[right]);
            }
        }

    }
    //并查集初始化
    public static void init(long n){
        for (int i = 0; i <=n ; i++) {
            father[i]=i;
        }
    }
    //带权并查集查找操作(路径压缩)
    public static int findFather(int x){
        if(father[x]!=x){
            int tmp=father[x];
            father[x]=findFather(father[x]);//找根节点
            value[x]+=value[tmp];   //更新到根节点的权值
        }
        return father[x];
    }
    //带权并查集合并操作
    public static void union(int left,int right,long s){
        int leftFather=findFather(left);
        int rightFather=findFather(right);
        if(leftFather!=rightFather){
            //合并x和y的集合，并更新权值
            //合并规则，将小根节点集合指向大根节点集合
            int small=Math.min(leftFather,rightFather);
            int big=Math.max(leftFather,rightFather);
            father[small]=big;
            value[small]=Math.abs(-value[left]+value[right]+s);
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
