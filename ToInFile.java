import kon.coord.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ToInFile{

    public static void main(String[] args){
        try{
//            Coord shougaku = new Coord("data/shougakkou.txt");
            Coord jiko = new Coord("data/csv/bussoxn_zahyou.csv");

//            Coord jiko = new Coord("data/csv/jinshin_zahyou.csv");
//            shougaku.readDataSpace();
            jiko.readData();
            jiko.show();

//            FileWriter shougaku_out = new FileWriter("data/xyz/shougaku.in");
            FileWriter jiko_out = new FileWriter("data/xyz/jiko_bussoxn.in");
//            PrintWriter shougaku_out_write = new PrintWriter(new BufferedWriter(shougaku_out));
            PrintWriter jiko_out_write = new PrintWriter(new BufferedWriter(jiko_out));


//            for(float[] xy:shougaku.coords){
//                shougaku_out_write.println(toDMS(xy[1])+" "+toDMS(xy[0]));
//            }

            for(float[] xy:jiko.coords){
                jiko_out_write.println(toDMS(xy[0])+" "+toDMS(xy[1]));
            }

//            shougaku_out_write.close();
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
}
