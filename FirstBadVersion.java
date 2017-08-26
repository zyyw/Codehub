/**
 * Problem statement:
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which will return whether version is bad. 
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 */
public class FirstBadVersion {
	public int firstBadVersion(int n) {
		if (n <= 0) {
			return Integer.MIN_VALUE;
		}
		int start = 1;
		int end = n;
		int mi = 1;
		while (start < end) {
			mi = start + (end - start) / 2;
			if (isBadVersion(mi)) {
				end = mi;
			} else {
				start = mi + 1;
			}
		}
		return start;
	}

	// method 2:
	public int firstBadVersion2(int n) {
		if (n <= 0) {
			return Integer.MIN_VALUE;
		}
		int start = 1;
		int end = n;
		int mi = 1;
		while (start + 1 < end) {
			mi = start + (end - start) / 2;
			if (isBadVersion(mi)) {
				end = mi;
			} else {
				start = mi;
			}
		}
		// case 1: there is only 1 element
		// case 2: there are 2 elements
		return isBadVersion(start) ? start : end;
	}
}
