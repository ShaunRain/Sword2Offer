/**
 * 任意两个整数加法，大数相加
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p12_II {
	char[] result;
	char[] n1;
	char[] n2;

	public p12_II(char[] n1, char[] n2) {
		int len = 0;
		if (n1.length > n2.length) {
			len = n1.length + 1;
			n1 = supply(len, n1);
			n2 = supply(len, n2);
		} else if (n2.length > n1.length) {
			len = n2.length + 1;
			n1 = supply(len, n1);
			n2 = supply(len, n2);
		} else {
			len = n1.length + 1;
			n1 = supply(len, n1);
			n2 = supply(len, n2);
		}

		this.n1 = n1;
		this.n2 = n2;

		result = new char[n1.length];

	}

	public static void main(String[] args) {
		p12_II p = new p12_II("987654321111".toCharArray(), "12300456789013212".toCharArray());
		System.out.println(p.n1.length + "," + p.n2.length);
		p.bigAdd();
		printNumber(p.result);

	}

	public void bigAdd() {
		int carry = 0;
		for (int i = result.length - 1; i >= 0; i--) {
			int add = n1[i] - '0' + n2[i] - '0' + carry;
			if (add < 10) {
				carry = 0;
				result[i] = (char) ('0' + add);
			} else {
				carry = 1;
				result[i] = (char) (add - 10 + '0');
			}
		}
	}

	public static char[] supply(int length, char[] n) {
		char[] result = new char[length];
		for (int i = 0; i < result.length; i++)
			result[i] = '0';
		System.arraycopy(n, 0, result, length - n.length, n.length);
		return result;
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
