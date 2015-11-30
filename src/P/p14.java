/**
 * ����һ���������飬ʵ��һ��������������˳��ʹ����������λ�������ǰ�벿�֣�����ż��λ������ĺ�벿�֡�
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p14 {

	public static void main(String[] args) {

		int[] aim = { -6, -4, 0, -1, -2, -3, -5, -7, -9, -3, -4, -2, -6 };

		reorderArray(aim);
		for (int i : aim)
			System.out.print(i + "\0");

	}

	public static void reorderArray(int[] array) {
		if (array.length <= 1)
			return;

		int left = 0;
		int right = array.length - 1;

		while (left != right) {

			if (left == array.length || right == 0)
				break;

			// ������1��ż����0
			int oe1 = array[left] & 0x1;
			int oe2 = array[right] & 0x1;
			if (oe1 == 0 && oe2 == 1) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			} else if (oe1 == 0 && oe2 == 0) {
				right--;
			} else if (oe1 == 1 && oe2 == 1) {
				left++;
			} else {
				left++;
				right--;
			}
		}

	}

}
