/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2 
 **/

public class MajorityElement {
	public int majorityElement(int[] nums) {
		// 1. count frequency of each unique element
		// <num, counts>
		Map<Integer, Integer> freq = new HashMap<>();
		for (int num : nums) {
			if (!freq.containsKey(num)) {
				freq.put(num, 1);
			} else {
				freq.put(num, freq.get(num) + 1);
			}
		}
		// 2. iterate the frequency map and return the majority element
		for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			if (entry.getValue() > nums.length / 2) {
				return entry.getKey();
			}
		}

		return -1;
	}
}
