/**
 * 给定一个数组和滑动窗口大小，请找出所有滑动窗口的最大值
 */
package P;
import java.util.LinkedList;
import java.util.Queue;
/**
 * @Shaun Rain 2014
 */
public class p65 {

	public static void main(String[] args) {

		findMax(new int[] { 2, 6, 4, 2, 1, 2, 5, 1 }, 3);

	}

	public static void findMax(int[] array, int k) {

		Queue<Integer> queue = new LinkedList<>();
		queue.add(array[0]);
		int index = 1;
		while (index < k) {
			if (queue.peek() < array[index]) {
				while (!queue.isEmpty())
					queue.remove();
				queue.add(array[index]);
			} else {
				queue.add(array[index]);
			}
			index++;
		}
		System.out.print(queue.peek() + " ");
		while (index < array.length) {
			if (queue.peek() < array[index]) {
				while (!queue.isEmpty())
					queue.remove();
				queue.add(array[index]);
			} else {
				queue.add(array[index]);
			}
			index++;
			System.out.print(queue.peek() + " ");
			if (queue.size() == 3)
				queue.remove();
		}
	}
}
