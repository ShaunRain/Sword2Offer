/**
 * 0,1,2,...n-1 n����������һ��Ȧ����0��ʼÿ��ɾ����m�����֡����Ȧʣ�µ����һ������
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p45 {

	public static void main(String[] args) {

		System.out.println(lastNum(10, 3));

	}

	public static int lastNum(int n, int m) {
		if (n < 1 || m < 1)
			return -1;

		return (lastNum(n - 1, m) + m) % n;
	}

}
