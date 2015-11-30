/**
 * 
 */
package P;

/**
 * @Shaun Rain 2014
 */
public class Sample {
	@ExceptionTest(ArrayIndexOutOfBoundsException.class)
	public static void m1() {
		int[] array = new int[10];
		System.out.println(array[10]);
	}

	@ExceptionTest(ArrayIndexOutOfBoundsException.class)
	public static void m2() {
		int[] array = new int[10];
		System.out.println(array[9]);
	}

}
