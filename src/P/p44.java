/**
 * ���˿����������5�ţ��ж��Ƿ�Ϊ˳�ӡ���С��Ϊ������
 */
package P;

import java.util.Arrays;

/**
 * @Shaun Rain 2014
 */
public class p44 {

	public static void main(String[] args) {
		
		System.out.println(isContinus(new int[]{0,1,3,4,5,7,0}));

	}

	public static boolean isContinus(int[] cards) {

		if (cards == null || cards.length < 3)
			return false;
		int len = cards.length;
		Arrays.sort(cards);
		int numZero = 0;
		int numGap = 0;
		// ��ͳ��0�ĸ���
		for (int i = 0; i < len && cards[i] == 0; i++)
			numZero++;
		// ͳ�������еļ����
		int small = numZero;
		int big = small + 1;
		while (big < len) {
			if (cards[small] == cards[big])
				return false;
			numGap += cards[big] - cards[small] - 1;
			small = big;
			big++;
		}
		return (numGap > numZero) ? false : true;
	}

}
