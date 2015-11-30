/**
 * ����һ������n�����1��n��n��������ʮ���Ʊ�ʾ��1���ֵĴ�����
 */
package P;

import java.util.Arrays;

/**
 * @Shaun Rain 2014
 */
public class p32 {

	public static void main(String[] args) {

		System.out.println(numberOf1(new char[] { '1', '3' }));

	}

	public static int numberOf1(char[] num) {

		if (num == null || num.length == 0)
			return 0;

		int first = num[0] - '0';
		if (num.length == 1 && first == 0)
			return 0;
		if (num.length == 1 && first > 0)
			return 1;

		int numFirstDigit = 0;// ��һλ��1����Ŀ
		if (first > 1)
			numFirstDigit = powerBase10(num.length - 1);
		else if (first == 1)
			numFirstDigit = Integer.valueOf(String.copyValueOf(num, 1,
					num.length - 1)) + 1;

		int numOtherDigits = first * (num.length - 1)
				* powerBase10(num.length - 2);//
		int numRecursive = numberOf1(Arrays.copyOfRange(num, 1, num.length));

		return numFirstDigit + numOtherDigits + numRecursive;

	}

	public static int powerBase10(int n) {

		int result = 1;
		for (int i = 0; i < n; i++)
			result *= 10;

		return result;

	}

}
