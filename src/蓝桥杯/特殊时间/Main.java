package 蓝桥杯.特殊时间;

public class Main {
    public static void main(String[] args) {
          /*
          年    月  日  时间
        0111  10  11  11 10  4*4*4 +4*1*4+4*1*4+4* 3 *4+4*1*4+4*1*3+4*1*3+ 4*1*2+4*1*2+4 *1*2+4 *1 *2
        0222  02  22  20 22  4*1*4
        1222  12  22  12 22   4*1*4

        2111  11  12  21 11  4* 3 *4

        3111  11  13  13  11  4*1*3
        4111  11  14  11  14  4*1*3
        5111  11  15  11  15  4*1*3

        6111  11  16  11 16  4*1*2
        7111  11  17  11 17  4*1*2
        8111   11  18  11  18 4 *1*2
        9111  11  19   11  19 4 *1 *2
*/
        System.out.println(4*4*4 +4*1*4+4*1*4+4*3*4+4*1*3+4*1*3+4*1*3+ 4*1*2+4*1*2+4*1*2+4*1*2);
    }
}
