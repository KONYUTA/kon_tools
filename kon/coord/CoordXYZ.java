package kon.coord;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// import java.io.File;
// import java.io.BufferedReader;
// import java.io.FileReader;

// import java.io.PrintWriter;
// import java.io.BufferedWriter;
// import java.io.FileWriter;

// import java.io.IOException;
// import java.util.ArrayList;

public class CoordXYZ extends Coord{

    public CoordXYZ(String filename){
        super(filename);
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
                String[] nums = data.split(" ");
                // for(String num:nums){
                //     System.out.println(num);
                // }
                float[] coord = new float[2];
                for (int i = 0, size = nums.length; i < 2; i++) {
                    try{
                        coord[i] = Float.parseFloat(nums[i+4]);
                    } catch(NumberFormatException e){System.out.println("数値以外が検出されました。");}
                }
                this.coords.add(coord);
            }
            bufferedReader.close();
        } catch (IOException e){e.printStackTrace();}
    }

}
