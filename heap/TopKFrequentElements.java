/*
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
Note:

You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n),
where n is the array's size.
*/

public class TopKFrequentElements {
  class Pair {
    int num;
    int freq;
    Pair(int n, int f) {
      num = n;
      freq = f;
    }
  }

  public List<Integer> topKFrequent(int[] nums, int k) {
    // input sanity check
    // skip... assuming inputs are valid

    // 统计每个 unique key 出现的次数，HashMap
    Map<Integer, Integer> hashMap = new HashMap<>();
    for (int num : nums) {
      Integer frequence = hashMap.get(num);
      if (frequence == null) {
        hashMap.put(num, 1);
      } else {
        hashMap.put(num, frequence + 1);
      }
    }

    // minHeap 获得 k 个出现最频繁的元素
    Queue<Pair> minHeap = new PriorityQueue<>(k, new Comparator<Pair>(){
      public int compare(Pair p1, Pair p2) {
        return p1.freq < p2.freq ? -1 : 1;
      }
    });
    for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
      if (minHeap.size() < k) {
        minHeap.offer(new Pair(entry.getKey(), entry.getValue()));
      } else if (entry.getValue() > minHeap.peek().freq) {
        minHeap.poll();
        minHeap.offer(new Pair(entry.getKey(), entry.getValue()));
      }
    }

    // return
    List<Integer> ret = new ArrayList<>();
    while (!minHeap.isEmpty()) {
      Pair cur = minHeap.poll();
      ret.add(cur.num);
    }
    // reverse ret
    Collections.reverse(ret);
    return ret;
  }
}
