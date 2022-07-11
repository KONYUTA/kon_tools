package kon.lib;

public class Debug{

    /*void show()
     * 入力値を出力してキーボード入力を待つ。
     * 入力は以下のものとその配列に限る。
     * int, byte, short, long, float, double, boolean, String, char
     */
    public static void show(int x){
        System.out.println(x);
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(float x){
        System.out.println(x);
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(double x){
        System.out.println(x);
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(String x){
        System.out.println(x);
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(boolean x){
        System.out.println(x);
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(byte x){
        System.out.println(x);
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(char x){
        System.out.println(x);
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(long x){
        System.out.println(x);
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(short x){
        System.out.println(x);
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(int[] x){
        for(int i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(float[] x){
        for(float i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(long[] x){
        for(long i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(short[] x){
        for(short i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }

    public static void show(double[] x){
        for(double i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(byte[] x){
        for(byte i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(String[] x){
        for(String i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(char[] x){
        for(char i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(boolean[] x){
        for(boolean i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
}