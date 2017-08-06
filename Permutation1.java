/**
 *
 */

public class Permutation1 {

	public List<String> permutation(String input) {
		List<String> ret = new ArrayList<>();
		if (input == null || input.length() == 0) {
			return ret;
		}
		char[] array = input.toCharArray();
		permutationHelper(array, 0, ret);
		return ret;
	}

	private void permutationHelper(char[] array, int start, List<String> ret) {
		if (start == array.length - 1) {
			ret.add(new String(array));
			return;
		}
		for (int i = start; i < array.length; ++i) {
			swap(array, start, i);
			permutationHelper(array, start + 1, ret);
			swap(array, start, i);
		}
	}

	private void swap(char[] array, int i, int j) {
		char ch = array[i];
		array[i] = array[j];
		array[j] = ch;
	}
}
