/**
 * 按之字形顺序打印二叉树
 */
package P;

import java.util.Stack;

import P.p6.BinaryTreeNode;

/**
 * @Shaun Rain 2014
 */
public class p61 {

	static boolean flag = true;

	public static void main(String[] args) {

		BinaryTreeNode n1 = new BinaryTreeNode(1);
		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(3);
		BinaryTreeNode n4 = new BinaryTreeNode(4);
		BinaryTreeNode n5 = new BinaryTreeNode(5);
		BinaryTreeNode n6 = new BinaryTreeNode(6);
		BinaryTreeNode n7 = new BinaryTreeNode(7);

		n1.leftNode = n2;
		n1.rightNode = n3;
		n2.leftNode = n4;
		n2.rightNode = n5;
		n3.leftNode = n6;
		n3.rightNode = n7;

		printZ(n1);

	}

	public static void printZ(BinaryTreeNode root) {

		Stack<BinaryTreeNode> s1 = new Stack<>();
		Stack<BinaryTreeNode> s2 = new Stack<>();
		s1.push(root);
		printLine(s1, s2);
	}

	public static void printLine(Stack<BinaryTreeNode> curr,
			Stack<BinaryTreeNode> next) {
		if (curr.isEmpty())
			return;

		while (!curr.isEmpty()) {
			BinaryTreeNode node = curr.pop();
			System.out.print(node + " ");
			if (flag) {
				if (node.leftNode != null)
					next.push(node.leftNode);
				if (node.rightNode != null)
					next.push(node.rightNode);
			} else {
				if (node.rightNode != null)
					next.push(node.rightNode);
				if (node.leftNode != null)
					next.push(node.leftNode);
			}
		}
		flag = !flag;
		System.out.println();
		printLine(next, curr);

	}

}
