package 国赛刷题挑战.修改数组;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
//Main2:并查集
public class Main {
    public static int MAXN=1000000;
    public static int[] father=new int[1000010];//并查集数组
    public static int[] arr=new int[1000010];    //保留最终结果
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        long n=nextLong();
        init();//并查集初始化
        for (int i = 1; i <=n ; i++) {
            int x=nextInt();
            int root = find(x);
            arr[i]=root;//保存结果
            union(root,root+1);
        }
        Arrays.stream(arr).skip(1).limit(n).forEach(x->{
            System.out.print(x+" ");
        });
    }
    //并查集初始化
    public static void init(){
        for (int i = 1; i <=MAXN; i++) {
            father[i]=i;    //初始都指向自己
        }
    }
    //查找祖先节点：路径压缩
    public static int find(int x){
        if(father[x]==x){
            return x;
        }else{
            //在不断查找根节点的过程中要路径压缩
            father[x]=find(father[x]);
            return father[x];
        }
    }
    //合并操作
    public static void union(int x,int y){
        int father_x=find(x);   //找到x的祖先
        int father_y=find(y);   //找到y的祖先
        if(father_x!=father_y){
            father[father_x]=father_y;  //让x的祖先指向y的祖先
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
