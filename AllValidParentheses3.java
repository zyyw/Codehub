/**
 * Problem statement:
 * Given non-negative integers l, m, n indicating how many pairs of parentheses of (), [], {}.
 * Return all valid parentheses.
 * 1) match, 2) multiple parentheses 3) porities. {[()]}
 *
 * Example:
 * l = 1, m = 1, n = 1;
 * Return (一共15个):
 * ()[]{}
 * (){[]}
 * (){}[]
 * [()]{}
 * [](){}
 * []{()}
 * []{}()
 * {()[]}
 * {()}[]
 * {[()]}
 * {[]()}
 * {[]}()
 * {}()[]
 * {}[()]
 * {}[]()
 *
 * Idea:
 * 1. 什么时候可以插入 ( / [ / {
 *    1.1 left[i] < nums[i]
 *    1.2 matrix[stk.top()][openChars[i]] == true
 * 2. 什么时候可以插入 ) / ] / }
 *    2.1 right[i] < left[i]
 *    2.2 hashMapPair.get(stk.top()) = closeChars[i]
 */

public class AllValidParentheses3 {
	public AllValidParentheses3() {
		hashMapPair = new HashMap<>();
		hashMapPair.put('(', ')');
		hashMapPair.put('[', ']');
		hashMapPair.put('{', '}');
		hashMapIndex = new HashMap<>();
		hashMapIndex.put('(', 0);
		hashMapIndex.put('[', 1);
		hashMapIndex.put('{', 2);
	}

	public List<String> allValidParentheses(int l, int m, int n) {
		List<String> ret = new ArrayList<>();
		if (l < 0 || m < 0 || n < 0) {
			return ret;
		}
		int[] nums = {l, m, n};
		int[] left = new int[3];
		int[] right = new int[3];
		StringBuilder sb = new StringBuilder();
		Deque<Character> stk = new ArrayDeque<>();
		allValidParenthesesHelper(nums, left, right, stk, ret, sb);
		return ret;
	}

	private void allValidParenthesesHelper(int[] nums, int[] left, int[] right, Deque<Character> stk, List<String> ret, StringBuilder sb) {
		if (checkValidity(nums, left, right)) {
			ret.add(sb.toString());
			return;
		}
		// insert open char if possible
		for (int i = 0; i < nums.length; ++i) {
			if (applyOpenCharRule(i, nums, left, stk)) {
				sb.append(openChars[i]);
				++left[i];
				stk.offerFirst(openChars[i]);
				allValidParenthesesHelper(nums, left, right, stk, ret, sb);
				stk.pollFirst();
				--left[i];
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		// insert close char if possible
		for (int i = 0; i < nums.length; ++i) {
			if (applyCloseCharRule(i, nums, right, stk)) {
				sb.append(closeChars[i]);
				++right[i];
				char ch = stk.pollFirst();
				allValidParenthesesHelper(nums, left, right, stk, ret, sb);
				stk.offerFirst(ch);
				--right[i];
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	private boolean applyOpenCharRule(int index, int[] nums, int[] left, Deque<Character> stk) {
		return left[index] < nums[index] && (stk.isEmpty() || ruleMatrix[hashMapIndex.get(stk.peekFirst())][hashMapIndex.get(openChars[index])]);
	}

	private boolean applyCloseCharRule(int index, int[] nums, int[] right, Deque<Character> stk) {
		return right[index] < nums[index] && (!stk.isEmpty() && hashMapPair.get(stk.peekFirst()) == closeChars[index]);
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
	private Map<Character, Character> hashMapPair;
	private Map<Character, Integer> hashMapIndex;
	private static final boolean[][] ruleMatrix = { {true, false, false}, 
													{true, true, false}, 
													{true, true, true} };
}
