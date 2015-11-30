/**
 * ����һ�ö�������һ����������ӡ�������нڵ�ֵ�ĺ�Ϊ��������������·��
 */
package P;

import java.util.Stack;

import P.p6.BinaryTreeNode;

/**
 * @Shaun Rain 2014
 */
public class p25 {

	public static void main(String[] args) {

		BinaryTreeNode b1 = new BinaryTreeNode(10);
		BinaryTreeNode b2 = new BinaryTreeNode(5);
		BinaryTreeNode b3 = new BinaryTreeNode(12);
		BinaryTreeNode b4 = new BinaryTreeNode(4);
		BinaryTreeNode b5 = new BinaryTreeNode(7);

		b1.leftNode = b2;
		b1.rightNode = b3;
		b2.leftNode = b4;
		b2.rightNode = b5;
		
		PrintPath(b1, 22);

	}

	public static void PrintPath(BinaryTreeNode root, int sum) {

		if (root == null)
			return;
		int count = 0;
		Stack<BinaryTreeNode> stack = new Stack<>();
		findPath(stack, root, sum, count);
	}

	public static void findPath(Stack<BinaryTreeNode> stack,
			BinaryTreeNode curr, int sum, int count) {
		count += curr.value;
		stack.push(curr);
		// �����Ҷ�ӽڵ�
		if (curr.leftNode == null && curr.rightNode == null)
			if (count == sum) {
				System.out.println("find a path:");
				for (BinaryTreeNode node : stack)
					System.out.print(node + " ");
				System.out.println();
			}
		// ��Ҷ�ӽڵ�
		if (curr.leftNode != null)
			findPath(stack, curr.leftNode, sum, count);
		if (curr.rightNode != null)
			findPath(stack, curr.rightNode, sum, count);

		// ���ظ��ڵ�֮ǰ����·����ɾ����ǰ�ڵ�
		stack.pop();

	}

}
