class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		// input sanity check
		if (lists == null || lists.length == 0) {
			return null;
		}

		// create a minHeap and initialize it by putting head of each list into the minHeap
		PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
			public int compare(ListNode node1, ListNode node2) {
				return node1.val < node2.val ? -1 : 1;
			}
		});
		for (ListNode node : lists) {
			if (node != null) {
				minHeap.offer(node);
			}
		}

		// merge
		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		while (!minHeap.isEmpty()) {
			ListNode cur = minHeap.poll();
			tail.next = cur;
			tail = tail.next;
			if (cur.next != null) {
				minHeap.offer(cur.next);
			}
		}

		// return
		return dummy.next;
	}
}
