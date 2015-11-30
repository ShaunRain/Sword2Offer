/**
 * ����һ�����������һ����s�����������ҵ���������������Ϊs���ж�Դ��ڣ��������һ�Լ���
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p41 {

	public static void main(String[] args) {

		findTwo(new int[] { 1, 2, 4, 7, 11, 15 }, 15);

	}

	public static void findTwo(int[] nums, int n) {

		if (nums == null || nums.length == 0)
			return;

		int left = 0;
		int right = nums.length - 1;
		int sum = 0;

		while (left < right) {

			sum = nums[left] + nums[right];
			if (n == sum) {
				System.out.println(nums[left] + "," + nums[right]);
				return;
			} else if (sum > n) {
				right--;
			} else {
				left++;
			}

		}

		System.out.println("not found");

	}

}
