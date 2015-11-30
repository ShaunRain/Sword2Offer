/**
 * 判断一棵二叉树是否对称的。（和它的镜像是否一样）
 */
package P;

import P.p6.BinaryTreeNode;

/**
 * @Shaun Rain 2014
 */
public class p59 {

	public static void main(String[] args) {

		BinaryTreeNode n1 = new BinaryTreeNode(8);
		BinaryTreeNode n2 = new BinaryTreeNode(6);
		BinaryTreeNode n3 = new BinaryTreeNode(6);
		BinaryTreeNode n4 = new BinaryTreeNode(5);
		BinaryTreeNode n5 = new BinaryTreeNode(7);
		BinaryTreeNode n6 = new BinaryTreeNode(7);
		BinaryTreeNode n7 = new BinaryTreeNode(5);

		n1.leftNode = n2;
		n1.rightNode = n3;
		n2.leftNode = n4;
		n2.rightNode = n5;
		n3.leftNode = n6;
		n3.rightNode = n7;
		
		System.out.println(isMirror(n1));

	}

	public static boolean isMirror(BinaryTreeNode root) {

		return isMirror(root, root);
	}

	public static boolean isMirror(BinaryTreeNode n1, BinaryTreeNode n2) {

		if (n1 == null && n2 == null)
			return true;

		if (n1 == null || n2 == null)
			return false;

		if (n1.value != n2.value)
			return false;

		return isMirror(n1.leftNode, n2.rightNode)
				&& isMirror(n1.rightNode, n2.leftNode);

	}

}
