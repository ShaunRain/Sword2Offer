/**
 * 逆序输出链表节点
 */
package P;

import java.util.Stack;

/**
 * @Shaun Rain 2014
 */
public class p5 {

	static class ListNode {
		int key;
		ListNode next;

		@Override
		public String toString() {
			return key + "";
		}
	}

	static Stack<ListNode> stack;

	public static void main(String[] args) {
		stack = new Stack<>();
		ListNode[] nodes = new ListNode[4];

		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new ListNode();
			nodes[i].key = i;
		}
		for (int i = 0; i < nodes.length - 1; i++)
			nodes[i].next = nodes[i + 1];
		printReverse(nodes[0]);

	}

	public static void printReverse(ListNode first) {
		ListNode cur = first;
		do {
			stack.push(cur);
			cur = cur.next;
		} while (cur != null);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
