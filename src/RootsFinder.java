import java.lang.Math;
import java.text.DecimalFormat;

public class RootsFinder {
    public static Double[] simpleFind(Double[] function){
        double a = function[0];
        double b = function[1];
        double c = function[2];
        double discriminant = b*b - 4 * a * c;
        Double[] roots = new Double[2];
        roots[0] = (-b + Math.sqrt(discriminant)) / (2 * a);
        roots[1] = (-b - Math.sqrt(discriminant)) / (2 * a);
        return roots;
    }

    public static void dichotomyMethodFind(Double[] function, Double[] range, double epsilon){
        double a = range[0];
        double b = range[1];
        while (Math.abs(b - a) > epsilon){
            double midpoint = (a + b) / 2;
            if(PointValueFinder.find(function, a) * PointValueFinder.find(function, midpoint) < 0){
                b = midpoint;
            }
            else if (PointValueFinder.find(function, b) * PointValueFinder.find(function, midpoint) < 0) {
                a = midpoint;
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("#");
        System.out.println((a + b) / 2 + "\nmight be " + decimalFormat.format((a + b) / 2));

    }
}
