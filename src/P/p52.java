/**
 * 给定数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1]
 * ,其中B中的元素B[i] = A[0] * A[1] * ...* A[i-1] * A[i+1]*...*A[n-1]。不能使用除法
 */
package P;

import java.util.Arrays;

/**
 * @Shaun Rain 2014
 */
public class p52 {

	public static void main(String[] args) {
		getB(new int[] { 1, 2, 3, 4, 5 });
	}

	public static void getB(int[] A) {
		if (A == null || A.length == 0)
			return;
		int[] B = new int[A.length];
		multiplay(A, B);
		System.out.println(Arrays.toString(B));
	}

	public static void multiplay(int[] A, int[] B) {
		if (A.length != B.length)
			return;
		int len = A.length;
		B[0] = 1;
		for (int i = 1; i < len; i++) {
			B[i] = B[i - 1] * A[i - 1];
		}
		int temp = 1;
		for (int j = len - 2; j >= 0; j--) {
			temp *= A[j + 1];
			B[j] *= temp;
		}
	}

}
