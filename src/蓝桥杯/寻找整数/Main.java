package 蓝桥杯.寻找整数;

public class Main {
    public static void main(String[] args) {
        //下标为a,n mod a
        int[] mod={
                0,0,1,2,1,4,5,4,1,2,9,0,5,10,
                11,14,9,0,11,18,9,11,11,15,17,9,
                23,20,25,16,29,27,25,11,17,4,29,22,
                37,23,9,1,11,11,33,29,15,5,41,46
        };
        for (long i = 2022040920220408L; i < Long.MAX_VALUE; i++) {
            if(modNum(mod,i)!=-1){
                System.out.println(i);
                break;
            }
        }

    }
    //找到符合取模结果的数字
    public static long modNum(int[] mod,long number){
        for (int i = 2; i <=49 ; i++) {
            if(!(number%i==mod[i])) {
                return -1;
            }
        }
        return number;
    }
}
