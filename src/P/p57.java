/**
 * 在排序的链表中，如何删除重复的节点。
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p57 {

	public static void main(String[] args) {

		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(2);
		ListNode n4 = new ListNode(2);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(4);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		ListNode head = deleteDuplication(n1);
		while (head != null) {
			System.out.print(head + " ");
			head = head.next;
		}
	}

	public static ListNode deleteDuplication(ListNode head) {

		if (head == null || head.next == null)
			return null;

		ListNode before = head;
		ListNode current = before.next;
		while (current != null) {
			if (before.equals(current)) {
				before.next = current.next;
				current.next = null;
				current = before.next;
			} else {
				before = current;
				current = before.next;
			}
		}

		return head;
	}

}
