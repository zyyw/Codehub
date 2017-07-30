/**
 * Problem statement:
 * Given a string source and a string target, find the minimum window in source which will contain all the characters in target.
 *
 * Example:
 * source = "ADOBECODEBANC"
 * target = "ABC"
 * return (minimum window): "BANC"
 *
 */

public class MinimumWindowSubstring {
    public String minWindow(String source, String target) {
        if (source == null || source.length() == 0 || target == null || target.length() == 0) {
            return "";
        }
        int[] hashTarget = new int[256];
        Arrays.fill(hashTarget, 0);
        for (int i = 0; i < target.length(); ++i) {
            hashTarget[target.charAt(i)] += 1;
        }
        int[] hashWindow = new int[256];
        int left = 0;
        int cnt = 0; // number of characters in target being covered
        int start = -1;
        int end = -1;
        for (int right = 0; right < source.length(); ++right) {
            if (hashTarget[source.charAt(right)] == 0) {
                // this is NOT a target char, skipp it
                continue;
            }
            // this is a target char
            hashWindow[source.charAt(right)]++;
            if (hashWindow[source.charAt(right)] <= hashTarget[source.charAt(right)]) {
                // covered on valid char
                ++cnt;
            }
            // when to move "left"
            while ( cnt == target.length() &&
                    (hashTarget[source.charAt(left)] == 0 ||
                            hashWindow[source.charAt(left)] > hashTarget[source.charAt(left)]) ) {
                --hashWindow[source.charAt(left)];
                ++left;
            }
            // when to update return variables, when necessary
            if (cnt == target.length() && hashWindow[source.charAt(right)] <= hashTarget[source.charAt(right)]) {
                // cnt incremented to target.length
                if ((start == -1) || (right - left + 1 < end - start + 1)) {
                    start = left;
                    end = right;
                }
            }
        }
        return start == -1 ? "" : source.substring(start, end + 1);
    }
}
