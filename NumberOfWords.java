/**
 * Problem statement:
 * Given a string, count number of words in it.
 * The delimiters can be the following characters:
 * space (‘ ‘) or new line (‘\n’) or tab (‘\t’) or a combination/duplication of these
 *
 */

public class NumberOfWords {

	public int numberOfWords(String input) {
		// input sanity check
		if (input == null || input.size() == 0) {
			return 0;
		}
		int wordCount = 0;
		int end = 0;
		while (end < input.size()) {
			// skipping leading space of any word
			while (end < input.size() && Character.isWhitespace(input.charAt(end))) {
				++end;
			}
			if (end == input.size()) {
				break;
			}
			while (end < input.size() && !Character.isWhitespace(input.charAt(end))) {
				++end;
			}
			++wordCount;
		}
		return wordCount;
	}
}
