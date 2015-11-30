/**
 * 求1+2+...+n.要求不能使用乘除法，for，while，if，else，switch，case以及条件判断语句
 */
package P;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @Shaun Rain 2014
 */
public class p46 {
	ArrayList<Boolean> isZero = new ArrayList<>();
	Method[] methods;

	public p46() throws SecurityException, ClassNotFoundException {
		isZero.add(true);
		isZero.add(false);
		methods = Class.forName("P.p46").getMethods();
	}

	// method 1
	public int teminator(int n) {
		return 0;
	}

	// method 2
	public int plus(int n) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		int index = isZero.indexOf(n == 0);
		return n-- + (Integer) methods[index + 1].invoke(this, n);
	}

	public static void main(String[] args) throws ClassNotFoundException,
			IllegalAccessException, IllegalArgumentException,
			InvocationTargetException {
		p46 p = new p46();
		System.out.println(p.plus(11));
	}

}
