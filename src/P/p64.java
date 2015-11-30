/**
 * 得到一个数据流中的中位数
 */
package P;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Shaun Rain 2014
 */
public class p64 {

	public static String formatString(String sourceString) {
		if (sourceString == null)
			return null;
		char[] sourceArray = sourceString.toCharArray();
		StringBuilder sb = new StringBuilder();
		int i = 0, j = sourceArray.length - 1;
		while (sourceArray[i] == ' ') {
			i++;
			if (i >= sourceArray.length)
				return "";
		}
		while (sourceArray[j] == ' ') {
			j--;
			if (j < 0)
				return "";
		}
		boolean zero = true;
		for (; i <= j; i++) {
			if (sourceArray[i] == ' ') {
				if (zero) {
					sb.append(" ");
					zero = false;
				}
			} else {
				sb.append(sourceArray[i]);
				zero = true;
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {

		System.out.println(formatString(" string"));

		try {
			System.out.println(getMedian(new int[] { 13, 7, 3, 5, 8, 6, 2, 9,
					4, 10, 12, 11, 1 }));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static int getMedian(int[] nums) throws Exception {
		if (nums == null || nums.length == 0)
			throw new Exception("array not correct");
		PriorityQueue<Integer> smallQueue = new PriorityQueue<>(
				new Comparator<Integer>() {
					public int compare(Integer i1, Integer i2) {
						return i1 == i2 ? 0 : i1 > i2 ? -1 : 1;
					};
				});
		PriorityQueue<Integer> bigQueue = new PriorityQueue<>(
				new Comparator<Integer>() {
					public int compare(Integer i1, Integer i2) {
						return i1 == i2 ? 0 : i1 > i2 ? 1 : -1;
					};
				});

		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (i % 2 == 0) {
				if (bigQueue.size() > 0 && num > bigQueue.peek()) {
					bigQueue.add(num);
					smallQueue.add(bigQueue.poll());
				} else
					smallQueue.add(num);
			} else {
				if (smallQueue.size() > 0 && num < smallQueue.peek()) {
					smallQueue.add(num);
					bigQueue.add(smallQueue.poll());
				} else
					bigQueue.add(num);
			}

		}

		if (smallQueue.peek() == bigQueue.peek())
			return smallQueue.peek();
		else
			return smallQueue.size() > bigQueue.size() ? smallQueue.peek()
					: bigQueue.peek();
	}
}
