/**
 * 数字在排序数组中出现的次数
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p38 {

	public static void main(String[] args) {

		System.out.println(getCount(new int[] {}, 3));

	}

	public static int getCount(int[] nums, int k) {

		if (nums == null || nums.length == 0)
			return -1;

		int lastIndex = getLast(nums, k, 0, nums.length - 1);
		int firstIndex = getFirst(nums, k, 0, nums.length - 1);
		int count = lastIndex - firstIndex;
		return count > 0 ? count + 1 : count == 0 && lastIndex >= 0 ? 1 : -1;

	}

	public static int getFirst(int[] nums, int k, int start, int end) {

		if (start > end)
			return -1;

		int midIndex = (start + end) / 2;
		int midData = nums[midIndex];

		if (midData == k) {

			if ((midIndex > 0 && nums[midIndex - 1] == k) || midIndex == 0)
				end = midIndex - 1;
			else
				return midIndex;

		} else if (midData < k)

			start = midIndex + 1;

		else if (midData > k)

			end = midIndex - 1;

		return getFirst(nums, k, start, end);

	}

	public static int getLast(int[] nums, int k, int start, int end) {

		if (start > end)
			return -1;

		int midIndex = (start + end) / 2;
		int midData = nums[midIndex];

		if (midData == k) {

			if ((midIndex + 1 < nums.length && nums[midIndex + 1] == k)
					|| midIndex == nums.length - 1)
				start = midIndex + 1;
			else
				return midIndex;
		} else if (k > midData)
			start = midIndex + 1;
		else if (k < midData)
			end = midIndex - 1;

		return getLast(nums, k, start, end);

	}

}
