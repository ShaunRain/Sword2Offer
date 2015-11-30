/**
 * 输入一个递增的数组的一个旋转数组，输出旋转数组的最小元素
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

			// 第一种情况,三个标记相等，只能顺序查找
			if (array[left] == array[right] && array[right] == array[mid]) {
				min = array[0];
				for (int i = 0; i < array.length; i++) {
					if (min > array[i])
						min = array[i];
				}
				return min;
			}
			// 第二种情况，二分法查找
			if (array[mid] >= array[left]) {
				left = mid;
			} else if (array[mid] <= array[right]) {
				right = mid;
			}
		}

		return array[mid];

	}
}
