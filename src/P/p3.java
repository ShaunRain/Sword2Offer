package P;
/*
 * ��һ����ά�����У�ÿһ�д����ҵ�����ÿһ�д��ϵ��µ��������һ�� �����������ж��Ƿ�����������еĺ���
 */

public class p3 {

	public static void main(String[] args) {

		int[][] array = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 },
				{ 6, 8, 11, 15 } };
		System.out.println(find(0, array));

	}

	public static boolean find(int aim, int[][] array) {
		int col = array.length - 1;// ����
		int row = array[0].length - 1;// ����

		int x = 0;// ����
		int y = row;// ����

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