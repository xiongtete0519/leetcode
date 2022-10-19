package LanQiaoBei;

//卡片
public class Card {
    public static void main(String[] args) {
        int[] arr=new int[10];
        //每个元素都赋值2021，代表2021张卡片
        for (int i = 0; i < 10; i++) {
            arr[i]=2021;
        }
        for (int i = 1; i <Integer.MAX_VALUE ; i++) {
            String str = String.valueOf(i);
            char[] chars = str.toCharArray();
            for (char s : chars) {
                int j = Integer.parseInt(String.valueOf(s));
                if(arr[j]>0){   //对应卡片数量减1
                    arr[j]-=1;
                }else{
                    //最后依次不够减需要删去
                    System.out.println(i-1);
                    return;
                }
            }
        }

    }
}
