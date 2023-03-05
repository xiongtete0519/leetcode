package study.全排列;
//邻里交换法
public class Demo2 {
    static int count=0;
    static int[] a={1,2,3,4,5,6,7,8,9};

    public static void main(String[] args) {
        f(a,0);
        System.out.println(count/6);
    }

    public static void f(int[] a,int step){
        if(step==a.length-1){//step==8
            if(a[0]+a[1]+a[2]+a[3]==a[3]+a[4]+a[5]+a[6]&&
                    a[0]+a[1]+a[2]+a[3]==a[6]+a[7]+a[8]+a[0]){
                count++;
            }
            return;
        }

        for (int i = 0; i < a.length; i++) {
            //代码块包裹一下 方便理解
            {
                int x=a[i]; //交换
                a[i]=a[step];
                a[step]=x;
            }

            f(a,step+1);//递归确定下一位

            {
                int x=a[i]; //还原
                a[i]=a[step];
                a[step]=x;
            }
        }


    }
}
