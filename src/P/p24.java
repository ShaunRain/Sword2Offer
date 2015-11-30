/**
 * 输入一个整数数组，判断该数组是不是墨二叉搜索树的后序遍历结果，假设输入数组的任意两个数字都不相同
 */
package P;

import java.util.Arrays;

/**
 * @Shaun Rain 2014
 */
public class p24 {

	public static void main(String[] args) {
		System.out.println(isLRD(new int[] { 5, 7, 6, 9, 11, 10, 8 }));

	}

	public static boolean isLRD(int[] sequence) {

		if (sequence == null || sequence.length <= 0)
			return false;
		int root = sequence[sequence.length - 1];

		int i = 0;
		for (; i < sequence.length - 1; i++)
			if (sequence[i] > root)
				break;

		int j = i;
		for (; j < sequence.length - 1; j++)
			if (sequence[j] < root)
				return false;

		int[] leftChild = Arrays.copyOfRange(sequence, 0, i);
		int[] rightChild = Arrays.copyOfRange(sequence, i, sequence.length - 1);

		boolean left = true;
		if (i > 0)
			left = isLRD(leftChild);

		boolean right = true;
		if (i < sequence.length - 1)
			right = isLRD(rightChild);

		return left && right;
	}

}
