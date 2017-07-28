/**
 *
 */

public class ReverseWordsInSentence {
	public char[] reverseWords(char[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		// step 1: reverse the whole sentence char-by-char
		reverse(array, 0, array.length - 1);
		// step 2: reverse each word
		int start = 0; // start index of a word
		int end = 0; // current index/cursor iterating the array
		while (end < array.length) {
			// skip all leading spaces of a word
			while (end < array.length && Character.isWhitespace(array[end])) {
				++end;
			}
			if (end == array.length) {
				break;
			}
			start = end;
			while (end < array.length && !Character.isWhitespace(array[end])) {
				++end;
			}
			reverse(array, start, end - 1);
		}
		return array;
	}

	private void reverse(char[] array, int start, int end) {
		char ch;
		while (start < end) {
			// swap
			ch = array[start];
			array[start] = array[end];
			array[end] = ch;
			// update index
			++start;
			--end;
		}
	}
}
