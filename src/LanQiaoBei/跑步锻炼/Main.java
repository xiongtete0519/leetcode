package LanQiaoBei.跑步锻炼;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Calendar startC = Calendar.getInstance();
        Calendar endC = Calendar.getInstance();
        startC.set(2000,Calendar.JANUARY,1);
        endC.set(2020,Calendar.OCTOBER,1);
        int num=0;
        while (true){
            int week = startC.get(Calendar.DAY_OF_WEEK) - 1;
            int day = startC.get(Calendar.DAY_OF_MONTH);
            if(week==1||day==1){
                num+=2;
            }else{
                num+=1;
            }
            if(startC.get(Calendar.YEAR)==2020&&startC.get(Calendar.MONTH)==Calendar.OCTOBER
            &&startC.get(Calendar.DATE)==1){
                break;
            }
            startC.add(Calendar.DATE,1);
        }
        System.out.println(num);
    }
}
