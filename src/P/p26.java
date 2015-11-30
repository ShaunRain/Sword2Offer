/**
 * 复杂链表的复制，每个节点除了next引用，还有一个任意节点的引用或是null
 */
package P;

/**
 * @Shaun Rain 2014
 */

class ComplexListNode {
	char value;
	ComplexListNode next;
	ComplexListNode any;

	public ComplexListNode(char value) {
		this.value = value;
	}

	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return value + "";
	}
}

public class p26 {

	public static void main(String[] args) {

		ComplexListNode A = new ComplexListNode('A');
		ComplexListNode B = new ComplexListNode('B');
		ComplexListNode C = new ComplexListNode('C');
		ComplexListNode D = new ComplexListNode('D');
		ComplexListNode E = new ComplexListNode('E');

		A.next = B;
		B.next = C;
		C.next = D;
		D.next = E;

		A.any = C;
		B.any = E;
		C.any = null;
		D.any = B;
		E.any = null;

		copyComplexList(A);

	}

	public static void copyComplexList(ComplexListNode head) {

		copyNodes(head);
		copyAny(head);
		ComplexListNode copyHead = seperateList(head);
		while (copyHead != null) {
			System.out.println("cur:" + copyHead.value);
			System.out.println("any:" + copyHead.any);
			copyHead = copyHead.next;
		}
	}

	public static void copyNodes(ComplexListNode head) {

		ComplexListNode curr = head;
		while (curr != null) {
			ComplexListNode copy = new ComplexListNode(curr.value);
			copy.next = curr.next;
			curr.next = copy;

			curr = copy.next;
		}

	}

	public static void copyAny(ComplexListNode head) {

		ComplexListNode curr = head;
		while (curr != null) {
			ComplexListNode copy = curr.next;
			if (curr.any != null)
				copy.any = curr.any.next;
			curr = copy.next;
		}

	}

	public static ComplexListNode seperateList(ComplexListNode head) {

		ComplexListNode curr = head;
		ComplexListNode copyHead = null;
		ComplexListNode copy = null;

		if (curr != null) {
			copy = copyHead = curr.next;
			curr.next = copy.next;
			curr = copy.next;
		}

		while (curr != null) {
			copy.next = curr.next;
			copy = copy.next;
			curr.next = copy.next;
			curr = copy.next;
		}

		return copyHead;
	}

}
