/**
 * Problem statement:
 * Given an array of meeting time consisting of start and end times [[s1,e1],[s2,e2], ...],
 * find the minimum number of conference rooms required.
 *
 * Idea:
 * [ sweep ]
 * 1. 把时间 interval 分成2部分，<start, true> 和 <end, flase>
 *    将这2部分合起来按照 时间升序排序。
 * 2. iterate 排好序的序列。
 *    遇到开始的时间节点, <start, true> counter += 1
 *    遇到结束的时间节点, <end, false> counter -= 1
 *    返回 MAX{ counter }
 *
 * public class Interval {
 *   int start;
 *   int end;
 *   Interval() { start = 0; end = 0; }
 *   Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MeetingRoom2 {
	static class Cell {
		int timeStamp;
		boolean isStart;
		Cell(int t, boolean s) {
			timeStamp = t;
			isStart = s;
		}
	}
	public int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}
		List<Cell> list = new ArrayList<>();
		for (Interval interval : intervals) {
			list.add(new Cell(interval.start, true));
			list.add(new Cell(interval.end, false));
		}
		Collections.sort(list, new Comparator<Cell>(){
			@Override
			public int compare(Cell c1, Cell c2) {
				if (c1.timeStamp == c2.timeStamp) {
					return !c1.isStart ? -1 : 1;
				}
				return c1.timeStamp < c2.timeStamp ? -1 : 1;
			}
		});
		int ret = 0;
		int counter = 0;
		for (int i = 0; i < list.size(); ++i) {
			counter = counter + (list.get(i).isStart ? 1 : -1);
			ret = Math.max(ret, counter);
		}
		return ret;
	}
}
