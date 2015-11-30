/**
 * ����һ�������������һ����ת���飬�����ת�������СԪ��
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p8 {

	public static void main(String[] args) {

		System.out
				.println(getMin(new int[] { 7, 7, 8, 9, 2, 3, 3, 3, 4, 5, 6 }));

	}

	public static int getMin(int[] array) {
		int left = 0;
		int right = array.length - 1;
		int mid;
		int min;

		while (true) {
			if (right - left == 1) {
				mid = right;
				break;
			}
			mid = (left + right) / 2;

			// ��һ�����,���������ȣ�ֻ��˳�����
			if (array[left] == array[right] && array[right] == array[mid]) {
				min = array[0];
				for (int i = 0; i < array.length; i++) {
					if (min > array[i])
						min = array[i];
				}
				return min;
			}
			// �ڶ�����������ַ�����
			if (array[mid] >= array[left]) {
				left = mid;
			} else if (array[mid] <= array[right]) {
				right = mid;
			}
		}

		return array[mid];

	}
}
