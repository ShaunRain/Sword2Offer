/**
 * 输入两个链表，找出它们的第一个公共节点
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p37 {

	public static void main(String[] args) {

		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		ListNode n7 = new ListNode(7);

		n1.next = n2;
		n2.next = n3;
		n3.next = n6;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;

		System.out.println(findCommon(n1, n4));

	}

	public static ListNode findCommon(ListNode h1, ListNode h2) {

		if (h1 == null || h2 == null || h1.next == null || h2.next == null)
			return null;

		int len1 = 0, len2 = 0;
		ListNode l1 = h1, l2 = h2;
		while (h1.next != null) {
			h1 = h1.next;
			len1++;
		}

		while (h2.next != null) {
			h2 = h2.next;
			len2++;
		}

		if (len1 < len2) {

			ListNode temp = l1;
			l1 = l2;
			l2 = temp;

		}

		int before = len1 - len2;
		while (before-- > 0) {
			l1 = l1.next;
		}
		while (l2.next != null) {

			if (l1.next == l2.next)
				return l1.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		return null;

	}
}
