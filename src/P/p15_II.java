/**
 * ①  返回链表的中间项
 * ②  判断链表是否为环形链表
 */
package P;

import P.p5.ListNode;

/**
 * @Shaun Rain 2014
 */
public class p15_II {
	public static void main(String[] args) {

		ListNode n1 = new ListNode();
		ListNode n2 = new ListNode();
		ListNode n3 = new ListNode();
		ListNode n4 = new ListNode();
		ListNode n5 = new ListNode();
		ListNode n6 = new ListNode();

		n1.key = 1;
		n1.next = n2;
		n2.key = 2;
		n2.next = n3;
		n3.key = 3;
		n3.next = n4;
		n4.key = 4;
		n4.next = n5;
		n5.key = 5;
		n5.next = n6;
		n6.key = 6;
		n6.next = n1;

		// System.out.println(midItem(n1));
		System.out.println(isCircle(n1));

	}

	public static ListNode midItem(ListNode head) {

		if (head.next == null)
			return null;

		ListNode first = head;
		ListNode second = head;

		while (first.next != null && first.next.next != null) {
			first = first.next.next;
			second = second.next;
		}

		return second;
	}

	public static boolean isCircle(ListNode head) {

		ListNode first = head;
		ListNode second = head;

		while (first.next != null && first.next.next != null) {
			first = first.next.next;
			second = second.next;
			if (first == second)
				return true;
		}

		return false;
	}
}
