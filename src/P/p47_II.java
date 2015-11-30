/**
 * 不使用新的变量，交换两个变量的值
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p47_II {

	static int n;
	static int m;

	public static void main(String[] args) {
		m = 5;
		n = 10;
		exchange();
		System.out.println("m,n:" + m + "," + n);
	}

	public static void exchange() {
		/*
		 * n = n + m; m = n - m; n = n - m;
		 */
		n = n ^ m;
		m = n ^ m;
		n = n ^ m;
	}

}
