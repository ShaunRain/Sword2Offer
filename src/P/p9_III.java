/**
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��,...Ҳ��������n���������������һ��n��̨�׹�����������
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p9_III {

	public static void main(String[] args) {

		System.out.println(howMany(7));
	}

	public static long howMany(int n) {
		if (n == 0)
			return 0;
		return recPower(2, n - 1);
	}

	public static long recPower(long num, int n) {
		if (n == 0)
			return 1;
		return num * recPower(num, n - 1);
	}

}
