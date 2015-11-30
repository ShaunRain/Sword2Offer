/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级台阶共多少种跳法
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p9_II {

	public static void main(String[] args) {
		System.out.println(howMany(100));
	}

	public static long howMany(int n) {
		long count = 0L;
		if (n == 0)
			return count;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		// n1,n2,n...
		long n1 = 1L;
		long n2 = 2L;
		for (int i = 3; i <= n; i++) {
			count = n1 + n2;
			n1 = n2;
			n2 = count;
		}
		return count;
	}
}
