package 十三届Java研究生组.推导部分和;

import java.io.*;

/**
 * 推导部分和：带权并查集
 * 本题中，区间左端点从0开始，计算部分和的时候不包括左端点的值
 * 原因：求1到2位置上的部分和时，若并查集结构为(1->2)，此时1到2之间就只能有一个权值，
 * 即只能指导1或者2位置上的值，所以并查集的结构应改为(0->1->2)
 * 即(0->1)的边权值是表示1位置的值，(1->2)的边权值表示2位置的值
 * 此时求1到2位置上的部分和时，即(0->1->2)路径的权值和
 */
public class Main {
    //记录每个节点的父节点
    public static int[] father;
    //value[i]表示i到其根节点的路径长度
    public static long[] value;
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    public static void main(String[] args) throws IOException {
        int N = nextInt();    //数组长度
        int M = nextInt();    //已知的部分和数量
        int Q = nextInt();    //询问的部分和数量
        father=new int[N+1];
        init(N);
        value = new long[N + 1];

        //已知的部分和
        for (int i = 0; i <M; i++) {
            int left = nextInt();
            int right = nextInt();
            long s = nextLong();
            left--;
            union(left,right,s);
        }
        //询问的部分和
        for (int i = 0; i <Q ; i++) {
            int left = nextInt();
            int right = nextInt();
            left--;
            int leftFather = findFather(left);
            int rightFather = findFather(right);
            if(leftFather!=rightFather){
                out.println("UNKNOWN");
            }else{
                out.println(value[left]-value[right]);
            }
        }
        out.flush();
        out.close();
    }
    //带权并查集初始化
    public static void init(long n){
        for (int i = 0; i <=n; i++) {
            father[i]=i;    //初始的时候父节点都指向自己
        }
    }
    //带权并查集查找操作(路径压缩)
    public static int findFather(int x){
        if(father[x]!=x){
            int tmp = father[x];
            father[x]=findFather(father[x]);//找根节点
            value[x]+=value[tmp];   //压缩路径
        }
        return father[x];
    }
    //带权并查集合并操作
    public static void union(int left,int right,long s){
        int leftFather = findFather(left);
        int rightFather = findFather(right);
        if(leftFather!=rightFather) {
            //合并x和y的集合，并更新权值
            //合并规则，将小根节点集合指向大根节点集合
            int small = Math.min(leftFather, rightFather);
            int big = Math.max(leftFather, rightFather);
            father[small]=big;
            value[small]=Math.abs(-value[left]+value[right]+s);
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
