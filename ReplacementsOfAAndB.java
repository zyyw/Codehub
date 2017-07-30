/**
 * Problem statement:
 * 给定一个由字符 a 和字符 b 组成的 string, 通过把 a 变成 b 或者把 b 变成 a，
 * 使得所有的 b 都在字符串的右边，所有的 a 都在字符串的左边。
 * 求：最少的 replacement 操作次数。
 *
 * Idea:
 * start, 待搜索字符区间的左端点
 * end, 待搜索字符区间的右端点
 * if array[start] == 'a':
 * 	  ++start;
 * else if (array[end] == 'b') {
 *    --end;
 * }
 * return 1 + MIN( dfs(array, start + 1, end), dfs(array, start, end - 1) );
 * 						把array[start]变成'a'       把array[end]变成'b'
 *
 */

public class ReplacementsOfAAndB {

	public int minReplacements(String input) {
		// inpput sanity check
		if (input == null || input.length() <= 1) {
			return 0;
		}
		return minReplacementsHelper(input, 0, input.length() - 1);
	}

	private int minReplacementsHelper(String input, int start, int end) {
		if (start >= end) {
			return 0;
		}
		if (input.charAt(start) == 'a') {
			return minReplacementsHelper(input, start + 1, end);
		} else if (input.charAt(end) == 'b') {
			return minReplacementsHelper(input, start, end - 1);
		}
		return 1 + Math.min(minReplacementsHelper(input, start + 1, end), minReplacementsHelper(input, start, end - 1));
	}

}
