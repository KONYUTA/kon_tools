package kon.lib;
public class Math2 extends java.lang.Math{
    public static double atanh(double tanh){
        double res = super.log((1+tanh)/(1-tanh))/2;
        return res;
    }

}
