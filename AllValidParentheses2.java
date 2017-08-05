/**
 * Problem statement:
 * Given non-negative integers L, M, N indicating how many pairs of (), [], {} required. 
 * Return all valid parentheses of N-pair parenthesis
 * 1) match 2) ()[]{}
 * -> 配对出现即可，但不止一种括号
 *
 * Example:
 * N = 2
 * ([]), ({}), ....
 *
 * Idea:
 * 1) 插入 openChar 的时候要保证 numberOf( openCharInserted ) < l or m or n
 * 2) 插入 closeChar 的时候要保证: 
 * 	  2_1 numberOf( closeCharInserted ) < the # of corresponding openChar inserted   (这个条件可以省略，已经包含在 2_2 里了)
 * 	  2_2 带插入的 closeChar 要和 栈顶 的 openChar 匹配
 */

public class AllValidParentheses2 {
	public AllValidParentheses2() {
		hashMap = new HashMap<>();
		for (int i = 0; i < openChars.length; ++i) {
			hashMap.put(openChars[i], closeChars[i]);
		}
	}

	public List<String> allValidParentheses(int l, int m, int n) {
		List<String> ret = new ArrayList<>();
		if (l < 0 || m < 0 || n < 0) {
			return ret;
		}
		int[] nums = {l, m, n};  // how many pairs are required for each type of parenthese
		int[] left = new int[3]; // how many openChar respectively
		int[] right = new int[3]; // how many closeChar respectively
		StringBuilder sb = new StringBuilder();
		Deque<Character> stk = new ArrayDeque<>();
		allValidParenthesesHelper(nums, left, right, ret, sb, stk);
		return ret;
	}

	private void allValidParenthesesHelper(int[] nums, int[] left, int[] right, List<String> ret, StringBuilder sb, Deque<Character> stk) {
		if (checkValidity(nums, left, right)) {
			ret.add(sb.toString());
			return;
		}
		// insert openChar if possible
		for (int i = 0; i < nums.length; ++i) {
			if (applyOpenCharRule(i, nums, left)) {
				sb.append(openChars[i]);
				++left[i];
				stk.offerFirst(openChars[i]);
				allValidParenthesesHelper(nums, left, right, ret, sb, stk);
				sb.deleteCharAt(sb.length() - 1);
				--left[i];
				stk.pollFirst();
			}
		}
		// insert closeChar if possible
		for (int i = 0; i < nums.length; ++i) {
			if (applyCloseCharRule(i, right, left, stk)) {
				sb.append(closeChars[i]);
				++right[i];
				char ch = stk.pollFirst();
				allValidParenthesesHelper(nums, left, right, ret, sb, stk);
				sb.deleteCharAt(sb.length() - 1);
				--right[i];
				stk.offerFirst(ch);
			}
		}
	}

	private boolean applyCloseCharRule(int index, int[] right, int[] left, Deque<Character> stk) {
		return right[index] < left[index] && (!stk.isEmpty() && hashMap.get(stk.peekFirst()) == closeChars[index]);
	}

	private boolean applyOpenCharRule(int index, int[] nums, int[] left) {
		return left[index] < nums[index];
	}

	private boolean checkValidity(int[] nums, int[] left, int[] right) {
		for (int i = 0; i < nums.length; ++i) {
			if (left[i] != nums[i] || right[i] != nums[i]) {
				return false;
			}
		}
		return true;
	}

	private static final char[] openChars = { '(', '[', '{' };
	private static final char[] closeChars = { ')', ']', '}' };
	private static Map<Character, Character> hashMap;
}
