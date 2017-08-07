/**
 * Problem statement:
 * Given an array of 2D coordinates of points (all the coordinates are integers), 
 * find the largest number of points that can form a set such that any pair of points in the set can form a line with positive slope.
 * Return the size of such a maximal set.
 *
 * Assumption:
 * The given array is not null
 * Note: if there does not even exist 2 points can form a line with positive slope, should return 0.
 *
 * Idea:
 * sorted the set of points by x-axis, and then find longest increasing subsequence
 *
 * 难点在建模：LIS
 */

public class LargestSetOfPointsWithPositiveSlope {
	public int largest(Point[] points) {
		// input sanity check
		if (points == null || points.length <= 1) {
			return 0;
		}
		// sort the array of points by x-axis
		Arrays.sort(points, new Comparator<Point>(){
			@Override
			public int compare(Point p1, Point p2) {
				if (p1.x == p2.x) {
					return p1.y < p2.y ? -1 : 1;
				}
				return p1.x < p2.x ? -1 : 1;
			}
		});
		// find LIS of Point.y
		int[] dp = new int[points.length];
		dp[0] = 1;
		int ret = 1;
		for (int i = 1; i < points.length; ++i) {
			dp[i] = 1;
			for (int j = i - 1; j >= 0; --j) {
				if (points[j].y < points[i].y) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			ret = Math.max(ret, dp[i]);
		}
		return ret == 1 ? 0 : ret;
	}
}
