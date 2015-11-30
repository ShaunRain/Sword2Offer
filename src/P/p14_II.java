/**
 * 解耦p14的排序条件
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p14_II {

	public static void main(String[] args) {
		int[] aim = { 1, 3, 6, 9, 24, 5, 7, 0, 19, 21 };

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

			if (!judgement(left, array) && judgement(right, array)) {
				int temp = array[left];
				array[left] = array[right];
				array[right] = temp;
				left++;
				right--;
			} else if (judgement(left, array) && judgement(right, array)) {
				left++;
			} else if (!judgement(left, array) && !judgement(right, array)) {
				right--;
			} else {
				left++;
				right--;
			}

		}

	}

	public static boolean judgement(int index, int[] array) {
		if (array[index] % 3 == 0) {
			//System.out.println(array[index]);
			return true;
		}

		else {
			//System.out.println(array[index]);
			return false;
		}

	}
}
