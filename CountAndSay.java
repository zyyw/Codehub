/*
 * Problem statement:
 * Given a sequence of number: 1, 11, 21, 1211, 111221, …
 * The rule of generating the number in the sequence is as follow:
 * 1 is "one 1" so 11.
 * 11 is "two 1s" so 21.
 * 21 is "one 2 followed by one 1" so 1211.
 * Find the nth number in this sequence.
 *
 * Assumptions:
 * n starts from 1, the first number is "1", the second number is "11"
 *
 */

public class CountAndSay {

	public String countAndSay(int n) {
		// input sanity check
		if (n <= 0) {
			return null;
		}
		String s = "1";
		while (n > 1) {
			StringBuilder sb = new StringBuilder();
			int start = 0; // start of adjacently repeated char
			int end = 0; // current cursor
			while (end < s.length()) {
				start = end;
				while (end < s.length() && s.charAt(start) == s.charAt(end)) {
					++end;
				}
				// s[start:end - 1] contains the same digit
				sb.append(String.valueOf(end - start));
				sb.append(s.charAt(start));
			}
			s = sb.toString();
			--n;
		}
		return s;
	}

}
