/**
 * 实现一个函数，输入一个整数，输出该整数二进制表示中1的个数
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p10_II {
	public static void main(String[] args) {
		System.out.println(oneCount(0xFFFFFFFF));

	}

	/*
	 * 把一个整数减去1，再和原整数做与运算，会把该整数最右边的一个1变成0。 那么一个整数的二进制中有多少个1，就可以做多少次这样的操作
	 */
	public static int oneCount(int n) {

		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}

}
