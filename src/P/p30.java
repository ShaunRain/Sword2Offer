/**
 * 输入一个数组，找出其中最小的k个数
 */
package P;

import java.util.Random;
import java.util.TreeSet;

/**
 * @Shaun Rain 2014
 */
public class p30 {

	static int[] nums;

	public static void randomArray(int n) {

		nums = new int[n];
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			nums[i] = rand.nextInt(10) + 1;
		}
	}

	public static void main(String[] args) {

		randomArray(100000000);

		long start1 = System.currentTimeMillis();
		findLeast(4);
		System.out.println("Spend:" + (System.currentTimeMillis() - start1));
		long start2 = System.currentTimeMillis();
		findByTree(4);
		System.out.println("Spend:" + (System.currentTimeMillis() - start2));
	}

	// method 1
	public static void findLeast(int aim) {

		if (aim > nums.length || aim == 0)
			return;

		int start = 0;
		int end = nums.length - 1;
		int index = partition(start, end);
		while (index != aim - 1) {
			if (index > aim - 1) {
				end = index - 1;
				index = partition(start, end);
			} else {
				start = index + 1;
				index = partition(start, end);
			}

		}

		for (int i = 0; i < aim; i++)
			System.out.print(nums[i] + " ");

	}

	public static int partition(int left, int right) {

		if (nums.length == 0)
			return -1;

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

	// method 2  不重复
	public static void findByTree(int aim) {

		if (aim > nums.length || aim == 0)
			return;

		TreeSet<Integer> tree = new TreeSet<>();

		for (int i = 0; i < nums.length; i++) {

			if (tree.size() == aim) {
				if (tree.last() > nums[i]) {
					tree.pollLast();
					tree.add(nums[i]);
				}
			} else
				tree.add(nums[i]);
		}

		for (Integer i : tree)
			System.out.print(i + " ");

	}

}
