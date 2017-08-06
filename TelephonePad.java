/**
 * Problem statement:
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * Example:
 * input: s = "23"
 * output: 
 * ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 *
 */

public class TelephonePad {
	public List<String> letterCombinations(String digits) {
		List<String> ret = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return ret;
		}
		// 				 0   1     2      3      4      5      6      7      8      9
		String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		StringBuilder sb = new StringBuilder();
		letterCombinationsHelper(digits, 0, ret, sb, map);
		return ret;
	}

	private void letterCombinationsHelper(String digits, int pos, List<String> ret, StringBuilder sb, String[] map) {
		if (pos == digits.length()) {
			ret.add(sb.toString());
			return;
		}
		for (int i = 0; i < map[digits.charAt(pos) - '0'].length(); ++i) {
			sb.append(map[digits.charAt(pos) - '0'].charAt(i));
			letterCombinationsHelper(digits, pos + 1, ret, sb, map);
			sb.deleteCharAt(sb.length() - 1); // backtrack
		}	
	}
}
