/**
 * 用两个栈实现一个队列
 */
package P;

import java.util.Stack;

/**
 * @Shaun Rain 2014
 */
public class p7 {

	public static void main(String[] args) {

		StackQueue<String> stackQ = new StackQueue<>();
		stackQ.appendTail("1");
		stackQ.appendTail("2");
		stackQ.appendTail("3");

		System.out.println(stackQ.deleteHead());
		stackQ.appendTail("4");
		System.out.println(stackQ.deleteHead());
		System.out.println(stackQ.deleteHead());
		System.out.println(stackQ.deleteHead());

	}

}

class StackQueue<T> {

	Stack<T> s1;
	Stack<T> s2;

	public StackQueue() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	// 入队
	public synchronized void appendTail(T item) {
		s1.push(item);
	}

	// 出队
	public synchronized T deleteHead() {
		if (s1.size() == 0) {
			if (s2.size() == 0)
				return null;
			else
				return s2.pop();

		} else {
			if (s2.size() == 0) {
				int num = s1.size() - 1;
				for (int i = 0; i < num; i++) {
					s2.push(s1.pop());
				}
				return s1.pop();
			} else
				return s2.pop();
		}

	}
}
