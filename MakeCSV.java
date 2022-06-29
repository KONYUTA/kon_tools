//入力ファイルについて------------------
//input_dir内のファイル名は数字.txt
//ただし、数字が一桁の場合は0先頭に0を入れないと列番号が崩れる。テスト段階で気づいたけどソートアルゴリズムを作る気力がなかった。
//例：08.txt
//ファイルの中身はタブ区切りでn行2列

import kon.translate.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.lang.StringBuilder;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class MakeCSV{
    public static void main(String[] args){
        String dir_name = "data/translate/result";
        File input_dir = new File(dir_name);
        String output_file = "data/translate/jinshin_JP.txt";

        File[] input_files = input_dir.listFiles();
        ArrayList<ColJp> cols = new ArrayList<ColJp>();

        Arrays.sort(input_files);
        for(File f:input_files){
            if(f.getName().equals(".DS_Store")){continue;}
            ColJp col = new ColJp(dir_name+"/"+f.getName());
            col.readData(0);
            cols.add(col);
        }
        try{
            FileWriter out = new FileWriter(output_file);
            BufferedWriter out_buffer = new BufferedWriter(out);
            PrintWriter out_print = new PrintWriter(out_buffer);
            for(int i=0; i<cols.get(0).coords.size(); i++){
                StringBuilder row = new StringBuilder();
                for(ColJp col:cols){
                    row.append(col.coords.get(i)+",");
                }
                row.setLength(row.length()-1);
                // System.out.println(row);
                out_print.println(row);
            }
            out_print.close();
        } catch(IOException e){;}
    }
}