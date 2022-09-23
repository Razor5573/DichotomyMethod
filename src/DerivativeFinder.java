public class DerivativeFinder {
    public static Double[] find(Double[] function){
        Double[] derivative = new Double[3];
        derivative[0] = 3 * function[0];
        derivative[1] = 2 * function[1];
        derivative[2] = function[2];
        return derivative;
    }
}
