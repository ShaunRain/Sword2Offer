package P;
/*
 * 在一个二维数组中，每一行从左到右递增，每一列从上到下递增。完成一个 输入整数，判断是否存在于数组中的函数
 */

public class p3 {

	public static void main(String[] args) {

		int[][] array = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 },
				{ 6, 8, 11, 15 } };
		System.out.println(find(0, array));

	}

	public static boolean find(int aim, int[][] array) {
		int col = array.length - 1;// 行数
		int row = array[0].length - 1;// 列数

		int x = 0;// 行数
		int y = row;// 列数

		while (x <= col && y >= 0) {
			if (aim < array[x][y])
				y -= 1;
			else if (aim > array[x][y])
				x += 1;
			else
				return true;
		}

		return false;

	}
}