package kon.coord;

public class Coord2 extends Coord{
    public Coord2(String file_name){
        super(file_name);
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
                for (int i = 2, size = nums.length; i < size; i++) {
                    try{
                        coord[i] = Float.parseFloat(nums[i]);
                    } catch(NumberFormatException e){System.out.println("数値以外が検出されました。");}
                }
                this.coords.add(coord);
            }
            bufferedReader.close();
        } catch (IOException e){e.printStackTrace();}
    }
}