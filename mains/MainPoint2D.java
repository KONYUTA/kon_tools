/**
 * MainPoint2D
 *
 * csv_jikoの各座標に対して、csv_pointの座標の地物が半径d[m]の中にあるかを確認する。
 * MainPointとの違いは、外部サーバーとのやり取りをせずに行うことで、手順を簡略化している。
 * 計算方法は"manuals/計算方法/平面直角座標への換算_計算式.pdf"を確認
 *
 * 最後の代入にキャスト演算子を使っており。1/10000000[m]レベルの誤差が発生する。
 * 今回は100mや500mあたりの計算を行うため特に問題ないと考える。
 *
 */
package mains;
//
import kon.coord.*;
import kon.lib.*;
import java.lang.Math;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Desktop;
import java.net.URI;
import java.io.InputStreamReader;
//
public class MainPoint2D extends MainPoint{
    public static void main(String[] args){
        // String csv_point = "data/coord/csv/iryoukikaxn.csv";
        String csv_jiko = "data/coord/csv/jinshin_zahyou.csv";
        // Coord point = new Coord(csv_point);
        Coord jiko = new Coord(csv_jiko);
        // point.readData();
        jiko.readData();

        //基準点
        double lambda_0 = 136;
        double phi_0 = 35;

        //以下準備と計算
        double a = 6377397.155;//地球の長径
        double F = 299.152813;//地球の扁平率
        double m0 = 0.9999;//平面直角ざひょうけいのX軸における縮尺係数
        double rho = 180*Math.PI;//緯度をラジアンに変換する量。秒単位の場合は3600を、分単位の場合は60をかける。

        double n = 1/(2*F-1);
        double[] A = new double[6];
        A[0] = 1 + (Math.pow(n,2))/4 + (Math.pow(n,4))/64;
        A[1] = -3*(n - Math.pow(n,3)/8 - Math.pow(n, 5)/64)/2;
        A[2] = 15*(Math.pow(n,2) - Math.pow(n, 4)/4)/16;
        A[3] = -35*(Math.pow(n,3) - 5*Math.pow(n, 5)/16)/48;
        A[4] = 315*Math.pow(n,4)/512;
        A[5] = -693*Math.pow(n,4)/1280;
        double Abar = (m0*a*A[0])/(1+n);
        double t = Math.sinh(Math2.atanh(Math.sin(lambda_0)) - (2*(Math.sqrt(n))/(1+n))*Math2.atanh(((2*Math.sqrt(n))/(1+n))*Math.sin(lambda_0)));
        double tbar = Math.sqrt(1+Math.pow(t,2));
        double alpha[] = new double[5];
        alpha[0] = n/2 - (2/3)*Math.pow(n,2) + (5/16)*Math.pow(n,3) + (41/180)*Math.pow(n,4) - (127/288)*Math.pow(n,5);
        alpha[1] = (13/48)*Math.pow(n,2) - (3/5)*Math.pow(n,3) + (557/1440)*Math.pow(n,4) + (281/630)*Math.pow(n,5);
        alpha[2] = (61/240)*Math.pow(n,3) - (103/140)*Math.pow(n,4) + (15061/26880)*Math.pow(n,5);
        alpha[3] = (49561/161280)*Math.pow(n,4) - (179/168)*Math.pow(n,5);
        alpha[4] = (34729/80640)*Math.pow(n,5);
        double Sbar_phi_0 = m0*a*(A[0]*phi_0/rho)/(1+n);
        for(int i=0; i<6; i++){
            Sbar_phi_0 += m0*a*(A[i]*Math.sin(2*i*phi_0))/(1+n);
        }

        for(int i=0; i<jiko.coords.size(); i++){
            double lambda_c = Math.cos(jiko.coords.get(i)[0]-lambda_0);
            double lambda_s = Math.sin(jiko.coords.get(i)[0]-lambda_0);
            double xi = Math.atan(t/lambda_c);
            double eta = Math2.atanh(lambda_s/tbar);
            //xの計算
            double x = Abar*xi - Sbar_phi_0;
            for(int j=0; j<5; j++){
                x += Abar * alpha[j] * Math.sin(2*j*xi) * Math.cosh(2*j*eta);
            }
            //yの計算
            double y;
            //計算結果の代入
            // float[] xy = {(float)x,(float)y};
            float[]xy = {(float)x, 1f};
            jiko.coords.set(i,xy);
            Debug.show(jiko.coords.get(i));
        }
    }
    // public void convert_xy(Coord input_coord){
    //     input_coord.coords.set()
    // }

}
