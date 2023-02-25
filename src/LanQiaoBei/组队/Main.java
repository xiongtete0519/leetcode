package LanQiaoBei.组队;

public class Main {
    public static void main(String[] args) {

        int sum=0;
        int max=0;
        Integer[][] score={
                {97,92,0,0,89,82,0,0,0,95,0,0,94,0,0,0,98,93,0,0},
                {90,85,0,0,83,86,0,97,0,99,0,0,91,83,0,0,83,97,0,99},
                {0,0,0,80,0,0,87,0,0,0,97,93,0,0,97,93,98,96,89,95},
                {0,96,0,0,97,0,0,96,89,0,96,0,0,87,98,0,99,92,0,96},
                {0,0,93,86,0,0,90,0,0,0,0,98,0,0,98,86,81,98,92,81}
        };
        int length=score[0].length;
        for (int i = 0;i<length; i++) {
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < length; k++) {
                    for (int m = 0; m < length; m++) {
                        for (int n = 0; n < length; n++) {
                            if(i!=j&&i!=k&&i!=m&&i!=n &&j!=k&&j!=m&&j!=n &&k!=m&&k!=n&&m!=n){
                                sum=score[0][i]+score[1][j]+score[2][k]+score[3][m]+score[4][n];
                                max= Math.max(sum, max);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}
