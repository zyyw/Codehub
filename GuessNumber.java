/**
 *
 */
public class GuessNumber {
    public int guessNumber(int n) {
		if (n <= 0) {
			return -1;
		}
		int start = 1;
		int end = n;
		while (start + 1 < end) {
			int mi = start + (end - start) / 2;
			if (guess(mi) == -1) {
				start = mi;
			} else {
				end = mi;
			}
		}
		if (guess(start) == 0) {
			return start;
		} else if (guess(end) == 0) {
			return end;
		} else {
			return -1;
		}
	}
}
