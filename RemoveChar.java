/**
 * Problem statement:
 * remove elements that are in a given target set; and return those left as a new string
 *
 */

public class RemoveChar {

	public String removeChar(String input, Set<Character> set) {
		// input sanity check
		if (input == null) {
			return null;
		} else if (input.length() < 2) {
			return new String(input);
		}

		char[] array = input.toCharArray();
		int left = 0; // all elements to the left of "left", exclusively, are elements to be returned
		int right = 0;  // all elements to the right of "right", inclusively, are elements to be searched
		while (right < array.length) {
			if (!set.contains(array[right])) {
				array[left] = array[right]; // if the current element is not a target to be removed, assign it to the "return area"
				++left;
			}
			++right; // right boundary should be incremented anyway
		}
		return new String(array, 0, left);
	}

}
