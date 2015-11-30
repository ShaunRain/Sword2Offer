/**
 * 一个整形数组中，有两个数字出现了一次，其余均两次，求这两个数。时间复杂度O（n），空间O（1）
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p40 {

	public static void main(String[] args) {

		findNums(new int[] { 2, 3, 6, 3, 2, 5, 5 ,4});

	}

	public static void findNums(int[] nums) {

		if (nums == null || nums.length == 0)
			return;

		int len = nums.length;
		int num1 = 0, num2 = 0;

		int k = 0;
		for (int i = 0; i < len; i++) {
			k ^= nums[i];
		}
		int index = findFirst1(k);
		for (int i = 0; i < len; i++) {
			if (isBit1(nums[i], index) == 1)
				num1 ^= nums[i];
			else
				num2 ^= nums[i];
		}
		if (num1 != 0)
			System.out.println("num1: " + num1);
		if (num2 != 0)
			System.out.println("num2: " + num2);

	}

	public static int findFirst1(int k) {
		int index = 0;
		while ((k & 1) == 0 && index < Integer.bitCount(k)) {
			k >>= 1;
			index++;
		}
		return index;
	}

	public static int isBit1(int k, int index) {
		k >>= index;
		return k & 1;
	}

}
