/*
Find the kth largest element in an unsorted array. Note that it is the kth
largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [3,2,1,5,6,4] and k = 2
Output: 5
Example 2:

Input: [3,2,3,1,2,4,5,5,6] and k = 4
Output: 4
Note:
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

public class KthLargestElementInAnArray {
  public int findKthLargest(int[] nums, int k) {
    // input sanity check
    // skip... assuming all inputs are valid

    // 用一个 minHeap 来装 nums 里面的元素
    Queue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
      public int compare(Integer num1, Integer num2) {
        return num1 < num2 ? -1 : 1;
      }
    });
    for (int num : nums) {
      if (minHeap.size() < k) {
        minHeap.offer(num);
      } else if (num > minHeap.peek()) {
        minHeap.poll();
        minHeap.offer(num);
      }
    }

    // return
    return minHeap.peek();
  }

  // 方法二：用快排 partition 来做
}
