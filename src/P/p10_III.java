/**
 * ����һ������ж�һ�������ǲ���2�������η�
 * ��������������m��n��������Ҫ�ı�m�Ķ����Ʊ�ʾ�еĶ���λ���ܵõ�n��
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p10_III {

	public static void main(String[] args) {

		System.out.println(twoPower(10));
		System.out.println(differ(10, 13));

	}

	// ��
	public static boolean twoPower(int n) {
		if (n == 1)
			return false;
		int count = oneCount(n);
		return count == 1;
	}

	/**
	 * @param n
	 * @return
	 */
	private static int oneCount(int n) {
		int count = 0;
		while (n != 0) {
			n = n & (n - 1);
			count++;
		}
		return count;
	}

	// ��
	public static int differ(int n, int m) {
		int q = n ^ m;
		return oneCount(q);
	}

}
