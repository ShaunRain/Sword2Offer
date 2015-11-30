/**
 * ����һ���ַ�����������ظ���ȫ��ϣ�ab��bc�ظ���
 * 
 * ����˼·��
 * �����������ڳ���Ϊn���ַ�������m���ַ�����ϡ�
 * �����ȴ�ͷɨ���ַ����ĵ�һ���ַ�����Ե�һ����
 * ��������������ѡ��һ�ǰ�����ַ��ŵ������ȥ
 * ��������������Ҫ��ʣ�µ�n-1���ַ���ѡȡm-1��
 * �ַ������ǲ�������ַ��ŵ������ȥ������������
 * ��Ҫ��ʣ�µ�n-1���ַ���ѡ��m���ַ���������ѡ
 * �񶼺������õݹ�ʵ�֡�
 */
package P;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Shaun Rain 2014
 */
public class p28_II {

	public static void main(String[] args) {

		combination(new char[] { 'a', 'b', 'c', 'd' });

	}

	public static void combination(char[] phrase) {

		if (phrase.length <= 0)
			return;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 1; i <= phrase.length; i++)
			combination(phrase, 0, i, stack);

	}

	public static void combination(char[] phrase, int begin, int num,
			Stack<Character> stack) {

		if (num == 0) {
			Character[] chs = new Character[stack.size()];
			stack.copyInto(chs);
			System.out.println(Arrays.toString(chs));
			return;
		}

		if (begin == phrase.length)
			return;

		stack.push(phrase[begin]);
		combination(phrase, begin + 1, num - 1, stack);
		stack.pop();
		combination(phrase, begin + 1, num, stack);

	}

}
