/**
 * ���������б��ͷָ���һ���ڵ�ָ�룬����һ��������O(1)ʱ��ɾ���ýڵ㡣
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p13 {
	/*
	 * ����β�ڵ���˵����Ҫ˳����ң�ʱ�临�Ӷ�ΪO(n)�����ƽ��ʱ�临�Ӷ���[(n-1)*O(1) + O(n)]/n,�������O(1)
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
			if (aim.next == null) {// aimΪβ�ڵ�
				ListNode current = head;
				while (current.next != aim) {
					current = current.next;
				}
				current.next = aim.next;
				aim.next = null;
			} else {// aim��Ϊβ�ڵ�
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
		// TODO �Զ����ɵķ������
		return value + "";
	}

	/*
	 * ���� Javadoc��
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
