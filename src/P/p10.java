/**
 * ʵ��һ������������һ����������������������Ʊ�ʾ��1�ĸ���
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
