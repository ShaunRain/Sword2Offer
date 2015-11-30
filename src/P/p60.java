/**
 * ´òÓ¡¶þ²æÊ÷
 * 8
 * 6 10
 * 5 7 9 11
 */
package P;

import java.util.LinkedList;
import java.util.Queue;

import P.p6.BinaryTreeNode;

/**
 * @Shaun Rain 2014
 */
public class p60 {

	public static void main(String[] args) {
		BinaryTreeNode n1 = new BinaryTreeNode(1);
		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(3);
		BinaryTreeNode n4 = new BinaryTreeNode(4);
		BinaryTreeNode n5 = new BinaryTreeNode(5);
		BinaryTreeNode n6 = new BinaryTreeNode(6);
		BinaryTreeNode n7 = new BinaryTreeNode(7);
		BinaryTreeNode n8 = new BinaryTreeNode(8);
		BinaryTreeNode n9 = new BinaryTreeNode(9);
		BinaryTreeNode n10 = new BinaryTreeNode(10);
		BinaryTreeNode n11 = new BinaryTreeNode(11);
		BinaryTreeNode n12 = new BinaryTreeNode(12);
		n1.leftNode = n2;
		n1.rightNode = n3;
		n2.leftNode = n4;
		n2.rightNode = n5;
		//n3.leftNode = n6;
		n3.rightNode = n7;
		n5.leftNode = n9;
		n7.leftNode = n10;
		n7.rightNode = n11;

		printTree(n1);
	}

	public static void printTree(BinaryTreeNode root) {

		Queue<BinaryTreeNode> queue = new LinkedList<>();
		queue.add(root);
		printNode(queue, 1, 0);
	}

	public static void printNode(Queue<BinaryTreeNode> queue, int notPrint,
			int nextLevel) {

		if (queue.isEmpty())
			return;
		if (notPrint == 0) {
			notPrint = nextLevel;
			nextLevel = 0;
			System.out.println();
		}
		BinaryTreeNode top = queue.remove();
		if (top.value == -1)
			System.out.print("  ");
		else
			System.out.print(top + " ");
		notPrint--;
		if ((top.leftNode != null) || (top.rightNode != null)) {
			if (top.leftNode == null) {
				top.leftNode = new BinaryTreeNode(-1);
			}
			if (top.rightNode == null) {
				top.rightNode = new BinaryTreeNode(-1);
			}
			queue.add(top.leftNode);
			nextLevel++;
			queue.add(top.rightNode);
			nextLevel++;
		}

		printNode(queue, notPrint, nextLevel);
	}

}
