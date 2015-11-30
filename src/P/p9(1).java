/**
 * ì³²¨ÄÇÆõÊýÁÐ
 */
package P;

import java.util.Scanner;

/**
 * @Shaun Rain 2014
 */
public class p9 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(Fibonacci(scan.nextInt()));
	}

	public static long Fibonacci(int n) {
		long result = 0l;

		if (n == 0)
			return result;
		if (n == 1)
			return 1;

		// n2,n1,n...
		long n2 = 0l;
		long n1 = 1l;

		for (int i = 2; i <= n; i++) {
			result = n2 + n1;
			n2 = n1;
			n1 = result;
		}
		return result;
	}

}
