package 代码随想录.字符串.替换空格;
//剑指Offer 05:替换空格
public class Main {
    public static String replaceSpace(String s) {
        s=s.replaceAll("\\s","%20");
        return s;
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("We are happy."));
    }
}
