package 模拟题.平方和拆分;

public class Main {
    public static void main(String[] args) {
        int ans=0;
        for (int i = 1; i <=2021 ; i++) {
            for (int j = 1; j <=i ; j++) {
                if(j*j==i){ //3*3+0*0
                    ans++;
                    break;
                }
                int diff=i-j*j;
                int tmp= (int) Math.sqrt(diff);
                if(tmp*tmp==diff){//满足i=j*j+tmp*tmp
                    ans++;
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}
