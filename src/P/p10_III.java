/**
 * ①有一条语句判断一个整数是不是2的整数次方
 * ②输入两个整数m和n，计算需要改变m的二进制表示中的多少位才能得到n。
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p10_III {

	public static void main(String[] args) {

		System.out.println(twoPower(10));
		System.out.println(differ(10, 13));

	}

	// ①
	public static boolean twoPower(int n) {
		if (n == 1)
			return false;
		int count = oneCount(n);
		return count == 1;
	}

	/**
	 * @param n
	 * @return
	 */
	private static int oneCount(int n) {
		int count = 0;
		while (n != 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}

	// ②
	public static int differ(int n, int m) {
		int q = n ^ m;
		return oneCount(q);
	}

}
