import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Coord{
    ArrayList<float[]> coords;
    String fileName;
    File file;

    Coord(String filename){
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

    boolean[] isCloseAll(ArrayList<float[]> input_coords, float d){
        boolean[] result = new boolean[this.coords.size()];
        int i = 0;
        for(float[] xy:this.coords){
            for(float[] xy_in:input_coords){
                if(xy_in[0]>1){
                    // System.out.println(xy_in[0]+","+xy_in[1]);
                    if(isInCircle(xy, xy_in, d)){
                        // System.out.println(i);//インデックス表示用
                        result[i] = true;
                        break;
                    }
                }
            }
            i++;
        }
        return result;
    }

    boolean[] isClose(ArrayList<float[]> input_coords, float d){
        boolean[] result = new boolean[this.coords.size()];
        int i = 0;
        for(float[] xy:this.coords){
            for(float[] xy_in:input_coords){
                // System.out.println(xy_in[0]+","+xy_in[1]);
                if(isInCircle(xy, xy_in, d)){
                    result[i] = true;
                    break;
                }
            }
            i++;
        }
        return result;
    }

    //第一引数の座標を中心として第三引数を半径としたとき、第二引数は円の中にあるか。
    boolean isInCircle(float[] center, float[] dot, float r){
        // System.out.println((center[0]-dot[1])*(center[0]-dot[1])+(center[1]-dot[0])*(center[1]-dot[0]));
        if((center[0]-dot[1])*(center[0]-dot[1])+(center[1]-dot[0])*(center[1]-dot[0])<r*r){
                return true;
            }
        return false;
    }

    void show(){
        for(float[] coord:this.coords){
            System.out.println(coord[0]+","+coord[1]);
        }
    }
}