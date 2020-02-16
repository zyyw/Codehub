/**
 * Problem statement:
 * Given n non-negative integers representing an elevation map where the width of each bar is 1.
 * Compute how much water it is able to trap after raining.
 *
 * 	   ^
 *     |
 *     |
 *     |
 *     |					           __
 *     |		 		 __			    |  |__    __
 *     |   __   |  |__	  __|  |  |__|  |__
 *     |__|__|__|__|__|__|__|__|__|__|__|__|________>
 *      0  1  0  2  1  0  1  3  2  1  2  1
 * water      1     1  2  1        1  => sum(i) = 6
 *
 * Idea:
 * General idea:
 * for each point, get the max height on its left, and max height on its right.
 * so total water = water + Math.min(left[i], right[i]) - height[i] ), if Math.min(left[i], right[i]) > heights[i];
 *    total water = water + 0, if Math.min(left[i], right[i]) <= heights[i]
 *    where 0 < i < heights.length - 1
 *
 * method 1:
 * getting left[i], right[i] at real-time, it will take O(N) of each
 * time complexity will be: O(N^2)
 * method 2:
 * ** preprocessing **, left[i], right[i], it will take O(N) of each
 * BUT time complexity will be: O(N)
 * -> space complexity: O(N)
 *
 */

public class MaxWaterTrapped1 {
	// method 2:
	public int trapRainWater(int[] height) {
		// input sanity check
		if (height == null || height.length <= 2) {
			return 0;
		}
		// DP
		// preprocessing
		// 1. 状态定义： left[i] 表示 height[i] 左边的 (不包括 height[i]) 最大的柱高
		// 2. base condition: left[0] = 0
		// 3. induction rule: left[i] = max(left[i - 1], height[i - 1])
		int[] left = new int[height.length];
		left[0] = 0;
		for (int i = 1; i < height.length; ++i) {
			left[i] = Math.max(left[i - 1], height[i - 1]);
		}
		int[] right = new int[height.length];
		// 1. 状态定义： right[i] 表示 height[i] 右边的（不包括 height[i]) 最大的柱高
		// 2. base condition: right[height.length - 1] = 0
		// 3. induction rule: right[i] = max(right[i + 1], height[i + 1])
		right[height.length - 1] = 0;
		for (int i = height.length - 2; i >= 0; --i) {
			right[i] = Math.max(right[i + 1], height[i + 1]);
		}

		// return:
		//  SUM{ Math.min(left[i], right[i]) - height[i], if height[i] is shorter, otherwise 0}
		int water = 0;
		for (int i = 1; i < height.length - 1; ++i) {
			int minHeight = Math.min(left[i], right[i]);
			if (minHeight > height[i]) {
				water += minHeight - height[i];
			}
		}
		return water;
	}

	// method 3:
	public int trapRainWater3(int[] heights) {
		// input sanity check
		if (heights == null || heights.length <= 2) {
			return 0;
		}
		// two pointers
		// 先 process 边界短的那头
		int start = 1;
		int end = heights.length - 2;
		int water = 0;
		int left = heights[0];
		int right = heights[heights.length - 1];
		while (start <= end) {
			if (left < right) {
				if (left < heights[start]) {
					left = heights[start];
				} else {
					water += left - heights[start];
				}
				++start;
			} else {
				if (heights[end] > right) {
					right = heights[end];
				} else {
					water += right - heights[end];
				}
				--end;
			}
		}
		return water;
	}
}
