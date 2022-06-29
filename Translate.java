

import java.io.IOException;
import java.io.File;

import kon.translate.*;

public class Translate{
    public static void main(String[] args){
        String dir_path = "data/translate/taiou_hyou";
        String csv_path = "data/translate/jinshin_number.csv";
        String result_path = "data/translate/result";
        File dir = new File(dir_path);
        File[] files = dir.listFiles();

        for(File f:files){
            try{
                int col_index = Integer.parseInt(f.getName());
                Col col = new Col(csv_path);
                col.readData(col_index-1);
                Table table = new Table(dir_path+"/"+col_index);
                table.readDataTab();
                ColJp col2 = translation(col, table);
                col2.write(result_path+"/"+col_index+".txt");
            }catch(NumberFormatException e){System.out.println("対応表ファイル名は数字名のみ。拡張子なし");}
        }
    }

    private static ColJp translation(Col col, Table table){
        ColJp coljp = new ColJp("");
        int index;
        for(int i:col.coords){
            index = table.key.indexOf(i);
            try{
                String jp = table.coords.get(index);
                coljp.coords.add(jp);

            } catch(IndexOutOfBoundsException e){
                System.out.println(i);
                coljp.coords.add("対応表に該当なし");
            }
        }
        return coljp;
    }
}
