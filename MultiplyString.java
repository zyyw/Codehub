/**
 * Problem statement:
 * 给定两个非负整数的 string 形式，返回它们的乘积的 string 形式
 *
 */

public class MultiplyString {
	public String multiply(String num1, String num2) {
		// input sanity check
		if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
			return null;
		} else if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		int base = 10;
		for (int i = num2.length() - 1; i >= 0; --i) {
			int carry = 0;
			// int indexStart = num2.length() - 1 - i;
			for (int j = num1.length() - 1; j >= 0; --j) {
				int prod = carry + (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
				// int indexOffset = num1.length() - 1 - j; 
				int index = (num2.length() - 1 - i) + (num1.length() - 1 - j);
				if (index < sb.length()) {
					prod += sb.charAt(index) - '0';
					sb.setCharAt(index, (char)('0' + prod % base));
				} else {
					sb.append((char)('0' + prod % base));
				}
				carry = prod / base;
			}
			if (carry > 0) {
				sb.append((char)('0' + carry));
			}
		}

		return sb.reverse().toString();
	}
}
