/**
 * Problem statement:
 * Given an array of strings, group anagrams together.
 * For example, given: {"eat", "tea", "tan", "ate", "nat", "bat"}
 * Return:
 * [
 *   ["ate", "eat", "tea"],
 *   ["nat", "tan"],
 *   ["bat"]
 * ]
 *
 * Assumption:
 * All input will be lowercase
 *
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList<>();
		}
		Map<String, List<String>> map = new HashMap<>();
		for (String s : strs) {
			char[] array = s.toCharArray();
			Arrays.sort(array);
			String key = String.valueOf(array);
			List<String> value = map.get(key);
			if (value == null) {
				value = new ArrayList<>();
				value.add(s);
				map.put(key, value);
			} else {
				value.add(s);
			}
		}
		// return map.values(); // WRONG syntax
		return new ArrayList<List<String>>(map.values());
	}
}
