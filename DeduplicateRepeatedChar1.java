/**
 * Problem statement:
 * 如果一个字符串中相邻元素有重复的，删除多余的重复的元素，只保留一份。
 *
 */

public class DeduplicateRepeatedChar1 {

	public String deduplicateChar(String input) {
		// input sanity check
		if (input == null || input.size() == 0) {
			return "";
		}
		char[] array = input.toCharArray();
		int left = 1; // all elements to the left of "left", exclusively, are elements to be returned; 注意这里 left 从1开始
		int right = 1; // all elements to the right of "right", inclusively, are elements to be searched; 注意这里 right  也从1开始
		while (right < array.length) {
			if (array[left - 1] != array[right]) {
				array[left] = array[right]; // 由这里可以看出 left 还有一个物理意义：下一个元素待插入的位置
				++left;
			}
			++right;
		}
		return new String(array, 0, left);
	}

}
