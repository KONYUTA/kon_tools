// 事故現場の周辺に対象のポイントが存在するかを検証する。
// コードを手直しする際は、複製したファイルを編集する、あるいは新しい継承クラスを作って編集するメソッドをオーバーライドすること。
// 作成者: こん

import kon.coord.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Desktop;
import java.net.URI;
import java.io.InputStreamReader;

public class MainPoint{
    public static void main(String[] args){

        //入出力ファイルの設定。----------------------- //
        String csv = "data/csv/iryoukikaxn.csv";
        String in1 = "data/in/iryoukikaxn.in";
        String in2 = "data/in/iryoukikaxn.in";
        //------------------------------------------//

        String wait;
        java.util.Scanner sc = new java.util.Scanner(System.in);


        {//1. ジオイド高を求めるために最初に実行する。ヘッダ行が0,0となることがあるが、ジオイド高計算では0,0が無効なため#をつけて対応
            makeGeoidIn(csv,in1, false);
            toDMS(in1, in2);
            openURL("https://vldb.gsi.go.jp/sokuchi/surveycalc/geoid/calcgh/calc_f.html");//in2をアップロードして計算
        }
        wait = sc.nextLine();

        {//2. 標高を求めるために実行。元の座標データを使う。国土地理院標高APIの制約により時間がかかる(詳しくは下記[https://github.com/gsi-cyberjapan/gsimaps/issues/31])。出力結果はターミナルに表示するためExcelを使って追加する。実行結果をテキスト形式で保存すると楽。
            calcHeight(csv);
        }
        wait = sc.nextLine();

        {//3. 直角座標を求めるために実行。
            openURL("https://vldb.gsi.go.jp/sokuchi/surveycalc/surveycalc/transf.html");
        }
        wait = sc.nextLine();

        {//4. 結果を出力するために実行。
            //calcResult(String 事故現場のXYZ座標ファイル, String 対象施設のポイントのファイル, String 結果のファイル, float 円の半径)
            String jiko_file = "data/xyz/bussoxn.out";
            String point_file = "data/xyz/tyuugaku_height.out";
            calcResult(jiko_file, point_file, "data/result/bussoxn_tyuugaku_100.txt", 100f);
            calcResult(jiko_file, point_file, "data/result/bussoxn_tyuugaku_500.txt", 500f);
            calcResult(jiko_file, point_file, "data/result/bussoxn_tyuugaku_1000.txt", 1000f);
        }
    }

    static void makeGeoidIn(String input_file, String output_file, boolean reverse){
        //スペース区切り(緯度 経度)の形に整形
        //入力ファイルの形式としては数値で緯度, 経度を含むコンマ区切りテキスト(CSV)形式
        //数値は緯度経度のみとする。他は数値以外に
        //第三引数は、入力ファイルで緯度が先の場合はfalse, 経度が先の場合はtrueにする
        Coord coord = new Coord(input_file);
        coord.readData();
        coord.write(output_file, reverse);
    }

    static void toDMS(String input_file, String output_file){
        //１０進数緯度経度を12進数緯度経度に変換。
        //またその際10000倍にして返す。国土地理院の計算サイトで指定の入力に合わせるため
        try{
            Coord jiko = new Coord(input_file);
            jiko.readDataSpace();
            jiko.show();
            FileWriter jiko_out = new FileWriter(output_file);
            PrintWriter jiko_out_write = new PrintWriter(new BufferedWriter(jiko_out));
            for(float[] xy:jiko.coords){
                jiko_out_write.println(toDMS(xy[0])+" "+toDMS(xy[1]));
            }
            jiko_out_write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static double toDMS(float input_f){
        double deg = input_f;
        double degree = (int)deg;
        double minute = (int)((deg-degree)*60);
        double second = ((deg-degree)*60-minute)*60;
        double dms = degree*10000 + minute*100 + second;
        return dms;
    }

    static void openURL(String url){
        String uriString = url;
        Desktop desktop = Desktop.getDesktop();
        try{
            URI uri = new URI( uriString );
            desktop.browse( uri );
        }catch( Exception e ){
            e.printStackTrace();
        }
    }

    static void calcHeight(String input_file){
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("python3", "calc_height.py", input_file);

        try{
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine())!=null){
                System.out.println(line);
            }
        } catch(IOException e){System.out.println(e);}
    }

    static void calcResult(String jiko_file, String point_file, String output_file, float d){
        Coord shougaku = new CoordXYZ(point_file);
        Coord jiko = new CoordXYZ(jiko_file);

        shougaku.readData();
        jiko.readData();

        // shougaku.show();

        boolean[] result = jiko.isCloseAll(shougaku.coords, d);
        try{
            FileWriter result_out = new FileWriter(output_file);
            PrintWriter result_out_write = new PrintWriter(new BufferedWriter(result_out));

            for(boolean r:result){
                if(r){
                    result_out_write.println(1);
                }
                else{
                    result_out_write.println(0);
                }
            }
            result_out_write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
