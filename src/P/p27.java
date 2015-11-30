/**
 * 输入一棵二叉搜索树，将该二叉搜索树转化成一个排序的双向链表。要求不能创建新节点，只能调整树种节点的指针
 */
package P;

import P.p6.BinaryTreeNode;

/**
 * @Shaun Rain 2014
 */
public class p27 {

	public static void main(String[] args) {

		BinaryTreeNode t1 = new BinaryTreeNode(8);
		BinaryTreeNode t2 = new BinaryTreeNode(6);
		BinaryTreeNode t3 = new BinaryTreeNode(10);
		BinaryTreeNode t4 = new BinaryTreeNode(5);
		BinaryTreeNode t5 = new BinaryTreeNode(7);
		BinaryTreeNode t6 = new BinaryTreeNode(9);
		BinaryTreeNode t7 = new BinaryTreeNode(11);

		t1.leftNode = t2;
		t1.rightNode = t3;
		t2.leftNode = t4;
		t2.rightNode = t5;
		t3.leftNode = t6;
		t3.rightNode = t7;

		convertTree(t1);

	}

	public static void convertTree(BinaryTreeNode root) {

		BinaryTreeNode lastInList = null;
		convertNode(root, lastInList);
		while (root != null && root.leftNode != null)
			root = root.leftNode;

		while (root.rightNode != null) {
			System.out.print(root + " ");
			root = root.rightNode;
		}

	}

	public static BinaryTreeNode convertNode(BinaryTreeNode node,
			BinaryTreeNode lastInList) {

		if (node == null)
			return null;

		BinaryTreeNode curr = node;

		if (curr.leftNode != null)
			lastInList = convertNode(curr.leftNode, lastInList);

		curr.leftNode = lastInList;
		if (lastInList != null)
			lastInList.rightNode = curr;

		lastInList = curr;

		if (curr.rightNode != null)
			lastInList = convertNode(curr.rightNode, lastInList);

		return lastInList;

	}

}
