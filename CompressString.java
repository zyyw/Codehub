/**
 * Problem statement:
 * Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences. 
 * If the character does not has any adjacent, repeated occurrences, it is not changed.
 *
 * Assumptions:
 * 1. the input string is not null 
 * 2. characters of the input string are within set of [a-z]
 * 3. There are no adjacent repeated characters with length > 9
 *
 * Example:
 * "abbcccdeee" → "ab2c3de3"
 */

public class CompressString {

	public String compress(String input) {
		// input sanity check
		if (input == null) {
			return null;
		} else if (input.length() <= 1) {
			return new String(input);
		}

		char[] array = input.toCharArray();
		int left = 0; // all elements to the left of "left", inclusively, are elements to be returned
		int start = 0; // start position of adjacent repeated characters
		int right = 0; // all elements to the right of "right", exclusively, are elements to be searched 
		while (right < array.length) {
			while (right < array.length && array[start] == array[right]) {
				++right;
			}
			array[left++] array[start];
			if (left + 1 < right) {
				// repeated
				array[left++] = (char)('0' + (right - left)); // Notice: this convertion!!
			}
			start = right;
		}
		return new String(array, 0, left);
	}
}
