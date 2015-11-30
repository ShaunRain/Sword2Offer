/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点
 */
package P;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @Shaun Rain 2014
 */
public class p63 {

	public static void main(String[] args) {

		BinaryTreeNode n1 = new BinaryTreeNode("5");
		BinaryTreeNode n2 = new BinaryTreeNode("3");
		BinaryTreeNode n3 = new BinaryTreeNode("7");
		BinaryTreeNode n4 = new BinaryTreeNode("2");
		BinaryTreeNode n5 = new BinaryTreeNode("4");
		BinaryTreeNode n6 = new BinaryTreeNode("6");
		BinaryTreeNode n7 = new BinaryTreeNode("8");

		n1.leftNode = n2;
		n1.rightNode = n3;
		n2.leftNode = n4;
		n2.rightNode = n5;
		n3.leftNode = n6;
		n3.rightNode = n7;

		System.out.println(getK(n1, 3));

	}

	public static BinaryTreeNode getK(BinaryTreeNode root, int k) {
		Stack<BinaryTreeNode> s = new Stack<>();
		push(s, root);

		try {
			for (; k > 1; k--)
				s.pop();
		} catch (EmptyStackException e) {
			System.out.println("没这么多节点");
			return null;
		}

		return s.pop();

	}

	public static void push(Stack<BinaryTreeNode> s, BinaryTreeNode node) {

		if (node == null)
			return;

		if (node.rightNode != null)
			push(s, node.rightNode);
		s.push(node);
		if (node.leftNode != null)
			push(s, node.leftNode);

	}

}
