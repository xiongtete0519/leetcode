package LanQiaoBei.超级质数;

public class Main {

    public static boolean isPrime(int num){
        if (num==1)
            return false;
        for (int i = 2; i <=Math.sqrt(num); i++) {
            if(num%i==0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int max=53;
        for (int i = max; i <Math.sqrt(Integer.MAX_VALUE); i++) {
            boolean flag=false;
            String s = String.valueOf(i);
            if(!isPrime(i)){    //不是质数的结束本次循环
                continue;
            }
            for (int j = 0; j < s.length(); j++) {
                for (int k =j; k < s.length(); k++) {
                    if(k+1<=s.length()){
                        int temp=Integer.parseInt(s.substring(j,k+1));
                        if(isPrime(temp)){
                            flag=true;
                        }else{
                            flag=false; //只要有一个不满足条件，跳出最内层循环
                            break;
                        }
                    }
                }
                if(!flag){    //跳出第二层循环
                    break;
                }
            }
            if(flag){
                max=Math.max(max,i);
            }
        }
        System.out.println(max);
    }
}
