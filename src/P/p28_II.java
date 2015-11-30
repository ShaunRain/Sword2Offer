/**
 * 输入一个字符串，输出不重复的全组合（ab和bc重复）
 * 
 * 解题思路：
 * 假设我们想在长度为n的字符串中求m个字符的组合。
 * 我们先从头扫描字符串的第一个字符。针对第一个字
 * 符，我们有两种选择：一是把这个字符放到组合中去
 * ，接下来我们需要在剩下的n-1个字符中选取m-1个
 * 字符；二是不把这个字符放到组合中去，接下来我们
 * 需要在剩下的n-1个字符中选择m个字符。这两种选
 * 择都很容易用递归实现。
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
