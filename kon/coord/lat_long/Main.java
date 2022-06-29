public class Main{
    public static void main(String[] args){

        Coord shougaku = new Coord("data/shougakkou.txt");
        Coord jiko = new Coord("data/jinshin_zahyou_light.txt");

        shougaku.readData();
        jiko.readData();

        boolean[] result = jiko.isCloseAll(shougaku.coords, 0.01f);
        for(boolean b:result){System.out.println(b);}

        // shougaku.show();

    }
}