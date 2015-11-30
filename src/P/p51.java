/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，请找出任意一个重复数字
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p51 {

	public static void main(String[] args) {

		System.out.println(findDuplicate(new int[] { 1, 3, 1, 0, 2, 5, 3 }));
	}

	public static int findDuplicate(int[] nums) {

		if (nums == null || nums.length <= 1)
			return -1;
		for (int i : nums)
			if (i < 0 || i > nums.length - 1)
				return -1;

		for (int j = 0; j < nums.length; j++) {
			while (nums[j] != j) {
				if (nums[nums[j]] == nums[j])
					return nums[j];
				else
					swap(nums, nums[j], j);
			}
		}

		return -1;
	}

	public static void swap(int[] nums, int m, int n) {
		int temp = nums[m];
		nums[m] = nums[n];
		nums[n] = temp;
	}

}
