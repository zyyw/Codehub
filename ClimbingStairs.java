/**
 * Problem statement:
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 *
 */

public class ClimbingStairs {
	public int climbStairs(int n) {
		// input sanity check
		if (n <= 0) {
			return 0;
		} else if (n <= 2) {
			return n;
		}
		int step2 = 1;
		int step1 = 2;
		int curStep = step1;
		for (int i = 3; i <= n; ++i) {
			curStep = step1 + step2;
			step2 = step1;
			step1 = curStep;
		}
		return curStep;
	}
}
