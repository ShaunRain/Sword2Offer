/**
 * (￣△￣；)两个队实现一个栈
 */
package P;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Shaun Rain 2014
 */
public class p7_II {

	public static void main(String[] args) {
		
		QueueStack<Integer> queueStack = new QueueStack<>();
		queueStack.ppush(1);
		queueStack.ppush(2);
		queueStack.ppush(3);
		queueStack.ppush(4);
		queueStack.ppush(5);
		
		System.out.println(queueStack.ppop());
		System.out.println(queueStack.ppop());
		queueStack.ppush(6);
		System.out.println(queueStack.ppop());
		System.out.println(queueStack.ppop());
		System.out.println(queueStack.ppop());
		

	}

}

class QueueStack<T> {

	Queue<T> q1;
	Queue<T> q2;

	public QueueStack() {
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
	}

	// 入栈
	public boolean ppush(T item) {
		return q1.offer(item);
	}

	// 出栈
	public T ppop() {
		if (q1.size() == 0) {
			if (q2.size() == 0)
				return null;
			else {
				while (q2.size() > 1) {
					q1.add(q2.poll());
				}
				return q2.poll();
			}
		} else {
			if (q2.size() == 0) {
				while (q1.size() > 1) {
					q2.add(q1.poll());
				}
				return q1.poll();
			} else {
				while (q1.size() > 1) {
					q2.add(q1.poll());
				}
				return q1.poll();
			}
		}
	}
}
