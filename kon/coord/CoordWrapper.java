//使ってないので消していい
package kon.coord;

public class CoordWrapper{
    public Coord coord;
    public CoordWrapper(String file_name){
        coord = new Coord(file_name);
        coord.coords = new ArrayList<float[]>();
    }
}