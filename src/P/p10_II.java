/**
 * ʵ��һ������������һ����������������������Ʊ�ʾ��1�ĸ���
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p10_II {
	public static void main(String[] args) {
		System.out.println(oneCount(0xFFFFFFFF));

	}

	/*
	 * ��һ��������ȥ1���ٺ�ԭ�����������㣬��Ѹ��������ұߵ�һ��1���0�� ��ôһ�������Ķ��������ж��ٸ�1���Ϳ��������ٴ������Ĳ���
	 */
	public static int oneCount(int n) {

		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}

}
