/**
 *
 */

public class ReverseVowels {
	public char[] reverseVowels(char[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		int start = 0;
		int end = array.length - 1;
		Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
		while (start < end) {
			while (start < end && !vowels.contains(array[start])) {
				++start;
			}
			while (start < end && !vowels.contains(array[end])) {
				--end;
			}
			if (start == end) {
				break;
			}
			swap(array, start, end);
			++start;
			--end;
		}
		return array;
	}

	private void swap(char[] array, int idx1, int idx2) {
		char ch = array[idx1];
		array[idx1] = array[idx2];
		array[idx2] = ch;
	}
}
