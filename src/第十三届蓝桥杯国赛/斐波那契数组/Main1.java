package 第十三届蓝桥杯国赛.斐波那契数组;

import java.io.*;
//ac
public class Main1 {
    public static StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
    public static int[] arr=new int[50];
    public static int V=1000000;
    public static int count=0;
    public static void main(String[] args) throws IOException {
        int res=Integer.MAX_VALUE;
        int n=nextInt();
        count=n;
        if(n>30){//只读入前30个数
            n=30;
        }
        for (int i = 1; i <=n; i++) {
            arr[i]=nextInt();
        }
        //枚举开头是多少
        for (int i = 1; i <=V; i++) {
            int a=i;
            int b=i;
            int c=0;
            int ans=0;
            if(arr[1]==a){
                ans++;
            }
            if(arr[2]==b){
                ans++;
            }
            for(int j=3;j<=30;j++){
                c=a+b;
                //这里是一个剪枝
                if(c>V)
                    break;
                if(c==arr[j]){
                    ans++;
                }
                a=b;
                b=c;
            }
            res=Math.min(count-ans,res);
        }
        out.println(res);
        out.flush();
        out.close();
    }
    public static int nextInt() throws IOException{
        st.nextToken();
        return (int)st.nval;
    }
}
