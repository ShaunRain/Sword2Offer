/**
 * �������е������������ǰ��һ�����ں��棬���������������һ������ԡ�����һ�����飬�����������е�����Ե�����
 */
package P;

import java.util.Arrays;

/**
 * @Shaun Rain 2014
 */
public class p36 {

	public static void main(String[] args) {

		System.out.println(countInverse(new int[] { 7, 5, 6, 1, 2, 3 }));

	}

	public static int countInverse(int[] data) {

		if (data == null || data.length <= 0)
			return -1;
		int len = data.length;

		int[] copy = Arrays.copyOfRange(data, 0, len);
		int count = inversePairs(data, copy, 0, len - 1);

		return count;
	}

	public static int inversePairs(int[] data, int[] copy, int start, int end) {

		if (start == end) {
			copy[start] = data[start];
			return 0;
		}

		int len = (end - start) / 2;
		int left = inversePairs(copy, data, start, start + len);
		int right = inversePairs(copy, data, start + len + 1, end);

		// i ǰ������һ�����ֵ��±�
		int i = start + len;
		// j �������һ�����ֵ��±�
		int j = end;
		int copyIndex = end;
		int count = 0;
		while (i >= start && j >= start + len + 1) {

			if (data[i] > data[j]) {

				copy[copyIndex--] = data[i--];
				count += j - start - len;

			} else
				copy[copyIndex--] = data[j--];

		}

		while (i >= start)
			copy[copyIndex--] = data[i--];
		while (j >= start + len + 1)
			copy[copyIndex--] = data[j--];

		return left + right + count;

	}

}
