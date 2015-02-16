package colin.search;

/**
 * 基于二叉查找树的符号表（递归实现）
 * 
 * @author ColinWang{wjdwjd@live.cn}
 * @date Feb 15, 2015
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	private Node root;

	// 树的节点
	private class Node {
		private Key key;
		private Value value;
		// 左子树和右子树指针
		private Node left, right;
		// 以该节点为根节点的树中的节点总数
		private int count;

		public Node(Key key, Value value, int count) {
			this.key = key;
			this.value = value;
			this.count = count;
		}
	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null) {
			return 0;
		} else {
			return node.count;
		}
	}

	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node root, Key key) {
		if (root == null) {
			return null;
		}
		// 将该键与跟根节点的键比较
		int cmp = key.compareTo(root.key);
		if (cmp < 0) {
			// 该键小于根节点，则继续在左子树中查找
			return get(root.left, key);
		} else if (cmp > 0) {
			// 该键大于跟节点，则继续在右子树中查找
			return get(root.right, key);
		} else {
			// 该键等于跟节点，则返回跟节点的值
			return root.value;
		}
	}

	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	private Node put(Node root, Key key, Value value) {
		if (root == null) {
			return new Node(key, value, 1);
		}
		// 在提供的树中查找key值，存在则替换，否则新建Node
		int cmp = key.compareTo(root.key);
		if (cmp < 0)
			root.left = put(root.left, key, value);
		else if (cmp > 0)
			root.right = put(root.right, key, value);
		else
			root.value = value;
		root.count = size(root.left) + size(root.right) + 1;
		return root;
	}

	public Key min() {
		return min(root).key;
	}

	private Node min(Node root) {
		if (root.left == null) {
			return root;
		} else {
			return min(root.left);
		}
	}

	/**
	 * 向下取整，返回小于该键的最大键
	 * 
	 * @param key
	 * @return
	 */
	public Key floor(Key key) {
		Node temp = floor(root, key);
		if (temp == null)
			return null;
		return temp.key;
	}

	private Node floor(Node root, Key key) {
		if (root == null)
			return null;
		int cmp = key.compareTo(root.key);
		if (cmp == 0)
			return root;
		if (cmp < 0)
			return floor(root.left, key);
		Node temp = floor(root.right, key);
		if (temp != null)
			return temp;
		else
			return root;
	}

	public Key select(int k) {
		return select(root, k).key;
	}

	private Node select(Node root, int k) {
		if (root == null)
			return null;
		// 左子树的大小
		int t = size(root.left);
		if (t > k)
			// 左子树比给出的排名大，即给出的排名（从0计数）包含在左子树中
			return select(root.left, k);
		else if (t < k)
			return select(root.right, k - t - 1);
		else
			return root;
	}

	public int rank(Key key) {
		return rank(root, key);
	}

	private int rank(Node root, Key key) {
		// 计算root中key的排名，从0计数
		if (root == null)
			return 0;
		int cmp = key.compareTo(root.key);
		if (cmp < 0)
			return rank(root.left, key);
		else if (cmp > 0)
			return rank(root.right, key) + size(root.left) + 1;
		else
			return size(root.left);
	}
}
