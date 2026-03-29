//Yonatan Rubin
//M21105076
//Tree Lab - understanding different ways to traverse a tree

public class BinarySearchTree<T extends Comparable<T>> {

	private Node root;

	private class Node {
		T data;
		Node left;
		Node right;

		Node(T data) {
			this.data = data;
		}
	}

	// Public insert method
	public void insert(T value) {
		root = insertRecursive(root, value);
	}

	private Node insertRecursive(Node current, T value) {
		if (current == null) {
			return new Node(value);
		}

		int cmp = value.compareTo(current.data);

		if (cmp < 0) {
			current.left = insertRecursive(current.left, value);
		} else if (cmp > 0) {
			current.right = insertRecursive(current.right, value);
		}
		// If equal, do nothing (or handle duplicates however you want)

		return current;
	}

	// Inorder: Left --> Root --> Right
	public void inorder() {
		inorderRecursive(root);
		System.out.println();
	}

	private void inorderRecursive(Node current) {
		if (current == null)
			return;
		inorderRecursive(current.left);
		System.out.print(current.data + " ");
		inorderRecursive(current.right);
	}

	// Preorder: Root --> Left --> Right
	public void preorder() {
		preorderRecursive(root);
		System.out.println();
	}

	private void preorderRecursive(Node current) {
		if (current == null)
			return;
		System.out.print(current.data + " ");
		preorderRecursive(current.left);
		preorderRecursive(current.right);
	}

	// Postorder: Left --> Right --> Root
	public void postorder() {
		postorderRecursive(root);
		System.out.println();
	}

	private void postorderRecursive(Node current) {
		if (current == null)
			return;
		postorderRecursive(current.left);
		postorderRecursive(current.right);
		System.out.print(current.data + " ");
	}

	public void print3Orders() {
		System.out.print("preorder traversal\n");
		this.preorder();

		System.out.print("\ninorder traversal\n");
		this.inorder();

		System.out.print("\npostorder traversal\n");
		this.postorder();
	}

	public static void main(String[] args) {

		int insertArray[] = { 45, 38, 65, 34, 41, 63, 72, 16, 35, 39, 44, 55, 64 };
		BinarySearchTree<Integer> myTree = new BinarySearchTree<Integer>();

		for (int x : insertArray) {
			myTree.insert(x);
		}

		myTree.print3Orders();
	}
}