/**
 *  Problem statement:
 *  ..
 *  Return the ordering of courses you should take to finish all courses.
 *  If there are multiple correct orders, retur any one of them.
 */
public class CourseSchedule2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if (numCourses <= 0 || prerequisites == null) {
			return new int[0];
		}
		// outList
		List<List<Integer>> outList = new ArrayList<>();
		for (int i = 0; i < numCourses; ++i) {
			outList.add(new ArrayList<>());
		}
		// inArray
		int[] inArray = new int[numCourses];
		for (int i = 0; i < prerequisites.length; ++i) {
			++inArray[prerequisites[i][0]];
			outList.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		// queue: course with indegree=0 (dynamically)
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < inArray.length; ++i) {
			if (inArray[i] == 0) {
				queue.offer(i);
			}
		}
		Integer cur = null;
		List<Integer> ret = new ArrayList<>();
		while (!queue.isEmpty()) {
			cur = queue.poll();
			ret.add(cur);
			for (int i = 0; i < outList.get(cur).size(); ++i) {
				int course = outList.get(cur).get(i);
				--inArray[course];
				if (inArray[course] == 0) {
					queue.offer(course);
				}
			}
		}
		if (ret.size() == numCourses) {
			return new int[0];
		}
		int[] array = new int[ret.size()];
		for (int i = 0; i < ret.size(); ++i) {
			array[i] = ret.get(i);
		}
		return array;
	}
}
