/**
 * 一个链表中包含环，如何找到环的入口节点？
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p56 {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l3;

		System.out.println(findEnter(l1));

	}

	public static ListNode findEnter(ListNode first) {

		ListNode p1 = first;
		ListNode p2 = first;
		
		try {
			do {
				p1 = p1.next.next;
				p2 = p2.next;
			} while (p1 != p2);
		} catch (NullPointerException e) {
			System.out.println("不是环");
			return null;
		}
		
		int count = 0;
		do {
			p1 = p1.next;
			count++;
		} while (p1 != p2);
		
		p1 = first;
		p2 = first;
		for (int i = 0; i < count; i++)
			p1 = p1.next;

		while (p1 != p2) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1;

	}
}
