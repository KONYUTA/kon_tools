// 座標管理用
package kon.coord;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Coord{
    public ArrayList<float[]> coords;
    public String fileName;
    File file;

    public Coord(String filename){
        this.fileName = filename;
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
            this.coords = new ArrayList<float[]>();

            while ((data = bufferedReader.readLine()) != null) {
                String[] nums = data.split(",");
                float[] coord = new float[2];
                for (int i = 0, size = nums.length; i < size; i++) {
                    try{
                        coord[i] = Float.parseFloat(nums[i]);
                    } catch(NumberFormatException e){System.out.println("数値以外が検出されました。");}
                }
                this.coords.add(coord);
            }
            bufferedReader.close();
        } catch (IOException e){e.printStackTrace();}
    }
    public void readDataSpace() {
        try {
            File file = new File(this.fileName);
            if (!file.exists()) {
                System.out.print("ファイルが存在しません");
                return;
            }

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data;
            this.coords = new ArrayList<float[]>();

            while ((data = bufferedReader.readLine()) != null) {
                String[] nums = data.split(" ");
                float[] coord = new float[2];
                for (int i = 0, size = nums.length; i < size; i++) {
                    try{
                        coord[i] = Float.parseFloat(nums[i]);
                    } catch(NumberFormatException e){System.out.println("数値以外が検出されました。");}
                }
                this.coords.add(coord);
            }
            bufferedReader.close();
        } catch (IOException e){e.printStackTrace();}
    }



    public boolean[] isCloseAll(ArrayList<float[]> input_coords, float d){
        boolean[] result = new boolean[this.coords.size()];
        int i = 0;
        for(float[] xy:this.coords){
            for(float[] xy_in:input_coords){
                boolean r = isInCircle(xy, xy_in, d);
                if(r){
                    // System.out.println(i);//デバッグ：インデックス表示用
                    result[i] = true;
                    break;
                }
            }
            i++;
        }
        return result;
    }

    public boolean[] isClose(ArrayList<float[]> input_coords, float d){
        boolean[] result = new boolean[this.coords.size()];
        int i = 0;
        for(float[] xy:this.coords){
            for(float[] xy_in:input_coords){
                if(isInCircle(xy, xy_in, d)){
                    result[i] = true;
                    break;
                }
            }
            i++;
        }
        return result;
    }

    //第一引数の座標を中心として第三引数を半径としたとき、第二引数は円の中にあるか。(double)
    static boolean isInCircle(float[] center, float[] dot, float r){
        double derection=(((double)center[0]-(double)dot[0])*((double)center[0]-(double)dot[0])+((double)center[1]-(double)dot[1])*((double)center[1]-(double)dot[1]));
        double diameter = r*r;
        if(derection < (double)diameter){
            return true;
        }
        else{
            return false;
        }
    }

    public void show(){
        for(float[] coord:this.coords){
            System.out.println(coord[0]+","+coord[1]);
        }
    }

    public void write(String writeFileName){
        try{
            FileWriter shougaku_out = new FileWriter(writeFileName);
            PrintWriter shougaku_out_write = new PrintWriter(new BufferedWriter(shougaku_out));

            for(float[] xy:this.coords){
                shougaku_out_write.println(xy[1]+" "+xy[0]);
            }
            shougaku_out_write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void write(String writeFileName, boolean reverse){
        try{
            FileWriter shougaku_out = new FileWriter(writeFileName);
            PrintWriter shougaku_out_write = new PrintWriter(new BufferedWriter(shougaku_out));

            if(reverse){
                for(float[] xy:this.coords){
                    shougaku_out_write.println(xy[0]+" "+xy[1]);
                }
            }
            else{
                for(float[] xy:this.coords){
                    shougaku_out_write.println(xy[1]+" "+xy[0]);
                }
            }
            shougaku_out_write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
