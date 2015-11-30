/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构
 */
package P;

import P.p6.BinaryTreeNode;

/**
 * @Shaun Rain 2014
 */

public class p18 {

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

		BinaryTreeNode B1 = new BinaryTreeNode(8);
		BinaryTreeNode B2 = new BinaryTreeNode(9);
		BinaryTreeNode B3 = new BinaryTreeNode(2);
		B1.leftNode = B2;
		B1.rightNode = B3;

		System.out.println(isSon(A1, B1));

	}

	public static boolean isSon(BinaryTreeNode b1, BinaryTreeNode b2) {
		boolean result = false;

		if (b1 != null && b2 != null) {
			if (b1.value == b2.value)
				result = isHave(b1, b2);
			if (!result)
				result = isSon(b1.leftNode, b2);
			if (!result)
				result = isSon(b1.rightNode, b2);
		}

		return result;
	}

	public static boolean isHave(BinaryTreeNode b1, BinaryTreeNode b2) {

		if (b2 == null)
			return true;
		if (b1 == null)
			return false;
		if (b1.value != b2.value)
			return false;

		return isHave(b1.leftNode, b2.leftNode)
				&& isHave(b1.rightNode, b2.rightNode);
	}

}
