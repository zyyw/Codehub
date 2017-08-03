/**
 * Problem statement:
 * 给定两个非负整数的string 形式，求它们的和, 返回string 形式
 *
 * Example:
 * num1 = "123"
 * num2 = "45"
 * return "168"
 *
 */

public class AddStrings {
	public String addStrings(String num1, String num2) {
		// input sanity check
		if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
			return null;
		}
		int idx1 = num1.length() - 1;
		int idx2 = num2.length() - 1;
		int base = 10;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while (idx1 >= 0 || idx2 >= 0) {
			int sum = carry;
			if (idx1 >= 0) {
				sum += num1.charAt(idx1) - '0';
				--idx1;
			}
			if (idx2 >= 0) {
				sum += num2.charAt(idx2) - '0';
				--idx2;
			}
			sb.append((char)('0' + sum % base));
			carry = sum / base;
		}
		if (carry > 0) {
			sb.append((char)('0' + carry));
		}
		return sb.reverse().toString();
	}
}
