/**
 * 不用加减乘除做加法
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p47 {

	public static void main(String[] args) {
		System.out.println(add(5, 9));
	}

	public static int add(int n, int m) {
		int sum, carry = 0;
		do {
			sum = n ^ m;
			carry = (n & m) << 1;
			n = sum;
			m = carry;
		} while (m != 0);
		return sum;
	}
}
