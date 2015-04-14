public class Polynomial {
    private double[] coefficients;
    
    public Polynomial(double[] coefficients) {
        this.coefficients = coefficients;
    }

    public double evaluatePoly(double input) {
        double sum = 0;
        for (int i = 0; i < this.coefficients.length; i++) {
            sum += this.coefficients[i] * Math.pow(input, (this.coefficients.length - (1 + i)));
        }
        return sum;
    }

}
