public class MonteCarloIntegrator {

	public static double evaluatePoly(double[] coefficients, double input) {
		double sum = 0;
		for (int i = 0; i <= coefficients.length; i++) {
			sum += coefficients[i] * Math.pow(input, (coefficients.length - 1 - i));
		}
		return sum;
	}
}
