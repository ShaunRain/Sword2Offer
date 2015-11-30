/**
 * 输入一个含有8个数字的数组，判断是否可放置在正方体顶点，使三组相对面顶点和都相等
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p28_III {

	public static int count = 0;

	public static void main(String[] args) {

		permutationFind(new int[] { 2, 2, 2, 2, 2, 2, 2, 2 }, 0, 7);
		if (count > 0)
			System.out.println("Bingo!");
		else
			System.out.println("Failed");

	}

	public static void permutationFind(int[] nums, int begin, int end) {

		if (begin == end) {
			if (nums[0] + nums[1] + nums[2] + nums[3] == nums[4] + nums[5]
					+ nums[6] + nums[7]
					&& nums[0] + nums[2] + nums[4] + nums[6] == nums[1]
							+ nums[3] + nums[5] + nums[7]
					&& nums[0] + nums[1] + nums[4] + nums[5] == nums[2]
							+ nums[3] + nums[6] + nums[7])
				count++;
		}

		else {
			for (int i = begin; i <= end; i++) {
				int temp = nums[i];
				nums[i] = nums[begin];
				nums[begin] = temp;

				permutationFind(nums, begin + 1, end);

				temp = nums[i];
				nums[i] = nums[begin];
				nums[begin] = temp;
			}
		}

	}
}
