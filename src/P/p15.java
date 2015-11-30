/**
 * 输出链表的倒数第k项
 */
package P;

import P.p5.ListNode;

/**
 * @Shaun Rain 2014
 */

public class p15 {

	public static void main(String[] args) {

		ListNode n1 = new ListNode();
		ListNode n2 = new ListNode();
		ListNode n3 = new ListNode();
		ListNode n4 = new ListNode();
		ListNode n5 = new ListNode();

		n1.key = 1;
		n1.next = n2;
		n2.key = 2;
		n2.next = n3;
		n3.key = 3;
		n3.next = n4;
		n4.key = 4;
		n4.next = n5;
		n5.key = 5;

		try {
			System.out.println(backCount(n1, 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ListNode backCount(ListNode head, int k) throws Exception {
		if (head == null || k == 0)
			throw new Exception("传入空节点或目标项不存在!");
		ListNode first = head;
		ListNode second = head;
		int n = 0;

		while (n < k - 1) {
			if (first.next != null)
				first = first.next;
			else
				throw new Exception("目标项不存在!");
			n++;
		}

		while (first.next != null) {
			second = second.next;
			first = first.next;
		}

		return second;

	}
}
