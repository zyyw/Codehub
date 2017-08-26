/**
 * Problem statement:
 * Implement double sqrt(double x) and x >= 0.
 * Compute and return the square root of x.
 *
 * Assumption:
 * You do not care about the accuracy of the result, we will help you to output results.
 */
public class Sqrt2 {
	public double sqrt(double x) {
		if (x < 0) {
			return Integer.MIN_VALUE;
		}
		double start = 0;
		double end = x / 2.0 + 1.0;
		if (x < 1) {
			end = 1.0;
		}
		while (end - start > 1e-12) {
			double mi = start + (end - start) / 2.0;
			if (mi * mi < x) {
				start = mi;
			} else {
				end = mi;
			}
		}
		return start;
	}
}
