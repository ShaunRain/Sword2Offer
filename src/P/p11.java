/**
 * ʵ�ֺ��� double Power(double base, int exponent),�� base �� exponent �η��������Ǵ�������
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p11 {

	public static void main(String[] args) {
		try {
			System.out.println(Power(2, -4));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static double Power(double base, int exponent) throws Exception {
		if (Math.abs(base - 0) < 0.000001)
			throw new Exception("����Ϊ0");
		if (exponent < 0) {
			exponent = -exponent;
			return 1.0 / recPower(base, exponent);
		}
		return recPower(base, exponent);
	}

	public static double recPower(double base, int exponent) {

		if (exponent == 0)
			return 1;
		if (exponent == 1)
			return base;
		/*					a��n/2�η� �� a��n/2�η�			nΪż��
		 * ��ʽ�� a��n�η� = {
		 * 					a��n-1/2�η� �� a��n-1/2�η� �� a	nΪ����
		 */
		double result = recPower(base, exponent >> 1);
		result *= result;
		if ((exponent & 0x1) == 1)
			result *= base;
		return result;
	}

}
