/**
 * Problem statement:
 * Word “book” can be abbreviated to 4, b3, b2k, etc. Given a string and an abbreviation, return if the string matches the abbreviation.
 *
 * Assumption:
 * 1. The original string only contains alphabetic characters.
 * 2. Both input and pattern are not null.
 */

public class StringAbbreviationMatching {

	public boolean match(String input, String pattern) {
		// input sanity check
		if (input == null || pattern == null) {
			return false;
		}
		return matchHelper(input, 0, pattern, 0);
	}

	private boolean matchHelper(String input, int start1, String pattern, int start2) {
		if (start1 > input.length()) {
			return false;
		} else if (start1 == input.length() && start2 == pattern.length()) {
			return true;
		} else if (start1 == input.length() || start2 == pattern.length()) {
			return false;
		}
		if (!Character.isDigit(pattern.charAt(start2))) {
			return input.charAt(start1) != pattern.charAt(start2) ? false : matchHelper(input, start1 + 1, pattern, start2 + 1);
		}
		// pattern[start2] is a digit
		int num = 0;
		while (start2 < pattern.length() && Character.isDigit(pattern.charAt(start2))) {
			num = num * 10 + (pattern.charAt(start2) - '0');
			++start2;
		}
		return matchHelper(input, start1 + num, pattern, start2);
	}

}
