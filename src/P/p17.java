/**
 * 将两个有序递增链表合并
 */
package P;

import P.p5.ListNode;

/**
 * @Shaun Rain 2014
 */
public class p17 {

	public static void main(String[] args) {

		ListNode n1 = new ListNode();
		ListNode n2 = new ListNode();
		ListNode n3 = new ListNode();
		ListNode n4 = new ListNode();
		ListNode n5 = new ListNode();
		ListNode n6 = new ListNode();

		n1.key = 1;
		n1.next = n2;
		n2.key = 3;
		n2.next = n3;
		n3.key = 5;
		n3.next = n4;
		n4.key = 7;
		n4.next = n5;
		n5.key = 9;
		n5.next = n6;
		n6.key = 11;

		ListNode m1 = new ListNode();
		ListNode m2 = new ListNode();
		ListNode m3 = new ListNode();
		ListNode m4 = new ListNode();
		ListNode m5 = new ListNode();
		ListNode m6 = new ListNode();

		m1.key = 2;
		m1.next = m2;
		m2.key = 3;
		m2.next = m3;
		m3.key = 6;
		m3.next = m4;
		m4.key = 8;
		m4.next = m5;
		m5.key = 10;
		m5.next = m6;
		m6.key = 12;

		ListNode curr = mergeLists(n1, m1);

		while (curr != null) {
			System.out.print(curr + " ");
			curr = curr.next;
		}

	}

	public static ListNode mergeLists(ListNode h1, ListNode h2) {

		if (h1 == null)
			return h2;
		else if (h2 == null)
			return h1;

		ListNode mergeHead;

		if (h1.key > h2.key) {
			mergeHead = h2;
			mergeHead.next = mergeLists(h1, h2.next);
		} else {
			mergeHead = h1;
			mergeHead.next = mergeLists(h2, h1.next);
		}

		return mergeHead;
	}

}
