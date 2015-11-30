/**
 * 输入两个整数序列，第一个表示栈的压入顺序，判断第二个是否可能为该栈的弹出序列。压入栈的所有数字均不相等
 */
package P;

import java.util.Stack;

/**
 * @Shaun Rain 2014
 */
public class p22 {

	public static void main(String[] args) {
		int[] push = { 1, 2, 3, 4, 5 };
		int[] pop = { 4, 3, 5, 1, 2 };
		System.out.println(isPopOrder(push, pop));

	}

	public static boolean isPopOrder(int[] pushOrder, int[] popOrder) {
		if (pushOrder.length <= 0 || popOrder.length <= 0)
			return false;

		Stack<Integer> stack = new Stack<>();
		int i = 0;
		while (i < pushOrder.length) {
			int curr = popOrder[i];
			int index = 0;
			while (true) {
				if (pushOrder[index] == curr)
					break;
				index++;
			}

			if (stack.size() > 0) {
				if (stack.peek() == curr)
					stack.pop();
				else {
					boolean flag = false;
					for (int k = i; k < pushOrder.length; k++) {
						if (pushOrder[k] == curr)
							flag = true;
					}

					if (!flag)
						return false;
				}
			} else {
				for (int j = 0; j <= index; j++)
					stack.push(pushOrder[j]);
				stack.pop();
			}

			i++;
		}

		return true;
	}

}
