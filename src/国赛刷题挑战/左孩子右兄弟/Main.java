package 国赛刷题挑战.左孩子右兄弟;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class Main {
    static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static int N=100000;
    static ArrayList<Integer> tree[] =new ArrayList[N+10];
    //存储根节点距离当前节点的最大距离
    static int[] f=new int[N+10];
    public static void main(String[] args) throws IOException {

        int n=nextInt();
        for (int i = 1; i <=n ; i++) {
            tree[i]= new ArrayList<>();
        }
        for (int i = 2; i <=n ; i++) {
            int x=nextInt();
            tree[x].add(i);
        }
        dfs(1);
        int max=0;
        for (int i = 1; i <=n ; i++) {
            max=Math.max(max,f[i]);
        }
        System.out.println(max);
    }
    public static void dfs(int u){
        //遍历当前所有子节点
        for (Integer i : tree[u]) {
            //当前节点距离根节点的距离= 父节点距离根节点最深的距离 + 当前节点的子节点数(要使该节点最深的话, 也就是这个点在兄年节点中最下面的一个)
            f[i]=f[u]+tree[u].size();
            dfs(i);
        }
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
