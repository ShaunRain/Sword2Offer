/**
 * 数组中有一个数字的出现超过数组长度的一半，请找出这个数字。
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p29 {

	static int[] nums;

	public static void main(String[] args) {
		nums = new int[] { 1, 2, 3, 2, 5, 4, 6, 9, 3, 2, 3, 3, 3, 3, 3 };

		System.out.println(findNumber(nums));
		;

	}

	// method 1
	public static void findNumber() {

		if (nums == null)
			return;
		int length = nums.length;
		if (length <= 0)
			return;

		int middle = length >> 1;
		int left = 0;
		int right = length - 1;
		int index = partition(left, right);

		while (index != middle) {

			if (index > middle) {
				right = index - 1;
				index = partition(left, right);
			}

			else {
				left = index + 1;
				index = partition(left, right);
			}

		}
		if (checkMoreThanHalf(nums[index]))
			System.out.println(nums[index]);
		else
			System.out.println("not found");

	}

	public static int partition(int left, int right) {

		int pivot = nums[right];
		int leftPtr = left - 1;
		int rightPtr = right;

		while (true) {

			while (nums[++leftPtr] < pivot)
				;
			while (nums[--rightPtr] > pivot && rightPtr > 0)
				;
			if (leftPtr >= rightPtr)
				break;
			else
				swap(leftPtr, rightPtr);

		}

		swap(leftPtr, right);
		return leftPtr;

	}

	public static void swap(int dex1, int dex2) {
		int temp = nums[dex1];
		nums[dex1] = nums[dex2];
		nums[dex2] = temp;
	}

	public static boolean checkMoreThanHalf(int num) {
		int count = 0;
		for (int i : nums)
			if (i == num)
				count++;
		return count >= (nums.length / 2) ? true : false;

	}

	// method 2
	public static int findNumber(int[] arr) {
		if (arr == null)
			return -1;
		if (arr.length <= 0)
			return -1;

		int count = 1;
		int curr = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == curr) {
				count++;
			} else {
				if (count > 0)
					count--;
				else {
					count = 1;
					curr = arr[i];
				}
			}
		}

		if (checkMoreThanHalf(curr))
			return curr;
		else
			return -1;

	}

}
