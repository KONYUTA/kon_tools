package kon.translate;

import kon.coord.*;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Table extends Coord{
    public ArrayList<Integer> key;
    public ArrayList<String> coords;
    public Table(String file_path){
        super(file_path);
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
            this.coords = new ArrayList<String>();
            this.key = new ArrayList<Integer>();

            while ((data = bufferedReader.readLine()) != null) {
                String[] nums = data.split(",");
                try{
                    this.key.add(Integer.parseInt(nums[0]));
                }catch(NumberFormatException e){System.out.println("数値以外を検知しました。");}
                this.coords.add(nums[1]);
            }
            bufferedReader.close();
        } catch (IOException e){e.printStackTrace();}
    }

    public void readDataTab() {
        try {
            File file = new File(this.fileName);
            if (!file.exists()) {
                System.out.print("ファイルが存在しません");
                return;
            }

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data;
            this.coords = new ArrayList<String>();
            this.key = new ArrayList<Integer>();

            while ((data = bufferedReader.readLine()) != null) {
                String[] nums = data.split("\t");
                try{
                    this.key.add(Integer.parseInt(nums[0]));
                }catch(NumberFormatException e){System.out.println("数値以外を検知しました。");}
                this.coords.add(nums[1]);
            }
            bufferedReader.close();
        } catch (IOException e){e.printStackTrace();}
    }
    public void show(){
        for(String coord:this.coords){
            System.out.println(coord);
        }
    }

    public void showkey(){
        for(int i:this.key){
            System.out.println(i);
        }
    }

}
