/**
 * Problem statement:
 * Find the Nth number in Fibonacci sequence.
 * A Fibonacci sequence is defined as follow:
 * The first two numbers are 0 and 1
 * The i th number is the sum of i-1 th number and i-2 th number.
 *
 * Example:
 * intput    output
 *   1		  0
 *   2		  1
 *   3		  1
 *   4		  2
 */

public class Fibonacci {
	public int fibonacci(int n) {
		if (n <= 0) {
			return Integer.MIN_VALUE;
		} else if (n <= 2) {
			return n - 1;
		}
		int first = 0;
		int second = 1;
		int current = second;
		for (int i = 3; i <= n; ++i) {
			current = first + second;
			first = second;
			second = current;
		}
		return current;
	}
}
