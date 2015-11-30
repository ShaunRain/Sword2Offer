/**
 * 实现一个函数，输入一个整数，输出该整数二进制表示中1的个数
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p10 {

	public static void main(String[] args) {
		System.out.println(oneCount(0x80000000));
	}

	public static int oneCount(int n) {
		int count = 0;
		int i = 1;
		while (i != 0) {
			if ((n & i) == i)
				count++;
			i = i << 1;
		}
		return count;
	}

}
