/**
 * Problem statement:
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 * 	A -> 1
 * 	B -> 2
 * 	..  ..
 * 	Z -> 26
 * AA -> 27
 * AB -> 28
 *
 * Idea:
 * 先取余，得到 LSB
 * 再取商，进行下一轮。
 * 注意，title -> number, 是从字符串左边往右，通过累乘，处理 MSB 到 LSB
 * 这里是反过来，LSB -> MSB
 */
public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		if (n < 1) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int base = 26;
		while (n > 0) {
			sb.append((char)('A' + (n - 1) % base));
			n = (n - 1) / base;
		}
		return sb.reverse().toString();
	}
}
