/**
 *
 */

public class Permutation2 {
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
		// de-dup method 1:
		Set<Character> set = new HashSet<>();
		for (int i = start; i < array.length(); ++i) {
			if (!set.contains(array[i]) {
				set.add(array[i]);
				swap(array, start, i);
				permutationHelper(array, start + 1, ret);
				swap(array, start, i);
			}
		}

		// de-dup method 2:
		/*
		Set<String> set = new HashSet<>();
		for (int i = start; i < array.length; ++i) {
			swap(array, start, i);
			if (!set.contains(new String(array))) {
				set.add(new String(array));
				permutationHelper(array, start + 1, ret);
			}
			swap(array, start, i);
		}
		*/
	}
}
