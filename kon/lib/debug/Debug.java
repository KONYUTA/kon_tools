package kon.lib.debug;

import java.util.ArrayList;
import javax.swing.text.StyledEditorKit.BoldAction;

public class Debug{

    /*void show()
     * 入力値を出力してキーボード入力を待つ。
     * 入力は以下のものとその配列、またそれらのArrayListに限る。
     * int, byte, short, long, float, double, boolean, String, char, Object
     */
    public static void show(int x){
        System.out.print(new Object(){}.getClass().getEnclosingClass().getName());
        System.out.print("(デバッグ): ");
        System.out.println(x);
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(float x){
        System.out.print("(Debug): ");
        System.out.println(x);
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(double x){
        System.out.print(new Object(){}.getClass().getEnclosingClass().getName());
        System.out.print("(デバッグ): ");
        System.out.println(x);
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(String x){
        System.out.print("(Debug): ");
        System.out.println(x);
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(boolean x){
        System.out.print("(Debug): ");
        System.out.println(x);
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(byte x){
        System.out.print("(Debug): ");
        System.out.println(x);
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(char x){
        System.out.print("(Debug): ");
        System.out.println(x);
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(long x){
        System.out.print("(Debug): ");
        System.out.println(x);
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(short x){
        System.out.print("(Debug): ");
        System.out.println(x);
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(Object x){
        System.out.print("(Debug): ");
        System.out.println(x.toString());
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(int[] x){
        System.out.println("(Debug): ");
        for(int i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(float[] x){
        System.out.print(new Object(){}.getClass().getEnclosingClass().getName());
        System.out.print("(デバッグ): ");
        for(float i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(long[] x){
        System.out.println("(Debug): ");
        for(long i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(short[] x){
        System.out.println("(Debug): ");
        for(short i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }

    public static void show(double[] x){
        System.out.print(new Object(){}.getClass().getEnclosingClass().getName());
        System.out.print("(デバッグ): ");
        for(double i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(byte[] x){
        System.out.println("(Debug): ");
        for(byte i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(String[] x){
        System.out.println("(Debug): ");
        for(String i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(char[] x){
        System.out.println("(Debug): ");
        for(char i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(boolean[] x){
        System.out.println("(Debug): ");
        for(boolean i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(Object[] x){
        System.out.println("(Debug): ");
        for(Object i:x){System.out.print(i.toString()+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(int[][] x){
        System.out.println("(Debug): ");
        for(int[] row:x){
            for(int col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(short[][] x){
        System.out.println("(Debug): ");
        for(short[] row:x){
            for(short col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(long[][] x){
        System.out.println("(Debug): ");
        for(long[] row:x){
            for(long col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(byte[][] x){
        System.out.println("(Debug): ");
        for(byte[] row:x){
            for(byte col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(boolean[][] x){
        System.out.println("(Debug): ");
        for(boolean[] row:x){
            for(boolean col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(float[][] x){
        System.out.println("(Debug): ");
        for(float[] row:x){
            for(float col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(double[][] x){
        System.out.println("(Debug): ");
        for(double[] row:x){
            for(double col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(String[][] x){
        System.out.println("(Debug): ");
        for(String[] row:x){
            for(String col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(char[][] x){
        System.out.println("(Debug): ");
        for(char[] row:x){
            for(char col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(Object[][] x){
        System.out.println("(Debug): ");
        for(Object[] row:x){
            for(Object col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<Integer> x){
        System.out.println("(Debug): ");
        for(int i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<Byte> x){
        System.out.println("(Debug): ");
        for(byte i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<Short> x){
        System.out.println("(Debug): ");
        for(short i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<Long> x){
        System.out.println("(Debug): ");
        for(long i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<Character> x){
        System.out.println("(Debug): ");
        for(char i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<Float> x){
        System.out.println("(Debug): ");
        for(float i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<Double> x){
        System.out.println("(Debug): ");
        for(double i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<Boolean> x){
        System.out.println("(Debug): ");
        for(boolean i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<String> x){
        System.out.println("(Debug): ");
        for(String i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<Object> x){
        System.out.println("(Debug): ");
        for(Object i:x){System.out.print(i+", ");}
        System.out.print("\n");
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<byte[]> x){
        System.out.println("(Debug): ");
        for(byte[] row:x){
            for(byte col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<int[]> x){
        System.out.println("(Debug): ");
        for(int[] row:x){
            for(int col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<short[]> x){
        System.out.println("(Debug): ");
        for(short[] row:x){
            for(short col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<long[]> x){
        System.out.println("(Debug): ");
        for(long[] row:x){
            for(long col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<char[]> x){
        System.out.println("(Debug): ");
        for(char[] row:x){
            for(char col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<float[]> x){
        System.out.println("(Debug): ");
        for(float[] row:x){
            for(float col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<double[]> x){
        System.out.println("(Debug): ");
        for(double[] row:x){
            for(double col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<boolean[]> x){
        System.out.println("(Debug): ");
        for(boolean[] row:x){
            for(boolean col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<String[]> x){
        System.out.println("(Debug): ");
        for(String[] row:x){
            for(String col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<Object[]> x){
        System.out.println("(Debug): ");
        for(Object[] row:x){
            for(Object col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<ArrayList<Short>> x){
        System.out.println("(Debug): ");
        for(ArrayList<Short> row:x){
            for(short col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<ArrayList<Byte>> x){
        System.out.println("(Debug): ");
        for(ArrayList<Byte> row:x){
            for(byte col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<ArrayList<Integer>> x){
        System.out.println("(Debug): ");
        for(ArrayList<Integer> row:x){
            for(int col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<ArrayList<Long>> x){
        System.out.println("(Debug): ");
        for(ArrayList<Long> row:x){
            for(long col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<ArrayList<Character>> x){
        System.out.println("(Debug): ");
        for(ArrayList<Character> row:x){
            for(char col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<ArrayList<String>> x){
        System.out.println("(Debug): ");
        for(ArrayList<String> row:x){
            for(String col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<ArrayList<Float>> x){
        System.out.println("(Debug): ");
        for(ArrayList<Float> row:x){
            for(float col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<ArrayList<Double>> x){
        System.out.println("(Debug): ");
        for(ArrayList<Double> row:x){
            for(double col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<ArrayList<Boolean>> x){
        System.out.println("(Debug): ");
        for(ArrayList<Boolean> row:x){
            for(boolean col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }
    public static void show(ArrayList<ArrayList<Object>> x){
        System.out.println("(Debug): ");
        for(ArrayList<Object> row:x){
            for(Object col:row){
                System.out.print(col+",");
            }
            System.out.print("\n");
        }
        String stop = new java.util.Scanner(System.in).nextLine();
    }



    /*void countRange()
     * ループ回数を表示して一時停止。
     * キーボード入力で再開。
     * 入力はint。
     */
    public static void countRange(int i){
        System.out.println("(Debug): ループ回数: "+i);
        String stop = new java.util.Scanner(System.in).nextLine();
    }
}