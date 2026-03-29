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

	// wrapper insert method
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
		} else if (cmp >= 0) {
			current.right = insertRecursive(current.right, value);
		}

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

		System.out.println();
	}

	public static void main(String[] args) {

		int insertArray[] = { 45, 38, 65, 34, 41, 63, 72, 16, 35, 39, 44, 55, 64 };
		BinarySearchTree<Integer> myTree = new BinarySearchTree<Integer>();

		for (int x : insertArray) {
			myTree.insert(x);
		}

		myTree.print3Orders();

		// now for postfix, go left to right, putting stuff on the stack
		// when we get 2 numbers followed by an operator,
		// we calculate and put the result back on the stack
		// original equation
		// 48 7 2 % - 24 / 18 5 2 * - 12 + *
		//
		// 48 7 2 % (stop) - 24 / 18 5 2 * - 12 + *
		// 48 1 - (stop) 24 / 18 5 2 * - 12 + *
		// 47 24 / (stop) 18 5 2 * - 12 + *
		// now since integer and float will branch here, i need to do it twice,
		// int: 1 18 5 2 * (stop) - 12 + *
		// float: 1.958 18 5 2 * (stop) - 12 + *
		//
		// int: 1 18 10 - (stop) 12 + *
		// float: 1.958 18 10 - (stop) 12 + *
		//
		// int: 1 8 12 + (stop) *
		// float: 1.958 8 12 + (stop) *
		//
		// int: 1 20 * (stop)
		// float: 1.958 20 * (stop)
		//
		// int: 20
		// float: 39.16
		// tada
	}
}