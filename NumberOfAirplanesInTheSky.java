/**
 * Problem statement:
 * Given an interval list which are flying and landing time of the flight. 
 * How many airplanes are on the sky at most (on the same time)?
 *
 * Assumption:
 * If landing and flying happens at the same time, we consider landing should happen at first.
 *
 * Idea:
 * [ sweep line ]
 * 1. 把 interval 分成 2 类，<start, true>, 和 <end, false>
 *    把两类放在一起根据时间升序排列。
 *
 * 2. iterate through the sorted list of interval
 *    when landing (TRUE), counter -= 1
 *    when flying (FALSE), counter += 1
 *    return MAX{ counter }
 *
 * public class Interval {
 * 	 int start, end;
 * 	 Interval(int start, int end) {
 * 	   this.start = start;
 * 	   this.end = end;
 * 	 }
 * }
 */

public class NumberOfAirplanesInTheSky {
	static class Cell {
		int timeStamp;
		boolean flying;
		Cell(int timeStampIn, boolean flyingIn) {
			this.timeStamp = timeStampIn;
			this.flying = flyingIn;
		}
	}
	public int countOfAirplanes(List<Interval> airplanes) {
		// input sanity check
		if (airplanes == null || airplanes.size() <= 1) {
			return airplanes.size();
		}
		List<Cell> list = new ArrayList<>();
		for(Interval interval: airplanes) {
			list.add(new Cell(interval.start, true));
			list.add(new Cell(interval.end, false));
		}
		Collections.sort(list, new Comparator<Cell>(){
			@Override
			public int compare(Cell c1, Cell c2) {
				if (c1.timeStamp == c2.timeStamp) {
					return !c1.flying ? -1 : 1; // landing first
				}
				return c1.timeStamp < c2.timeStamp ? -1 : 1;
			}
		});
		int ret = 0;
		int counter = 0;
		for (int i = 0; i < list.size(); ++i) {
			counter = counter + (list.get(i).flying ? 1 : -1);
			ret = Math.max(ret, counter);
		}
		return ret;
	}
}
