package 十二届Java研究生组.直线;

import java.util.*;

public class Main {
    public static int[] x=new int[20];
    public static int[] y=new int[21];
    public static void main(String[] args) {
        for (int i = 0; i <20 ; i++) {
            x[i]=i;
        }
        for (int i = 0; i <21 ; i++) {
            y[i]=i;
        }
        ArrayList<Point> points = new ArrayList<>();//坐标点
        HashSet<Map<Double, Double>> lines = new HashSet<>();//直线：记录斜率和截距

        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                points.add(new Point(x[i],y[j]));
            }
        }
        //两点确定一条直线
        for (int i = 0; i < points.size(); i++) {
            for (int j = i+1; j <points.size(); j++) {
                Point line = points.get(i);   //第一个坐标
                Point line1 = points.get(j);  //第二个坐标
                int x1 = line.getX();
                int y1 = line.getY();
                int x2 = line1.getX();
                int y2 = line1.getY();
                if(x1==x2||y1==y2){
                    continue;
                }
                //这里通过斜率和截距确定一条直线
                //计算直线斜率值:k=(y2-y1)/(x2-x1) 斜率相同只能证明平行
                double k = ((y1-y2) * 1.0)/(x1-x2);
                //计算截距
                double b = (x2 * y1 - x1 * y2) * 1.0 / (x2 - x1);
                HashMap<Double, Double> map = new HashMap<>();
                map.put(k,b);
                lines.add(map);
            }
        }
        System.out.println(lines.size()+20+21);
    }
}
class Point{ //坐标类
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
