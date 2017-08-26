/**
 * Problem statement:
 * Implement int sqrt(int x) .
 * compute and return the square root of x.
 */
public class Sqrt1 {
	public int mySqrt(int x) {
		if (x < 0) {
			return Integer.MIN_VALUE;
		} else if (x <= 1) {
			return x;
		}
		long start = 1;
		long end = 1;
		while (end * end < (long)x) {
			start = end;
			end = end * 2;
		}
		while (start + 1 < end) {
			long mi = start + (end - start) / 2;
			if (mi * mi < x) {
				start = mi;
			} else {
				end = mi;
			}
		}
		return end * end == x ? (int)end : (int)start;
	}
}
