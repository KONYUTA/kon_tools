package mains;
import kon.coord.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.Desktop;
import java.net.URI;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;

public class DebugPolygon extends MainPoint{
    public static void main(String[] args){
        String coord_file = "data/coord/csv/jinshin_zahyou.csv";
        String result_file = "data/coord/result/jinshixn_did.txt";
        pointInPolygon(coord_file, result_file);
    }

    static void pointInPolygon(String jiko_file, String result_file){
        Coord jiko = new Coord(jiko_file);
        // System.out.println("test");
        Result result = new Result(result_file);
        // System.out.println("test");

        jiko.readData();
        result.readData();

        

        for(int i=0; i<result.getSize();i++){
            if(result.coords.get(i)==1){
                System.out.println(jiko.coords.get(i)[0] + "," + jiko.coords.get(i)[1]);
            }
        }
    }

    public static class Result extends Coord{
        ArrayList<Integer> coords;
        public Result(String input_file){
            super(input_file);
        }
        public void readData() {
            try {
                File file = new File(this.fileName);
                if (!file.exists()) {
                    System.out.print("ファイルが存在しません");
                    return;
                }

                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String data;
                this.coords = new ArrayList<Integer>();

                while ((data = bufferedReader.readLine()) != null) {
                    int bool = Integer.parseInt(data);
                    this.coords.add(bool);
                }
                bufferedReader.close();
            } catch (IOException e){e.printStackTrace();}
        }
        public int getSize(){
            return this.coords.size();
        }
    }
}
