/**
 * Problem statement:
 * 如果一个字符串中相邻元素有重复的，删除多余的重复的元素，最多只保留2份。
 *
 * follow up:
 * 如果一个字符串中相邻元素有重复的，删除多余的重复的元素，最多只保留 k 份。
 * -> left 初始值赋为 k
 * -> right 初始值赋为 k
 * -> 判断 array[left - k] 和 array[right]
 *
 */

public class DeduplicateRepeatedChar2 {

	public String deduplicateChar(String input) {
		// input sanity check
		if (input == null) {
			return "";
		}
		char[] array = input.toCharArray();
		int left = 2;  // all elements to the left of "left", exclusively, are elements to be returned
		int right = 2; // all elements to the right of "right", inclusively, are elements to be returned
		while (right < array.length) {
			if (array[left - 2] != array[right]) {
				array[left] = array[right];
				++left;
			}
			++right;
		}
		return new String(array, 0, left);
	}

}
