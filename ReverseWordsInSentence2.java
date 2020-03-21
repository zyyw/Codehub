/**
 * Problem statement:
 * 给定一个字符串，将字符串中按照 word 进行 reverse, 并且删除所有leading/trailing/duplicated spaces in-between
 *
 * Idea:
 * 这题是两个题的综合。
 * 1. remove leading/trailing/duplicated spaces in-between
 * 2. reverse a sentence word by word
 *
 */

public class ReverseWordsInSentence2 {

	public String reverseWords(String input) {
		// input sanity check
		if (input == null || input.length() == 0) {
			return input;
		}

		// step 1: trim spaces
		char[] array = trimSpace(input).toCharArray();
		// now array is the valid space-less sentence
		// step2: reverse it word by word
		reverse(array, 0, array.length - 1);
		int start = 0;
		int end = 0;
		while (end < array.length) {
			while (end < array.length && !Character.isWhitespace(array[end])) {
				++end;
			}
			// word[start:end - 1]
			reverse(array, start, end - 1);
			++end; // since space-less, incrementing end will let array[end] be a non-space char, 1st char of the next word
			start = end; // reset start
		}
		return new String(array);
	}

	/*
	remove leading and tailing space, as well as duplicated spaces between words
	*/
	private String trimSpace(String input) {
		char[] array = input.toCharArray();
		int left = 0;
		int right = 0;
		int wordCount = 0;
		while (right < array.length) {
			// skipping leading space of a word
			while (right < array.length && Character.isWhitespace(array[right])) {
				++right;
			}
			if (right == array.length) {
				break;
			}
			// copy a word
			if (wordCount > 0) {
				array[left++] = ' ';
			}
			while (right < array.length && !Character.isWhitespace(array[right])) {
				array[left++] = array[right++];
			}
			++wordCount;
		}
		return new String(array, 0, left);
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
