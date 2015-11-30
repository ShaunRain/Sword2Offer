/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序打印没一个数字
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p20 {

	public static void main(String[] args) {

		int[][] numbers = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		PrintMatrixClock(numbers);

	}

	public static void PrintMatrixClock(int[][] numbers) {
		if (numbers == null)
			return;
		int rows = numbers.length;
		if (rows <= 0)
			return;
		int columns = numbers[0].length;
		if (columns <= 0)
			return;

		int start = 0;
		while (columns > start * 2 && rows > start * 2) {
			PrintCircle(numbers, columns, rows, start);
			start++;
		}

	}

	public static void PrintCircle(int[][] numbers, int columns, int rows,
			int start) {
		int endX = columns - start - 1;
		int endY = rows - start - 1;

		// left--->right
		for (int i = start; i <= endX; i++) {
			System.out.print(numbers[start][i] + " ");
		}

		// up--->down
		if (start < endY) {
			for (int i = start + 1; i <= endY; i++)
				System.out.print(numbers[i][endX] + " ");
		}

		// right--->left
		if (start < endX && start < endY) {
			for (int i = endX - 1; i >= start; i--)
				System.out.print(numbers[endY][i] + " ");
		}

		// down--->up
		if (start < endX && start < endY - 1) {
			for (int i = endX - 1; i >= start + 1; i--)
				System.out.print(numbers[i][start] + " ");

		}

	}

}
