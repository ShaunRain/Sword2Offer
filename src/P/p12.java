/**
 * 输入数字n，按顺序打印从1到最大的n位十进制数。例：输入3，打印1到999
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p12 {

	public static void main(String[] args) {
		print2Max(4);
	}

	/*
	 * 通过递归全排列
	 */
	public static void print2Max(int n) {
		if (n <= 0)
			return;

		char[] number = new char[n + 1];
		number[n] = '\00';
		for (int i = 0; i < 10; i++) {
			number[0] = (char) (i + '0');
			recursively(number, n, 0);
		}
	}

	public static void recursively(char[] number, int length, int index) {
		if (index == length - 1) {
			printNumber(number);
			return;
		}

		for (int i = 0; i < 10; i++) {
			number[index + 1] = (char) (i + '0');
			recursively(number, length, index + 1);
		}
	}

	public static void printNumber(char[] number) {
		int first = 0;
		for (int i = 0; i < number.length; i++) {
			if (number[i] != '0') {
				first = i;
				break;
			}
		}

		for (int i = first; i < number.length; i++)
			System.out.print(number[i]);
	}

}
