/**
 * Problem statement:
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 * A	-> 1
 * B	-> 2
 * C	-> 3
 * ...	  ...
 * Z	-> 26
 * AA	-> 27
 * AB	-> 28
 * ..	  ...
 *
 * Idea:
 * base 26, from MSB (left) to LSB (right)
 * 每次在基数上乘以 26
 *
 */

public class ExcelSheetColumnNumber {
	public int titleToNumber(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int ret = 0;
		int base = 26;
		for (int i = 0; i < s.length(); ++i) {
			ret = ret * base + (s.charAt(i) - 'A' + 1);
		}
		return ret;
	}
}
