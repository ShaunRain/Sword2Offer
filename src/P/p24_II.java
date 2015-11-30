/**
 * 输入一组整数，判断是否为二叉搜索树的前序遍历。假设数字均不相同
 */
package P;

import java.util.Arrays;

/**
 * @Shaun Rain 2014
 */
public class p24_II {

	public static void main(String[] args) {
		System.out.println(isDLR(new int[] { 8, 6, 5, 7, 10, 9, 11 }));

	}

	public static boolean isDLR(int[] numbers) {
		if (numbers == null || numbers.length <= 0)
			return false;
		int root = numbers[0];

		int i = 1;
		for (; i < numbers.length; i++)
			if (numbers[i] > root)
				break;

		int j = i;
		for (; j < numbers.length; j++)
			if (numbers[j] < root)
				return false;

		int[] leftChild = Arrays.copyOfRange(numbers, 1, i);
		int[] rightChild = Arrays.copyOfRange(numbers, i, numbers.length);

		boolean left = true;
		if (i > 1)
			left = isDLR(leftChild);
		boolean right = true;
		if (i < numbers.length)
			right = isDLR(rightChild);

		return left && right;
	}

}
