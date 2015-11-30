/**
 * 打印字符串的全排列
 */
package P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Shaun Rain 2014
 */
public class p28 {
	
	Scanner scan = new Scanner(System.in);

	static int[][] num0 = { { 0, 1, 0 }, { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 },
			{ 0, 1, 0 } };
	static int[][] num1 = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 }, { 0, 1, 0 },
			{ 0, 0, 0 } };
	static int[][] num2 = { { 0, 1, 0 }, { 0, 0, 1 }, { 0, 1, 0 }, { 1, 0, 0 },
			{ 0, 1, 0 } };
	static int[][] num3 = { { 0, 1, 0 }, { 0, 0, 1 }, { 0, 1, 0 }, { 0, 0, 1 },
			{ 0, 1, 0 } };
	static int[][] num4 = { { 0, 0, 0 }, { 1, 0, 1 }, { 0, 1, 0 }, { 0, 0, 1 },
			{ 0, 0, 0 } };
	static int[][] num5 = { { 0, 1, 0 }, { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 },
			{ 0, 1, 0 } };
	static int[][] num6 = { { 0, 1, 0 }, { 1, 0, 0 }, { 0, 1, 0 }, { 1, 0, 1 },
			{ 0, 1, 0 } };
	static int[][] num7 = { { 0, 1, 0 }, { 0, 0, 1 }, { 0, 0, 0 }, { 0, 0, 1 },
			{ 0, 0, 0 } };
	static int[][] num8 = { { 0, 1, 0 }, { 1, 0, 1 }, { 0, 1, 0 }, { 1, 0, 1 },
			{ 0, 1, 0 } };
	static int[][] num9 = { { 0, 1, 0 }, { 1, 0, 1 }, { 0, 1, 0 }, { 0, 0, 1 },
			{ 0, 1, 0 } };

	public static void main(String[] args) {

		// permutation(new char[] { 'a', 'b', 'c' }, 0, 2);
		/*
		 * Scanner scan = new Scanner(System.in); int n = scan.nextInt(); int[]
		 * scores; StringBuilder print = new StringBuilder(); while (n-- > 0) {
		 * scores = new int[4]; for (int i = 0; i < 4; i++) { scores[i] =
		 * scan.nextInt(); }
		 * 
		 * print.append(offerStatus(scores) + "\n"); }
		 * 
		 * System.out.println(print.toString()); scan.close();
		 */
		resolveNumver(10);
	}

	public static void resolveNumver(int num) {

		List<Integer> list = new ArrayList<>();
		int prime = 2;
		while (num != 1) {
			if (num % prime == 0) {
				list.add(prime);
				num /= prime;
			} else {
				for (int i = prime + 1; i <= num; i++) {
					boolean isPrime = true;
					for (int j = 2; j < i / 2; j++) {
						if (i % j == 0) {
							isPrime = false;
							break;
						}
					}
					if (isPrime) {
						prime = i;
						break;
					}
				}
			}
		}

		ArrayList<ArrayList<Character>> resultArrays = new ArrayList<>();
		for (int index = 0; index < 5; index++) {
			ArrayList<Character> array = new ArrayList<>();
			for (Integer in : list) {
				array.addAll(printNumber(in).get(index));
				if (index == 2)
					array.add('*');
				else
					array.add(' ');
			}
			resultArrays.add(array);
		}

		for (ArrayList<Character> array : resultArrays) {
			for (Character c : array)
				System.out.print(c);
			System.out.println();
		}

	}

	public static ArrayList<ArrayList<Character>> printNumber(int num) {

		int[][] number = new int[5][3];
		switch (num) {
		case 0:
			number = num0;
			break;
		case 1:
			number = num1;
			break;
		case 2:
			number = num2;
			break;
		case 3:
			number = num3;
			break;
		case 4:
			number = num4;
			break;
		case 5:
			number = num5;
			break;
		case 6:
			number = num6;
			break;
		case 7:
			number = num7;
			break;
		case 8:
			number = num8;
			break;
		case 9:
			number = num9;
			break;
		}

		ArrayList<ArrayList<Character>> charArrays = new ArrayList<>();
		for (int i = 0; i < number.length; i++) {
			ArrayList<Character> charArray = new ArrayList<>();
			for (int j = 0; j < number[0].length; j++) {
				if (number[i][j] == 1) {
					if (i % 2 == 0)
						charArray.add('-');
					else
						charArray.add('|');
				} else
					charArray.add(' ');

			}
			charArrays.add(charArray);
		}
		return charArrays;

	}

	public static String offerStatus(int[] scores) {
		if (scores.length != 4)
			return "Fail";
		int pol = scores[0];
		int eng = scores[1];
		int mat = scores[2];
		int pro = scores[3];
		int sum = pol + eng + mat + pro;
		if (pol < 60 || eng < 60 || mat < 90 || sum < 310 || pol > 100
				|| eng > 100 || mat > 150 || pro > 150)
			return "Fail";

		return sum >= 350 ? "Gongfei" : "Zifei";
	}

	public static void permutation(char[] phrase, int begin, int end) {

		// 游标至尾部，打印
		if (begin == end)
			System.out.println(Arrays.toString(phrase));
		else {
			// 交换第一个位置的字母
			for (int i = begin; i <= end; i++) {
				char temp = phrase[i];
				phrase[i] = phrase[begin];
				phrase[begin] = temp;
				// 递归打印每次排列
				permutation(phrase, begin + 1, end);

				temp = phrase[i];
				phrase[i] = phrase[begin];
				phrase[begin] = temp;
			}
		}

	}
}
