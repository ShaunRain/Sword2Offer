/**
 * 求第n个丑数（只包含因子2,3,5。1也是丑数）
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p34 {

	public static void main(String[] args) {

		System.out.println(getUglyNumber(16));

	}

	public static int getUglyNumber(int index) {

		if (index <= 0)
			return -1;

		int[] uglyNumbers = new int[index];
		uglyNumbers[0] = 1;
		int nextUglyIndex = 1;

		int uglyMulti2 = 0;
		int uglyMulti3 = 0;
		int uglyMulti5 = 0;

		while (nextUglyIndex < index) {

			int min = min(uglyNumbers[uglyMulti2] * 2,
					uglyNumbers[uglyMulti3] * 3, uglyNumbers[uglyMulti5] * 5);
			uglyNumbers[nextUglyIndex] = min;

			while (uglyNumbers[uglyMulti2] * 2 <= uglyNumbers[nextUglyIndex])
				uglyMulti2++;
			while (uglyNumbers[uglyMulti3] * 3 <= uglyNumbers[nextUglyIndex])
				uglyMulti3++;
			while (uglyNumbers[uglyMulti5] * 5 <= uglyNumbers[nextUglyIndex])
				uglyMulti5++;

			++nextUglyIndex;
		}

		return uglyNumbers[nextUglyIndex - 1];

	}

	public static int min(int n1, int n2, int n3) {

		int min = (n1 < n2) ? n1 : n2;
		min = (min < n3) ? min : n3;

		return min;

	}

}
