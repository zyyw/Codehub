/**
 * Problem statement:
 * Remove leading, tailing, as well as duplicated spaces in-between of words
 * return the "sentence" without leading or tailing space and words are delimited by a single space character
 */

public class RemoveSpace {

	public String removeSpaces(String input) {
		// input sanity check
		if (input == null || input.length() == 0) {
			return "";
		}
		char[] array = input.toCharArray();
		int left = 0; // all elements to the left of "left", exclusively, are elements to be returned
		int right = 0; // all elements to the right of "right", inclusively, are elements to be searched
		int wordCount = 0;
		while (right < array.length) {
			// skip all leading spaces of a word
			while (right < array.length && Character.isWhitespace(array[right])) {
				++right;
			}
			if (right == array.length) {
				break;
			}
			if (wordCount == 0) {
				array[left++] = ' '; // if it's not the first word, adding a space before copying the word
			}
			// copy a word: continous non-space character
			while (right < array.length && !Character.isWhitespace(array[right])) {
				array[left] = array[right];
				++left;
				++right;
			}
			++wordCount;
		}
		return new String(array, 0, left);
	}

}
