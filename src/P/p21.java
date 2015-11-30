/**
 * 定义一个栈类，在该类型中实现能够得到栈的最小元素的min函数。min，push，pop的时间复杂度均为O(1)
 */
package P;

import java.util.Stack;

/**
 * @Shaun Rain 2014
 */

class MyStack {

	Stack<Integer> mainStack;
	Stack<Integer> assistStack;

	public MyStack() {
		mainStack = new Stack<Integer>();
		assistStack = new Stack<Integer>();
	}

	public void push(Integer t) {
		mainStack.push(t);
		if (assistStack.size() == 0 || assistStack.peek() > t)
			assistStack.push(t);
		else
			assistStack.push(assistStack.peek());
	}

	public void pop() {
		assert (mainStack.size() > 0 && assistStack.size() > 0);
		mainStack.pop();
		assistStack.pop();
	}

	public Integer min() {
		assert assistStack.size() > 0;
		return assistStack.peek();
	}
}

public class p21 {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(3);
		stack.push(5);
		stack.push(1);
		stack.push(2);
		stack.pop();
		stack.pop();
		stack.push(0);
		System.out.println(stack.min());
	}
}
