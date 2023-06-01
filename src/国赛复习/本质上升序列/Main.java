package 国赛复习.本质上升序列;

import java.util.Arrays;

/**
 * dp[i]表示以str[i]结尾的本质不同递增子序列的个数，我们考虑j<i的情况，j=0~i-1
 * 当str[i]>str[j],dp[i]=dp[i]+d[j]
 * 当str[i]==str[j],dp[i]=dp[i]-dp[j]
 * 当str[i]<str[j]，这是倒序，不满足条件
 */
public class Main {
    public static void main(String[] args) {
        String str ="tocyjkdzcieoiodfpbgcncsrjbhmugdnojjddhllnofawllbhfiadgdcdjstemphmnjihecoapdjjrprrqnhgccevdarufmliqijgihhfgdcmxvicfauachlifhafpdccfseflcdgjncadfclvfmadvrnaaahahndsikzssoywakgnfjjaihtniptwoulxbaeqkqhfwl";
        int[] dp=new int[str.length()];
        //由于单个字符也算递增序列，所以dp初始化为1
        Arrays.fill(dp,1);
        for (int i = 0; i <str.length() ; i++) {
            for (int j = 0; j <i; j++) {
                if(str.charAt(i)>str.charAt(j)){
                    dp[i]+=dp[j];
                }
                if(str.charAt(i)==str.charAt(j)){
                    dp[i]-=dp[j];
                }
            }
        }
        System.out.println(Arrays.stream(dp).sum());
    }
}
