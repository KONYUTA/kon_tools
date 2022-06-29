import java.util.*;
public class Test2 {
    public static void main(String[] args) {
        int[][] A = {{2, 8}, {2, 3}, {1, 5}, {5, 9}};
        Data[] d = new Data[4];
        for (int i = 0; i < 4; i++) {
            d[i] = new Data(A[i][0], A[i][1]);
        }
        Arrays.sort(d, new MyComparator());
        for (int i = 0; i < 4; i++) {
            System.out.printf("%d %d\n", d[i].a, d[i].b);
        }
    }
    public static class Data  {
        int a, b;
        public Data(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    // Comparator インターフェースを実装する
    public static class MyComparator implements Comparator<Data> {
        public int compare(Data d1, Data d2) {
            if (d1.a == d2.a) {
                return d1.b - d2.a;
            } else {
                return d1.a - d2.a;
            }
        }
    }
}