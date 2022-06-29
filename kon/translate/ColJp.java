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

public class ColJp extends Col{

    public ArrayList<String> coords = new ArrayList<String>();

    public ColJp(String file_path){
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

            while((data=bufferdreader.readLine())!=null){
                String[] num = data.split(",");
                this.coords.add(num[index]);
            }
            bufferdreader.close();
        } catch(IOException e){e.printStackTrace();}
    }
    public void show(){
        for(String col:this.coords){
            System.out.println(col);
        }
    }
    public void write(String writeFileName){
        try{
            FileWriter shougaku_out = new FileWriter(writeFileName);
            PrintWriter shougaku_out_write = new PrintWriter(new BufferedWriter(shougaku_out));

            for(String jp:this.coords){
                shougaku_out_write.println(jp);
            }
            shougaku_out_write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
}


