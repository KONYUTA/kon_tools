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
        String csv = "data/csv/iryoukikaxn.csv";
        String in1 = "data/in/iryoukikaxn.in";

        //基準点
        double x0 = 136;
        double y0 = 35;

        //地球の長径並びに逆扁平率
        double a = 6377397.155;
        double F = 299.152813;

        //平面直角ざひょうけいのX軸における縮尺係数
        double m0 = 0.9999;

        //以下計算
        double n = 1/(2*F-1);
        double A0 = 1 + (n^2)/4 + (n^4)/64;
        double Abar = (m0*a*A0)/(1+n);

        double t = Math.sinh(Math2.atanh(Math.sin(x0)) - (2*(n^0.5)/(1+n))*Math2.atanh(

}
