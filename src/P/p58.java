/**
 * 给定一棵二叉树和其中一个点，如何找到中序遍历的下一个节点？
 */
package P;


/**
 * @Shaun Rain 2014
 */
class NewBinaryNode {
	NewBinaryNode parent;
	NewBinaryNode left;
	NewBinaryNode right;
	int value;

	public NewBinaryNode(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return value + "";
	}
}

public class p58 {

	public static void main(String[] args) {

		NewBinaryNode n1 = new NewBinaryNode(1);
		NewBinaryNode n2 = new NewBinaryNode(2);
		NewBinaryNode n3 = new NewBinaryNode(3);
		NewBinaryNode n4 = new NewBinaryNode(4);
		NewBinaryNode n5 = new NewBinaryNode(5);
		NewBinaryNode n6 = new NewBinaryNode(6);
		NewBinaryNode n7 = new NewBinaryNode(7);
		NewBinaryNode n8 = new NewBinaryNode(8);
		NewBinaryNode n9 = new NewBinaryNode(9);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n5.left = n8;
		n5.right = n9;
		
		System.out.println(findLDRNext(n3));
	}

	public static NewBinaryNode findLDRNext(NewBinaryNode node) {
		NewBinaryNode current = node;
		// 1.有右子树
		if (current.right != null) {
			current = current.right;
			while (current.left != null) {
				current = current.left;
			}
			return current;
		}
		// 2.无右子树，是父节点左节点
		if (current.right == null && current.parent.left == current)
			return current.parent;

		// 3.无右子树，是父节点的右节点
		if (current.right == null && current.parent.right == current) {
			while (current.parent.right == current && current.parent != null) {
				current = current.parent;
			}
			return current.parent;
		}

		return null;
	}
}
