/**
 * ①输入二叉树的根节点，求该树的深度（最长路径）
 * ②输入二叉树的根节点，判断该树是不是平衡树。（任意节点的左右子树的深度相差不超过1）
 */
package P;

import P.p6.BinaryTreeNode;

/**
 * @Shaun Rain 2014
 */
public class p39 {

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
		//n3.rightNode = n6;
		n5.leftNode = n7;

		System.out.println(getDeep(n1));
		System.out.println(flag);

	}

	public static int getDeep(BinaryTreeNode root) {

		if (root == null)
			return 0;

		int left = getDeep(root.leftNode);
		int right = getDeep(root.rightNode);

		if ((left > right && left - right > 1)
				|| (left < right && right - left > 1))
			flag = false;

		return left > right ? left + 1 : right + 1;
	}

}
