public class PointValueFinder {
    public static double find (Double[] function, Double point) {
        double result = function[0] * Math.pow(point, 3) + function[1] * Math.pow(point, 2) +
                point * function[2] + function[3];
        return result;
    }
}