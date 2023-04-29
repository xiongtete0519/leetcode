package 十三届蓝桥杯国赛.最大公约数;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test1 {
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static int N = 100010;
    static Node[] tr = new Node[N * 4];
    static int[] a = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = 0;
        for (int i = 1; i <= n; ++i) {
            a[i] = sc.nextInt();
            if (a[i] == 1) f++;
        }
        if (f != 0) {
            out.println(n - f);
            out.flush();
            return;
        }
        build(1, 1, n);
        if (query(1, 1, n) != 1) {//无解
            out.println(-1);
            out.flush();
            return;
        }
        int ans = 0x3f3f3f3f;
        for (int i = 1; i <= n; ++i) {  //枚举左端点
            int l = i + 1, r = n + 1;
            while (l < r) { //二分枚举
                int mid = l + r >> 1;
                if (query(1, i, mid) == 1) r = mid;
                else l = mid + 1;
            }
            if (query(1, i, r) == 1) ans = Math.min(ans, r - i);
        }
        out.println(n - 1 + ans);
        out.flush();
    }

    static int gcd(int a,int b){
        return b == 0 ? a:gcd(b,a%b);
    }

    static void pushup(int u) {
        tr[u].g = gcd(tr[u << 1].g, tr[u << 1 | 1].g);
    }

    static void build(int u, int l, int r) {
        if (l == r) tr[u] = new Node(l, r, a[r]);
        else {
            tr[u] = new Node(l, r, 0);
            int mid = l + r >> 1;
            build(u << 1, l, mid);
            build(u << 1 | 1, mid + 1, r);
            pushup(u);
        }
    }

    static int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) return tr[u].g;
        int mid = tr[u].l + tr[u].r >> 1;
        if (r <= mid) return query(u << 1, l, r);
        else if (l > mid) return query(u << 1 | 1, l, r);
        else return gcd(query(u << 1, l, r), query(u << 1 | 1, l, r));
    }

    static class Node {
        int l, r, g;

        public Node(int l, int r, int g) {
            this.l = l;
            this.r = r;
            this.g = g;
        }
    }
}