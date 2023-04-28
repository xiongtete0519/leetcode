package 十三届蓝桥杯国赛.火柴棒数字;

public class Main {
    public static int[] w={0,6,2,5,5,4,5,6,3,7,6};
    public static int[][] f=new int[11][310];
    public static void main(String[] args) {
        //多重背包dp
        for (int i = 1; i <=10 ; i++) {
            for (int j = 300; j >=w[i]; j--) {
                for (int k = 0; k <=10 ; k++) {
                    if(j>=k*w[i]){
                        f[i][j]=Math.max(f[i][j],f[i-1][j-k*w[i]]+k);
                    }
                }
            }
        }
        StringBuffer buffer = new StringBuffer();
        int j=300;
        for (int i = 10,k=0; i >0 ; --i,k=0) {
            for(int g=1;g<=10;++g){
                if(j-g*w[i]>=0&&f[i][j]==f[i-1][j-g*w[i]]+g){
                    k=g;
                }
            }
            for(j-=k*w[i];k>0;--k){
//                System.out.println(i-1);
                buffer.append(i-1);
            }
        }
        System.out.println(buffer);
    }
}
