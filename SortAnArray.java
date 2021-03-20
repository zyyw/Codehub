/*
给一个数组排序，让他从小到大排列。
1. 选择排序，冒泡排序 - 时间复杂度：O(N^2), 空间复杂度: O(1)
2. 快速排序 - 时间复杂度: O(N log N)，空间复杂度: O(log N) 栈递归调用
   归并排序 - 时间复杂度: O(N log N), 空间复杂度: O(N)
3. 堆排序
*/

class Solution {
   // 快速排序
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == null) {
          return new int[0];
        }
        sortHelper(nums, 0, nums.length - 1);
        return nums;
    }

    private void sortHelper(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mi = partition(nums, start, end);
        sortHelper(nums, start, mi - 1);
        sortHelper(nums, mi + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int mi = start;
        for (int i = start + 1; i <= end; ++i) {
            if (nums[i] < pivot) {
                mi++;
                // swap(nums[mi], nums[i])
                swap(nums, mi, i);
            }
        }
        swap(nums, start, mi);
        return mi;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // 冒泡排序
    public int[] bubbleSort(int[] nums) {
      if (nums == null || nums.length == 0) {
          return new int[0];
      }
      int n = nums.length;
      for (int i = 0; i < n - 1; i++) {
          for (int j = 1; j < n - i; ++j) {
              if (nums[j - 1]> nums[j]) {
                  swap(nums, j - 1, j);
              }
          }
      }

      return nums;
    }

    // 插入排序
    public int[] insertionSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int n = nums.length;
        // 选择排序
        for (int i = 0; i < n - 1; ++i) {  // 做第i趟排序
            int k = i;
            for (int j = i + 1; j < n; ++j) { // 遍历 nums[i:n-1], 选最小的记录
                if (nums[j] < nums[k]) {
                    k = j;  // 记下目前找到的最小值所在的位置
                }
            }
            // 这趟走完，找到本轮最小的数，交换
            if (i != k) {
                swap(nums, i, k);
            }
        }
        return nums;
    }

    // 归并排序
    public int[] mergeSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int mi = nums.length / 2;
        int[] left = new int[mi];
        int[] right = new int[nums.length - mi];
        for (int i = 0; i < mi; ++i) {
            left[i] = nums[i];
        }
        for (int j = mi; j < nums.length; ++j) {
            right[j - mi] = nums[j];
        }
        sortArray(left);
        sortArray(right);
        merge(nums, left, right);
        return nums;
    }

    private void merge(int[] nums, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                nums[k] = left[i];
                i++;
            } else {
                nums[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < left.length) {
            nums[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            nums[k] = right[j];
            j++;
            k++;
        }
    }

    // 堆排序
    public int[] heapSort(int[] nums) {
        // 堆排序
        if (nums == null || nums.length < 2) {
            return nums;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(nums.length, new Comparator<Integer>() {
            public int compare(Integer num1, Integer num2) {
                return num1 < num2 ? -1 : 1;
            }
        });
        // 初始化
        for (int num : nums) {
            minHeap.offer(num);
        }

        for (int i = 0; i < nums.length; ++i) {
            nums[i] = minHeap.poll();
        }
        return nums;
    }
}
