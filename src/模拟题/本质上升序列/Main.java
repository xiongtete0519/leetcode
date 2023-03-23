package 模拟题.本质上升序列;

import java.util.Arrays;

//dp[i]表示以str[i]结尾的本质不同递增子序列的个数
//考虑j<i
//当str[j]<str[i],dp[i]=dp[i]+dp[j]
//当str[j]=str[i],dp[i]=dp[i]-dp[j]
//当str[j]>str[i],此时是降序，不考虑
public class Main {
    public static void main(String[] args) {
        String str = "tocyjkdzcieoiodfpbgcncsrjbhmugdnojjddhllnofawllbhf" +
                "iadgdcdjstemphmnjihecoapdjjrprrqnhgccevdarufmliqij" +
                "gihhfgdcmxvicfauachlifhafpdccfseflcdgjncadfclvfmad" +
                "vrnaaahahndsikzssoywakgnfjjaihtniptwoulxbaeqkqhfwl";
//        String str="213857";
//        String str="127837";
        int[] dp = new int[str.length()];
        //由于单个字符也算递增序列，所以dp初始化为1
        Arrays.fill(dp,1);
        for (int i = 0; i <str.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(str.charAt(i)>str.charAt(j)){
                    dp[i]+=dp[j];
                }else if(str.charAt(i)==str.charAt(j)){
                    dp[i]-=dp[j];
                }
            }
        }
        System.out.println(Arrays.stream(dp).sum());

    }
}
