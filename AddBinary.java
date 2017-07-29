/**
 * Problem statement:
 * Given two binary strings, return their sum (also a binary string).
 * Example:
 * a = 11
 * b = 1
 * return: 100
 */

public class AddBinary {
	public String addBinary(String a, String b) {
		// input sanity check
		if (a == null || a.length() == 0 || b == null || b.length() == 0) {
			return null;
		}
		int idx1 = a.length() - 1;
		int idx2 = b.length() - 1;
		int carry = 0;
		int base = 2;
		StringBuilder sb = new StringBuilder();
		while (idx1 >= 0 || idx2 >= 0) {
			int sum = 0;
			if (idx1 >= 0) {
				sum += a.charAt(idx1) - '0';
				--idx1;
			}
			if (idx2 >= 0) {
				sum += b.charAt(idx2) - '0';
				--idx2;
			}
			sum += carry;
			sb.append((char)('0' + sum % base));
			carry = sum / base;
		}
		if (carry > 0) {
			sb.append((char)('0' + carry));
		}
		return sb.reverse().toString();
	}
}
