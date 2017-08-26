/**
 * Problem statement:
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example, to take course 0, you have to take course 1, which is expressed as a pair: [0, 1]
 * Given the total number of courses and a list of prerequisites pairs, is it possible for you to finish all courses.
 *
 * For example:
 * 2, [1, 0]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * 2, [[1,0], [0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0, you should also have finished course 1.
 * So it is impossible to finish all courses.
 *
 * Idea:
 * [
 *   [1, 0],
 *   [3, 2],
 *   [3, 1],
 *   [4, 1],
 *   [4, 3]
 * ]
 *
 * visualize:
 *   0 -> 1 
 *        | \
 *        |  -----> 4
 *        | /
 *        V
 *   2 -> 3
 *
 * 用一个 Map， key=course number, value=以该课程为先修课的所有课程
 * 用另一个 Map，key=course number, value=该课程剩下所有的先修课的数目 (indegree)
 * 实际实现过程中用两个数组／List 代替 Map
 * outList: 表示 以课程 index 为先修课的是哪些课
 * inArray: 表示课程 index 剩下多少先修课
 *
 * queue: 表示没有任何先修课的课程
 *
 * outList:
 *  0: 1
 *  1: 3, 4
 *  2: 3
 *  3: 4
 *  4: 
 * inArray:
 *  course number:  0 | 1 | 2 | 3 | 4
 *  indegre:        0 | 1 | 0 | 2 | 2
 */
public class CourseSchedule1 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses <= 0 || prerequisites == null) {
			return false;
		}
		List<List<Integer>> outList = new ArrayList<>();
		for (int i = 0; i < numCourses; ++i) {
			outList.add(new ArrayList<>());
		}
		int[] inArray = new int[numCourses];
		for (int i = 0; i < prerequisites.length; ++i) {
			++inArray[prerequisites[i][0]];
			outList.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 0; i < inArray.length; ++i) {
			if (inArray[i] == 0) {
				queue.offer(i);
			}
		}
		int cnt = 0;
		Integer cur = null;
		while (!queue.isEmpty()) {
			cur= queue.poll();
			++cnt;
			for (int i = 0; i < outList.get(cur).size(); ++i) {
				int course = outList.get(cur).get(i);
				--inArray[course];
				if (inArray[course] == 0){
					queue.offer(course);
				}
			}
		}
		return cnt == numCourses;
	}
}
