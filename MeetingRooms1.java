/**
 * Problem statement:
 * Given an array of meeting time intervals consisting of start and end times, [[s1, e1], [s2, e2], ...],
 * determine if a person could all meetings.
 *
 * public class Interval {
 *   int start;
 *   int end;
 *   Interval() { start = 0; end = 0; }
 *   Interval(int s, int e) { start = s; end = e; }
 * }
 */

public class MeetingRooms1 {
	public boolean canAttendMeetings(Interval[] intervals) {
		if (intervals == null || intervals.length <= 1) {
			return true;
		}
		Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				if (i1.start == i2.start) {
					return i1.end < i2.end ? -1 : 1;
				}
				return i1.start < i2.start ? -1 : 1;
			}
		});
		for (int i = 1; i < intervals.length; ++i) {
			if (intervals[i - 1].end > intervals[i].start) {
				return false;
			}
		}
		return true;
	}
}
