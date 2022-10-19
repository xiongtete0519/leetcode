package LanQiaoBei;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal(100);
        System.out.println(bigDecimal.divide(new BigDecimal(3),3,BigDecimal.ROUND_HALF_UP));
    }
}
