/**
 * 根据二叉树两种遍历结果 恢复二叉树结构
 */
package P;

import java.util.Arrays;

public class p6 {

	static int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
	static int[] mid = { 4, 7, 2, 1, 5, 3, 8, 6 };
	static int[] lat = { 7, 4, 2, 5, 8, 6, 3, 1 };

	static class BinaryTreeNode {
		int value;
		BinaryTreeNode leftNode;
		BinaryTreeNode rightNode;

		public BinaryTreeNode(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return value + "";
		}
	}

	static BinaryTreeNode root = null;

	public static void main(String[] args) {
		BinaryTreeNode root = recoverML(mid, lat);
		traversal(root);
	}

	public static void traversal(BinaryTreeNode cur) {
		if (cur != null) {
			System.out.println(cur);
			traversal(cur.leftNode);
			traversal(cur.rightNode);
		}
	}

	public static BinaryTreeNode recoverPM(int[] pre, int[] mid) {
		int preLen = pre.length;
		int midLen = mid.length;
		if (preLen < 1 || midLen < 1)
			return null;
		BinaryTreeNode root = new BinaryTreeNode(pre[0]);
		System.out.println("root : " + root);
		int index = 0;
		for (int i = 0; i < mid.length; i++) {
			if (mid[i] == root.value) {
				index = i;
				break;
			}
		}
		if (index != 0) {
			int[] preLeft = Arrays.copyOfRange(pre, 1, index + 1);
			int[] midLeft = Arrays.copyOfRange(mid, 0, index);
			root.leftNode = recoverPM(preLeft, midLeft);
		} else {
			root.leftNode = null;
		}

		if (index < mid.length - 1) {
			int[] preRight = Arrays.copyOfRange(pre, index + 1, pre.length);
			int[] midRight = Arrays.copyOfRange(mid, index + 1, mid.length);
			root.rightNode = recoverPM(preRight, midRight);
		} else {
			root.rightNode = null;
		}

		return root;
	}

	public static void recoverPL(int[] pre, int[] lat) {
		// 构建的tree不唯一

	}

	public static BinaryTreeNode recoverML(int[] mid, int[] lat) {
		int lenMid = mid.length;
		int lenLat = lat.length;
		if (lenLat < 1 || lenMid < 1)
			return null;

		BinaryTreeNode root = new BinaryTreeNode(lat[lenLat - 1]);
		int index = 0;
		for (int i = 0; i < mid.length; i++) {
			if (mid[i] == root.value) {
				index = i;
				break;
			}
		}

		if (index != 0) {
			int[] midLeft = Arrays.copyOfRange(mid, 0, index);
			int[] latLeft = Arrays.copyOfRange(lat, 0, index);
			root.leftNode = recoverML(midLeft, latLeft);
		} else {
			root.leftNode = null;
		}

		if (index < mid.length - 1) {
			int[] midRight = Arrays.copyOfRange(mid, index + 1, mid.length);
			int[] latRight = Arrays.copyOfRange(lat, index, lat.length - 1);
			root.rightNode = recoverML(midRight, latRight);
		} else {
			root.rightNode = null;
		}

		return root;
	}
}
