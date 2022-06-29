import coord.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Desktop;
import java.net.URI;
import java.io.InputStreamReader;

public class MainPolygon extends Main{
    public static void main(String[] args){
        String jiko_file = "data/csv/jinshin_zahyou.csv";
        String point_file = "data/csv/jinshin_did1.csv";
        calcResult(jiko_file, point_file, "data/result/jinshixn_did.txt", 0.000001f);
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