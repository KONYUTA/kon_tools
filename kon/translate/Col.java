package kon.translate;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import kon.coord.*;

public class Col extends Coord{
    public ArrayList<Integer> coords;
    public Col(String file_path){
        super(file_path);
    }

    public void readData(int index){
        try{
            File file = new File(this.fileName);
            if(!file.exists()){
                System.out.println("ファイルが存在しません。");
                return;
            }

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferdreader = new BufferedReader(fileReader);
            String data;
            this.coords = new ArrayList<Integer>();

            while((data=bufferdreader.readLine())!=null){
                String[] num = data.split(",");
                try{
                    int coord = Integer.parseInt(num[index]);
                    this.coords.add(coord);
                } catch(NumberFormatException e){System.out.println("数値以外が検出されました。");}
            }
            bufferdreader.close();
        } catch(IOException e){e.printStackTrace();}
    }
    public void show(){
        for(int col:this.coords){
            System.out.println(col);
        }
    }
}
