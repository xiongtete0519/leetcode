package LanQiaoBei;

import java.util.Calendar;

public class Running {
    public static void main(String[] args) {
        int num=0;
        Calendar c = Calendar.getInstance();
        c.set(2000,0,1);
        for (;;){
            if(c.get(Calendar.DAY_OF_WEEK)==2||c.get(Calendar.DAY_OF_MONTH)==1){
                num+=2;
            }else{
                num+=1;
            }
            if(c.get(Calendar.YEAR)==2020&&c.get(Calendar.MONTH)==9&&c.get(Calendar.DATE)==1)
                break;
            c.add(Calendar.DATE,1);
        }
        System.out.println(num);
    }
}
