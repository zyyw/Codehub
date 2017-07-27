/**
 * Problem statement:
 * Given a string, remove duplicated character repeatedly, and return a final result..
 * 
 * For example:
 * "aabbacddce" => "e"
 *
 */

public class DeduplicateRepeatedChar {
	public String deduplicateChar(String input) {
		// input sanity check
		if (input == null) {
			return "";
		}
		char[] array = input.toCharArray();
		int left = 0;
		int right = 0;
		while (right < array.length) {
			if (left == 0 || array[left - 1] != array[right]) {
				array[left] = array[right];
				++left;
				++right;
			} else {
				while (right < array.length && array[left - 1] == array[right]) {
					++right;
				}
				--left;
			}
		}
		return new String(array, 0, left);
	}
}
