/**
 * Problem statement:
 * 给定一个字符串，在字符串内部每两个相邻元素之间最多插入一个 space character. 
 * 求进行插入 space 操作后可能得到的所有的字符串。 
 *
 * Example:
 * s = "ABC"
 * return { "ABC", "A_BC", "AB_C", "A_B_C" };
 *
 */

public class InsertSpace {
	public List<String> insertSpace(String s) {
		List<String> ret = new ArrayList<>();
		// input sanity check
		if (s == null || s.length() == 0) {
			return ret;
		}
		StringBuilder sb = new StringBuilder(s);
		insertSpaceHelper(sb, 0, ret);
		return ret;
	}

	private void insertSpaceHelper(StringBuilder sb, int start, List<String> ret) {
		// base case
		if (start == sb.length() - 1) {
			ret.add(sb.toString());
			return;
		}
		// recursion:
		// 1. Insert at sb[start + 1]
		sb.insert(start + 1, ' ');
		insertSpaceHelper(sb, start + 2, ret);
		sb.deleteCharAt(start + 1);  // backtrack
		// 2. NOT insert
		insertSpaceHelper(sb, start + 1, ret);
	}
}
