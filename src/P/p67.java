/**
 * m��n�еķ���һ�������˴����꣨0��0���ĸ��ӿ�ʼ�ƶ�
 * ��ÿ�����������ƶ�һ�������ܽ���������������������λ֮�ʹ���k���������ܵ������������������ظ�����һ������
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class p67 {

	public static void main(String[] args) {
		
		System.out.println(stepMax(80, 80, 6));

	}

	public static int stepMax(int row, int col, int k) {
		boolean[][] visted = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++)
				visted[i][j] = false;
		}
		return stepMax(visted, row, col, 0, 0, k);
	}

	public static int stepMax(boolean[][] visted, int row, int col, int i,
			int j, int k) {
		int count = 0;
		if (i >= 0 && i < row && j >= 0 && j < col
				&& getDigitSum(i) + getDigitSum(j) <= k
				&& visted[i][j] == false) {
			visted[i][j] = true;

			count = 1 + stepMax(visted, row, col, i + 1, j, k)
					+ stepMax(visted, row, col, i - 1, j, k)
					+ stepMax(visted, row, col, i, j + 1, k)
					+ stepMax(visted, row, col, i, j - 1, k);
		}

		return count;

	}

	public static int getDigitSum(int number) {
		int sum = 0;
		while (number > 0) {
			sum += sum % 10;
			number /= 10;
		}
		return sum;
	}
}
