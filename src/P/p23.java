/**
 * 从上往下打印二叉树的每一个节点
 * (广度优先遍历二叉树)
 */
package P;

import java.util.LinkedList;
import java.util.Queue;
import P.p6.BinaryTreeNode;

/**
 * @Shaun Rain 2014
 */
public class p23 {

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

		PrintTree(t1);

	}

	public static void PrintTree(BinaryTreeNode root) {

		Queue<BinaryTreeNode> queue = new LinkedList<>();
		BinaryTreeNode curr = root;
		queue.offer(curr);
		while (queue.size() > 0) {

			curr = queue.remove();
			System.out.print(curr + " ");
			if (curr.leftNode != null)
				queue.offer(curr.leftNode);
			if (curr.rightNode != null)
				queue.offer(curr.rightNode);

		}

	}

}
