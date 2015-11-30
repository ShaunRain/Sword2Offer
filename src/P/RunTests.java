/**
 * 
 */
package P;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Shaun Rain 2014
 */
public class RunTests {

	public static void main(String[] args) {
		int test = 0;
		int pass = 0;
		Class testClass = P.Sample.class;
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(ExceptionTest.class)) {
				test++;
				try {
					m.invoke(null, null);
				} catch (InvocationTargetException wrappedEx) {
					Throwable exc = wrappedEx.getCause();
					Class<? extends Exception> excType = m.getAnnotation(
							ExceptionTest.class).value();
					if (excType.isInstance(exc)) {
						pass++;
					} else {
						System.out.println("Test Failed," + exc);
					}
				} catch (IllegalAccessException e) {
					System.out.println("INVALID" + m);
				} catch (IllegalArgumentException e) {
					System.out.println("INVALID" + m);
				}
			}
		}

		System.out.println("test:" + test + " pass:" + pass);
	}

}
