/**
 * Problem statement:
 * Given an positive integer N, return all valid parentheses of N-pair parenthesis
 * 1) valid match, 2) only ()
 *
 * Example:
 * N = 2 
 * (()), ()()
 */

public AllValidParentheses1 {
	public List<String> allValidParentheses(int n) {
		List<String> ret = new ArrayList<>();
		if (n <= 0) {
			return ret;
		}
		StringBuilder sb = new StringBuilder();
		allValidParenthesesHelper(n, 0, 0, ret, sb);
		return ret;
	}

	private void allValidParenthesesHelper(int n, int left, int right, List<String> ret, StringBuilder sb) {
		if (left == n && right == n) {
			ret.add(sb.toString());
			return;
		}
		if (left < n) {
			sb.append(openChar);
			allValidParenthesesHelper(n, left + 1, right, ret, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
		if (right < left) {
			sb.append(closeChar);
			allValidParenthesesHelper(n, left, right + 1, ret, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private static final char openChar = '(';
	private static final char closeChar = ')';
}
