/**
 * 输入一个正整数s，打印出所有和为s的连续整数序列（至少两个数）
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p41_II {

	public static void main(String[] args) {

		findContinus(25);

	}

	public static void findContinus(int num) {

		if (num < 3)
			return;
		int[] nums = new int[num - 1];
		for (int i = 0; i < num - 1; i++) {
			nums[i] = i + 1;
		}
		int small = 0;
		int big = 1;
		int sum = 0;

		while (big <= ((num + 1) / 2) && small < big) {

			sum = count(nums, small, big);
			if (sum == num) {
				print(nums, small, big);
				small++;
			} else if (sum < num) {
				big++;
			} else {
				small++;
			}
		}

	}

	public static int count(int[] nums, int small, int big) {
		int result = 0;
		for (int i = small; i <= big; i++)
			result += nums[i];
		return result;
	}

	public static void print(int[] nums, int small, int big) {
		for (int i = small; i <= big; i++)
			System.out.print(nums[i] + " ");
		System.out.println();
	}
}
