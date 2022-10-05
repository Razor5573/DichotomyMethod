public class Main {
    public static void main(String[] args){
        double delta = 0.1;
        double epsilon = 0.00001;
        Double[] function = new Double[4];
        Double[] derivative;
        function[0] = Double.parseDouble(args[0]);
        function[1] = Double.parseDouble(args[1]);
        function[2] = Double.parseDouble(args[2]);
        function[3] = Double.parseDouble(args[3]);
        derivative = DerivativeFinder.find(function);
        double a = derivative[0];
        double b = derivative[1];
        double c = derivative[2];
        double discriminant = b * b - 4 * a * c;

        Double[] roots = RootsFinder.simpleFind(derivative, discriminant);
        Double[] newRoots;

        double x1 = roots[1];
        double x2 = roots[0];
        double functionInZero = PointValueFinder.find(function, (double) 0);

        if (discriminant <= 0) {
            if (functionInZero > 0) {
                newRoots = Shifter.shiftLeft(function, -delta, 0, delta);
                RootsFinder.dichotomyMethodFind(function, newRoots, epsilon);
            } else {
                newRoots = Shifter.shiftRight(function, 0, delta, delta);
                RootsFinder.dichotomyMethodFind(function, newRoots, epsilon);
            }
        }
        else {
            if (PointValueFinder.find(function, x1) > 0 && PointValueFinder.find(function, x2) > 0){
                newRoots = Shifter.shiftLeft(function, x1, x2, delta);
                RootsFinder.dichotomyMethodFind(function, newRoots, epsilon);
            }
            if (PointValueFinder.find(function, x1) < 0 && PointValueFinder.find(function, x2) < 0){
                newRoots = Shifter.shiftRight(function, x1, x2, delta);
                RootsFinder.dichotomyMethodFind(function, newRoots, epsilon);
            }
            if (PointValueFinder.find(function, x1) > 0 && PointValueFinder.find(function, x2) < 0){
                newRoots = Shifter.shiftLeft(function, x1, x2, delta);
                RootsFinder.dichotomyMethodFind(function, newRoots, epsilon);
                RootsFinder.dichotomyMethodFind(function, roots, epsilon);
                newRoots = Shifter.shiftRight(function, x1, x2, delta);
                RootsFinder.dichotomyMethodFind(function, newRoots, epsilon);
            }
            if (PointValueFinder.find(function, x1) == 0 && PointValueFinder.find(function, x2) < 0){
                System.out.println(x1);
                System.out.println("must be " + x1);
                newRoots = Shifter.shiftRight(function, x1, x2, delta);
                RootsFinder.dichotomyMethodFind(function, newRoots, epsilon);
            }
            if (PointValueFinder.find(function, x1) > 0 && PointValueFinder.find(function, x2) == 0){
                System.out.println(x2);
                System.out.println("must be " + x2);
                newRoots = Shifter.shiftLeft(function, x1, x2, delta);
                RootsFinder.dichotomyMethodFind(function, newRoots, epsilon);
            }
        }
    }
}