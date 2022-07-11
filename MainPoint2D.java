//デバッグ用
//Debug.show(デバッグ対象の変数);
//対象はint, float, double, String, boolean, short, long, byte, charのいずれか

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

        double n = 1/(2*F-1);
        double A0 = 1 + (Math.pow(n,2))/4 + (Math.pow(n,4))/64;
        double Abar = (m0*a*A0)/(1+n);
        double t = Math.sinh(Math2.atanh(Math.sin(lambda_0)) - (2*(Math.sqrt(n))/(1+n))*Math2.atanh(((2*Math.sqrt(n))/(1+n))*Math.sin(lambda_0)));
        double tbar = Math.sqrt(1+Math.pow(t,2));
        double alpha[] = new double[5];
        alpha[0] = n/2 - (2/3)*Math.pow(n,2) + (5/16)*Math.pow(n,3) + (41/180)*Math.pow(n,4) - (127/288)*Math.pow(n,5);
        alpha[1] = (13/48)*Math.pow(n,2) - (3/5)*Math.pow(n,3) + (557/1440)*Math.pow(n,4) + (281/630)*Math.pow(n,5);
        alpha[2] = (61/240)*Math.pow(n,3) - (103/140)*Math.pow(n,4) + (15061/26880)*Math.pow(n,5);
        alpha[3] = (49561/161280)*Math.pow(n,4) - (179/168)*Math.pow(n,5);
        alpha[4] = (34729/80640)*Math.pow(n,5);

        for(int i=0; i<jiko.coords.size(); i++){
            double lambda_c = Math.cos(jiko.coords.get(i)[0]-lambda_0);
            double lambda_s = Math.sin(jiko.coords.get(i)[0]-lambda_0);
            double xi = Math.atan(t/lambda_c);
            double eta = Math2.atanh(lambda_s/tbar);
            double x = Abar*xi;
            for(int j=0; j<5; j++){
                x += Abar * alpha[j] * Math.sin(2*j*xi) * Math.cosh(2*j*eta);
            }
            float[] ab = {(float)x,2};
            jiko.coords.set(i,ab);
            Debug.show(jiko.coords.get(i));
        }
    }
    // public void convert_xy(Coord input_coord){
    //     input_coord.coords.set()
    // }

}
