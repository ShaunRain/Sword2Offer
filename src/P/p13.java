/**
 * 给订单向列表的头指针和一个节点指针，定义一个函数在O(1)时间删除该节点。
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p13 {
	/*
	 * 对于尾节点来说，需要顺序查找，时间复杂度为O(n)。因此平均时间复杂度是[(n-1)*O(1) + O(n)]/n,结果还是O(1)
	 */

	public static void main(String[] args) {

		ListNode head = new ListNode(0);
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		head.next = one;
		one.next = two;
		two.next = three;
		three.next = four;

		deleteNode(head, four);
		printList(head);

	}

	public static void printList(ListNode head) {
		ListNode current = head;
		while (current != null) {
			System.out.println(current.value);
			current = current.next;
		}
	}

	public static void deleteNode(ListNode head, ListNode aim) {
		if (head == null | aim == null)
			return;
		if (head.next == aim) {// length = 1
			head.next = null;
		} else {// length>1
			if (aim.next == null) {// aim为尾节点
				ListNode current = head;
				while (current.next != aim) {
					current = current.next;
				}
				current.next = aim.next;
				aim.next = null;
			} else {// aim不为尾节点
				aim.value = aim.next.value;
				aim.next = aim.next.next;
				aim.next.next = null;
			}
		}
	}
}

class ListNode {

	int value;
	ListNode next;

	public ListNode(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return value + "";
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ListNode))
			return false;
		return ((ListNode) obj).value == this.value ? true : false;
	}

}
