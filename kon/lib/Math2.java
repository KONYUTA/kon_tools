package kon.lib;
import java.lang.Math;
public class Math2 {
    public static double atanh(double tanh){
        double res = Math.log((1+tanh)/(1-tanh))/2;
        return res;
    }

}
