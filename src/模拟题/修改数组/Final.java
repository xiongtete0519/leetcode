package 模拟题.修改数组;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;


/**
 * 并查集
 */
public class Final {
    public static final int MAXN=1000000;
    public static int n;
    //并查集数组，father[i]
    public static int[] father=new int[1000010];
    public static int[] a=new int[1000010];//保存结果
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args) throws IOException {
        n=nextInt();
        init();
        for (int i = 1; i <=n; i++) {
            int x=nextInt();
            int root =find(x);
            a[i]=root;  //保存结果
            union(root,root+1);
        }
        Arrays.stream(a).skip(1).limit(n).forEach(x->{
            System.out.print(x+" ");
        });
    }
    //并查集初始化
    public static void init(){
        for (int i = 1; i <=MAXN; i++) {
            father[i]=i;
        }
    }
    //查找父节点:路径压缩，否则会超时
    public static int find(int x){
        if(father[x]==x){
            return x;
        }else{
            //注意在不断查找根节点的过程中要路径压缩
             father[x]=find(father[x]);
             return father[x];
        }
    }
    public static void union(int x,int y){
        int father_x = find(x); //找到x的祖先
        int father_y = find(y); //找到y的祖先
        father[father_x]=father_y;//让x的祖先指向y的祖先
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
