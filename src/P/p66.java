/**
 * 矩阵中的路径：判断一个矩阵中是否存在一条包含某字符串所有字符的路径
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p66 {

	public static void main(String[] args) {

		char[][] chars = { { 'a', 'b', 'c', 'e' }, { 's', 'f', 'c', 's' },
				{ 'a', 'd', 'e', 'e' } };
		System.out.println(havePath("cfdeesecbasa".toCharArray(), chars));

	}

	public static boolean havePath(char[] path, char[][] chars) {
		int row = chars.length;
		int col = chars[0].length;
		boolean[][] visted = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				visted[i][j] = false;
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (hasChar(path, chars, 0, visted, row, col, i, j))
					return true;
			}
		}
		return false;
	}

	public static boolean hasChar(char[] path, char[][] chars, int index,
			boolean[][] visted, int row, int col, int i, int j) {
		if (index == path.length)
			return true;

		boolean has = false;
		if (i >= 0 && i < row && j >= 0 && j < col
				&& chars[i][j] == path[index] && !visted[i][j]) {
			index++;
			visted[i][j] = true;

			has = hasChar(path, chars, index, visted, row, col, i + 1, j)
					|| hasChar(path, chars, index, visted, row, col, i - 1, j)
					|| hasChar(path, chars, index, visted, row, col, i, j + 1)
					|| hasChar(path, chars, index, visted, row, col, i, j - 1);

			if (!has) {
				index--;
				visted[i][j] = false;
			}
		}

		return has;
	}
}
