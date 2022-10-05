public class Shifter {
    public static Double [] shiftLeft(Double [] function, double x1, double x2, double delta) {
        while (PointValueFinder.find(function, x1) > 0) {
            x1 -= delta;
            x2 -= delta;
        }
        Double [] shiftedRoots = new Double[2];
        shiftedRoots[0] = x1;
        shiftedRoots[1] = x2;
        return shiftedRoots;
    }

    public static Double [] shiftRight(Double [] function, double x1, double x2, double delta) {
        while (PointValueFinder.find(function, x2) < 0) {
            x1 += delta;
            x2 += delta;
        }
        Double [] shiftedRoots = new Double[2];
        shiftedRoots[0] = x1;
        shiftedRoots[1] = x2;
        return shiftedRoots;
    }
}