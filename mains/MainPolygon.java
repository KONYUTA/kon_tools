/**
 * MainPolygon
 *
 * 地物の一致判定プログラム。対象の地物がポリゴンに含まれるかの判定に使う。
 * jiko_fileの座標データに対して、point_fileにも含まれていれば1を、jiko_fileにしかない座標なら0を出力し、result_fileに保存する。
 * 入力ファイルは以下のように設定。
 * 1. jiko_file:
 *      [概要]
 *          人身事故または物損事故の全ての座標データ。
 *          形式はコンマ区切りで緯度,経度の順。各事故は改行で区切る。
 *      [入力ファイルの例]
 *          36.76135,137.01894
 *          36.74742,136.99463
 *          36.736626,137.02034
 *          36.751663,137.0208
 *          .
 *
 * 2. point_file:
 *      [概要]
 *          人身事故または物損事故のうち、ポリゴンに含まれる地物の座標データ。QGIS等のソフトウェアを用いて作成。
 *          形式はコンマ区切りで緯度,経度の順。各事故は改行で区切る。
 *      [入力ファイルの例]
 *          36.76135,137.01894
 *          36.751663,137.0208
 *          36.72245,136.98466
 *          36.75356,137.04024
 *
 * 1. result_file:
 *      [概要]
 *          jiko_fileの座標データのうち、point_fileに含まれるものは1を、そうでなければ0を出力する。
 *          今回の入力例だと、jiko_fileの1行目と4行目がpoint_fileの1行目と2行目に一致しているため1行目と4行目は1を出力し、2行目および３行目はpoint_fileのどの座標データにも一致しないので0を出力する。
 *      [出力ファイルの例]
 *          1
 *          0
 *          0
 *          1
 */
package mains;
//
import coord.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Desktop;
import java.net.URI;
import java.io.InputStreamReader;
//
public class MainPolygon extends Main{
    public static void main(String[] args){
        String jiko_file = "data/csv/jinshin_zahyou.csv";
        String point_file = "data/csv/jinshin_did1.csv";
        String result_file = "data/result/jinshixn_did.txt";
        calcResult(jiko_file, point_file, result_file, 0.000001f);
    }

    static void calcResult(String jiko_file, String point_file, String output_file, float d){
        Coord shougaku = new Coord(point_file);
        Coord jiko = new Coord(jiko_file);

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