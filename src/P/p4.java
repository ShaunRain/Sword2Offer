package P;
/**
 * 实现一个函数，把字符串中每个空格替换成“%20”
 */

/**
 * @Shaun Rain
 * 2014
 */
public class p4 {
	
	public static void main(String[] args) {
		String s = "We are happy.";
		s = s.replaceAll(" ", "%20");
		System.out.println(s);
	}

}
