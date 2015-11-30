/**
 * 实现两个方法，分别序列化和反序列化二叉树
 */
package P;

import java.util.Stack;

/**
 * @Shaun Rain 2014
 */

class BinaryTreeNode {
	BinaryTreeNode leftNode;
	BinaryTreeNode rightNode;
	String value;

	public BinaryTreeNode(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

}

public class p62 {

	public static void main(String[] args) {
		BinaryTreeNode n1 = new BinaryTreeNode("1");
		BinaryTreeNode n2 = new BinaryTreeNode("2");
		BinaryTreeNode n3 = new BinaryTreeNode("3");
		BinaryTreeNode n4 = new BinaryTreeNode("4");
		BinaryTreeNode n5 = new BinaryTreeNode("5");
		BinaryTreeNode n6 = new BinaryTreeNode("6");

		n1.leftNode = n2;
		n1.rightNode = n3;
		n2.leftNode = n4;
		n3.leftNode = n5;
		n3.rightNode = n6;

		System.out.println(serializable(n1));
		BinaryTreeNode b = deserializable(serializable(n1));
		System.out.println(serializable(b));
	}

	public static String serializable(BinaryTreeNode root) {
		StringBuffer sb = new StringBuffer();
		serializable(root, sb);
		return sb.toString();
	}

	public static void serializable(BinaryTreeNode node, StringBuffer sb) {
		if (node == null) {
			sb.append("$,");
			return;
		}
		sb.append(node.value + ",");
		serializable(node.leftNode, sb);
		serializable(node.rightNode, sb);
	}

	public static BinaryTreeNode deserializable(String str) {
		String[] array = str.split(",");
		Stack<BinaryTreeNode> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		BinaryTreeNode root = new BinaryTreeNode(array[0]);
		s1.push(root);
		s2.push(0);
		deserializable(s1, s2, 1, array);
		return root;
	}

	public static void deserializable(Stack<BinaryTreeNode> s1,
			Stack<Integer> s2, int curr, String[] array) {
		if (curr == array.length)
			return;
		if (array[curr].equals("$")) {
			switch (s2.peek()) {
			case 0:
				s2.push(s2.pop() + 1);
				s1.peek().leftNode = null;
				break;
			case 1:
				s2.pop();
				s1.pop().rightNode = null;
				break;
			}
		} else {
			switch (s2.peek()) {
			case 0:
				s2.push(s2.pop() + 1);
				s2.push(0);
				BinaryTreeNode node = new BinaryTreeNode(array[curr]);
				s1.peek().leftNode = node;
				s1.push(node);
				break;
			case 1:
				s2.push(s2.pop() - 1);
				node = new BinaryTreeNode(array[curr]);
				s1.pop().rightNode = node;
				s1.push(node);
				break;
			}
		}
		deserializable(s1, s2, curr + 1, array);
	}
}
