/*
	// Definition for a Node.
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
 */
public class CopyListWithRandomPointer {
	public Node copyRandomList(Node head) {
		if (head == null) {
			return null;
		}

		// build old node => new node mapping, deep copying
		Map<Node, Node> oldToNew = new HashMap<>();
		Node cur = head;
		while (cur != null) {
			oldToNew.put(cur, new Node(cur.val));
			cur = cur.next;
		}

		// do the pointer: next, random
		cur = head;
		Node node = oldToNew.get(cur);
		while (cur != null) {
			node.next = oldToNew.get(cur.next);
			node.random = oldToNew.get(cur.random);
			cur = cur.next;
			node = node.next;
		}

		// return
		return oldToNew.get(head);
	}

	// 解法二：不用 HashMap, do it in-place
	public Node copyRandomList2(Node head) {
		if (head == null) {
			return null;
		}

		// intialize node, 把它 inter-place 放到原 list 中
		Node cur = head;
		while (cur != null) {
			Node node = new Node(cur.val);
			node.next = cur.next;
			cur.next = node;
			cur = node.next;
		}

		// 调节 random 指针
		cur = head;
		while (cur != null) {
			if (cur.random != null) {
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}

		// 把两条 list 分开：
		// 1. 原来的 next
		// 2. 新的 next
		Node dummy = new Node(0);
		Node tail = dummy;
		while (head != null) {
			tail.next = head.next;
			tail = tail.next;
			head.next = tail.next;
			head = head.next;
		}

		return dummy.next;
	}
}
