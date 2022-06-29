import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        try {
            File file = new File("shougakkou.txt");
            if (!file.exists()) {
                System.out.print("ファイルが存在しません");
                return;
            }

            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data;
            ArrayList<float[]> coords = new ArrayList<float[]>();

            while ((data = bufferedReader.readLine()) != null) {
                String[] nums = data.split(",");
                float[] coord = new float[2];

                for (int i = 0, size = nums.length; i < size; i++) {
                    try{
                        coord[i] = Float.parseFloat(nums[i]);
                    } catch(NumberFormatException e){System.out.println("数値以外が検出されました。");}
                }
                coords.add(coord);
            }

            bufferedReader.close();
            for(float[] co:coords){
                for(float c:co){
                    System.out.println(c);
                }
            }
        } catch (IOException e){e.printStackTrace();}
    }
}