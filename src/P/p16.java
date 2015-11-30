/**
 * 反转链表，输入头结点，输出翻转后头结点
 */
package P;

import P.p5.ListNode;

/**
 * @Shaun Rain 2014
 */
public class p16 {

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

		System.out.println(reverseList(n1).next);
	}

	public static ListNode reverseList(ListNode head) {
		if (head.next == null)
			return head;

		ListNode reverseHead = null;
		ListNode current = head;
		ListNode previous = null;

		while (current != null) {
			ListNode next = current.next;
			if (next == null)
				reverseHead = current; 

			current.next = previous;
			previous = current;
			current = next;
		}

		return reverseHead;
	}
}
