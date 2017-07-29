/**
 * Problem statement:
 * Shift array of characters to the right by N positions. In-place operation.
 * Assumption:
 * 1. N >= 0
 * 2. array NOT null
 *
 * Example:
 * input: array = "abcdef", n = 2
 * output: "efabcd"
 *
 * Idea:
 * Method 1:
 * step1: reverse the while string
 * step2: reverse array[0:n - 1] and array[n:array.length - 1] respectively
 */

public class RightShiftByNChars {

	public char[] rightShift(char[] array, int n) {
		// input sanity check
		if (array == null || n < 0) {
			return null;
		} else if (array.length == 0 || n % array.length == 0) {
			return array;
		}
		n = n % array.length; // n must do a mod against array.length first!!
		reverse(array, 0, array.length - 1);
		reverse(array, 0, n - 1);
		reverse(array, 0, array.length - 1);
		return array;
	}

	private void reverse(char[] array, int start, int end) {
		char ch;
		while (start < end) {
			ch = array[start];
			array[start] = array[end];
			array[end] = ch;
			++start;
			--end;
		}
	}

}
