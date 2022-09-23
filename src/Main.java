public class Main {
    public static void main(String[] args){
        Double[] function = new Double[4];
        function[0] = Double.parseDouble(args[0]);
        function[1] = Double.parseDouble(args[1]);
        function[2] = Double.parseDouble(args[2]);
        function[3] = Double.parseDouble(args[3]);
        double delta = 0.00001;
        double epsilon = 0.00001;
        Double[] roots = RootsFinder.simpleFind(DerivativeFinder.find(function));
        while (PointValueFinder.find(function, roots[0]) * PointValueFinder.find(function, roots[1]) >= 0){
            roots[0] += delta;
            roots[1] += delta;
        }
        RootsFinder.dichotomyMethodFind(function, roots, epsilon);
    }
}
