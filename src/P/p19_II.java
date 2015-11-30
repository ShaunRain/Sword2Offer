/**
 * 输入一个二叉树，输出它的镜像(循环)
 */
package P;

import java.util.Stack;

import P.p6.BinaryTreeNode;

/**
 * @Shaun Rain 2014
 */
public class p19_II {

	public static void main(String[] args) {

		BinaryTreeNode A1 = new BinaryTreeNode(8);
		BinaryTreeNode A2 = new BinaryTreeNode(8);
		BinaryTreeNode A3 = new BinaryTreeNode(7);
		BinaryTreeNode A4 = new BinaryTreeNode(9);
		BinaryTreeNode A5 = new BinaryTreeNode(2);
		BinaryTreeNode A6 = new BinaryTreeNode(4);
		BinaryTreeNode A7 = new BinaryTreeNode(7);

		A1.leftNode = A2;
		A1.rightNode = A3;
		A2.leftNode = A4;
		A2.rightNode = A5;
		A5.leftNode = A6;
		A5.rightNode = A7;

		mirror(A1);

		System.out.println(A1.leftNode + " " + A1.rightNode);
		System.out
				.println(A1.rightNode.leftNode + " " + A1.rightNode.rightNode);
	}

	public static void mirror(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stack = new Stack<>();
		if (root == null)
			return;
		stack.push(root);

		while (!stack.isEmpty()) {
			BinaryTreeNode curr = stack.pop();
			if (curr.leftNode != null || curr.rightNode != null) {
				BinaryTreeNode temp = curr.leftNode;
				curr.leftNode = curr.rightNode;
				curr.rightNode = temp;
			}

			if (curr.rightNode != null)
				stack.push(curr.rightNode);

			if (curr.leftNode != null)
				stack.push(curr.leftNode);

		}

	}
}
