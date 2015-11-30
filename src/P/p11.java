/**
 * 实现函数 double Power(double base, int exponent),求 base 的 exponent 次方。不考虑大数问题
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
			throw new Exception("底数为0");
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
		/*					a的n/2次方 乘 a的n/2次方			n为偶数
		 * 公式： a的n次方 = {
		 * 					a的n-1/2次方 乘 a的n-1/2次方 乘 a	n为奇数
		 */
		double result = recPower(base, exponent >> 1);
		result *= result;
		if ((exponent & 0x1) == 1)
			result *= base;
		return result;
	}

}
