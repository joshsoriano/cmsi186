public class MonteCarloIntegrator {
    private double lowerX;
    private double upperX;
    private double lowerY = 0.0;
    private double upperY = 0.0;
    private static long darts;
    private Polynomial function;
    private int upperHits = 0;
    private int lowerHits = 0;
    private double estimate;
    private static double lowerBound;
    private static double upperBound;

    public MonteCarloIntegrator(Polynomial function) {
        this.function = function;
    }

    public double integrate(double lower, double upper, long darts) {
        this.lowerX = lower;
        this.upperX = upper;
        this.darts = darts;
        for (int i = 0; i < darts; i++) {
            double x = (upperX - lowerX) * Math.random() + lowerX;
            double randomY = function.evaluatePoly(x);
            if (randomY > upperY) {
                upperY = randomY;
            }
            if (randomY < lowerY) {
                lowerY = randomY;
            }
        }
        lowerY = lowerY * 1.1;
        upperY = upperY * 1.1;
        System.out.println("Minimum in range: " + lowerY);
        System.out.println("Maximum in range: " + upperY);
        System.out.println("Start");
        for (int i = 0; i < darts; i++) {
            double x = (upperX - lowerX) * Math.random() + lowerX;
            double y = (upperY - lowerY) * Math.random() + lowerY;
            boolean hit = false;
            if (function.evaluatePoly(x) > 0.0 && (y > 0.0 && y < function.evaluatePoly(x))) {
                hit = true;
                upperHits++;
            } else if (function.evaluatePoly(x) < 0.0 && (y < 0.0 && y > function.evaluatePoly(x))) {
                hit = true;
                lowerHits++;
            }
            System.out.println(x + " " + y + " " + (hit ? "in" : "out"));
        }
        estimate = (Math.abs(lowerY - upperY) * Math.abs(lowerX - upperX)) * (((double)(upperHits-lowerHits)/((double)darts)));
        System.out.println("end");
        System.out.println("Estimate: " + estimate);
        return estimate;
    }

    public static void main(String[] args) {
        double[] coefficients = new double[] {1.0};
        int placeHolder;

        if (args.length == 0) {
            System.out.println("Usage: java MonteCarloIntegrator <function type> <coefficients/constants> <bound for x value> <bound for x value> <total=[# of darts] (OPTIONAL)>\n");
            return;
        }

        if (args[0].equals("poly")) {
            placeHolder = 1;
            if (args[args.length - 1].startsWith("total=")) {
                placeHolder = 0;
                
                try {
                    darts = Long.parseLong(args[args.length - 1].substring(6));
                } catch (NumberFormatException nfe) {
                    System.out.println("One or more of the supplied values is/are not valid.");
                    System.out.println("Usage: java MonteCarloIntegrator <function type> <coefficients/constants> <bound for x value> <bound for x value> <total=[# of darts] (OPTIONAL)>\n");
                    return;
                }
            } else {
                darts = 10000;
            }

            try {
                lowerBound = Double.parseDouble(args[args.length - (3 - placeHolder)]);
                upperBound = Double.parseDouble(args[args.length - (2 - placeHolder)]);
                if (upperBound < lowerBound) {
                    double temp = lowerBound;
                    lowerBound = upperBound;
                    upperBound = temp;
                }
                coefficients = new double[args.length - (4 - placeHolder)];
                for (int i = 1, j = 0; i < args.length - (3 - placeHolder); i++, j++) {
                    coefficients[j] = Double.parseDouble(args[i]);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("One or more of the supplied values is/are not valid.");
                System.out.println("Usage: java MonteCarloIntegrator <function type> <coefficients/constants> <bound for x value> <bound for x value> <total=[# of darts] (OPTIONAL)>\n"); 
                return;
            } 
            Polynomial polynomial = new Polynomial(coefficients);
            MonteCarloIntegrator test = new MonteCarloIntegrator(polynomial);
            test.integrate(lowerBound, upperBound, darts);

        } else if (!(args[0].equals("poly"))) {
            System.out.println("First argument is not a supported type of function.");
            System.out.println("Usage: java MonteCarloIntegrator <function type> <coefficients/constants> <bound for x value> <bound for x value> <total=[# of darts] (OPTIONAL)>\n");
            return;
        }
    }
}
