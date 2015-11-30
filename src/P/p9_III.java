/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级,...也可以跳上n级。求该青蛙跳上一个n级台阶共多少种跳法
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p9_III {

	public static void main(String[] args) {

		System.out.println(howMany(7));
	}

	public static long howMany(int n) {
		if (n == 0)
			return 0;
		return recPower(2, n - 1);
	}

	public static long recPower(long num, int n) {
		if (n == 0)
			return 1;
		return num * recPower(num, n - 1);
	}

}
