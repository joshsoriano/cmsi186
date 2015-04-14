public class MonteCarloIntegrator {

    private double lower;
    private double upper;
    private double lowerY = 0.0;
    private double upperY = 0.0;
    private long darts;
    private Polynomial function;
    private int upperHits = 0;
    private int lowerHits = 0;
    private double estimate;

    public MonteCarloIntegrator(Polynomial function) {
        this.function = function;
    }

    public double integrate(double lower, double upper, long darts) {
        this.lower = lower;
        this.upper = upper;
        this.darts = darts;
        for (int i = 0; i < darts; i++) {
            double x = (upper - lower) * Math.random() + lower;
            double randomY = function.evaluatePoly(x);
            if (randomY > upperY) {
                upperY = randomY;
            }
            if (randomY < lowerY) {
                lowerY = randomY;
            }
        }

        for (int i = 0; i < darts; i++) {
            double x = (upper - lower) * Math.random() + lower;
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

        estimate = (Math.abs(lowerY - upperY) * Math.abs(lower - upper)) * (((double)(upperHits-lowerHits)/((double)darts)));
        return estimate;
    }
}
