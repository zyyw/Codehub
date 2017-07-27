/**
 * Problem statement:
 * 如果一个字符串中相邻元素有重复的，删除所有重复的元素，保留 0 份。
 *
 * Idea:
 * three pointers
 */

public class DeduplicateRepeatedChar2 {

	public String deduplicateChar(String input) {
		// input sanity check
		if (input == null) {
			return "";
		}
		char[] array = input.toCharArray();
		int left = 0; // all elements to the left of "left", exclusively, are elements to be returned; left 还有一个物理意义，下一个需要返回元素放置的位置
		int start = 0; // start of repeated adjacent char to be verified
		int right = 0; // all elements to the right of "right", inclusively, are elements to be searched
		while (right < array.length) {
			while (right < array.length && array[start] == array[right]) {
				++right;
			}
			if (start + 1 == right) {
				// adjacent char on array[right] is not repeated; put array[right] to "return area"
				array[left] = array[right];
				++left; // 更新 left, 使之指向下一个返回元素放置的位置
			}
			start = right; // 更新 start, 使之指向下一个待判断的元素
			++right;
		}
		return new String(array, 0, left);
	}

}
