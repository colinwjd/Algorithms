package colin.search;

/**
 * 红黑二叉查找树（红节点和指向它的父节点可类比2-3树中的3-节点）
 * 
 * @author ColinWang{wjdwjd@live.cn}
 * @date Feb 17, 2015
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
	private Node root;

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	// 含有color变量的Node对象
	private class Node {
		Key key;
		Value value;
		Node left;
		Node right;
		// 以这个结点为根的树中的结点总数
		int size;
		// 该结点的颜色（其父结点指向它的链接的颜色）
		boolean color;

		Node(Key key, Value value, int size, boolean color) {
			this.key = key;
			this.value = value;
			this.size = size;
			this.color = color;
		}
	}

	private boolean isRed(Node x) {
		if (x == null)
			return false;
		return x.color == RED;
	}

	// 将参数结点的右链接向左旋转（逆时针）
	private Node rotateLeft(Node h) {
		// 暂存h的右结点为x
		Node x = h.right;
		// h的右链接指向x的左结点
		h.right = x.left;
		// x的左链接指向h（将h变为x的左子结点）
		x.left = h;

		x.color = h.color;
		h.color = RED;

		// x和h交换了位置，总结点数不变
		x.size = h.size;
		// h变为了x的子结点，需要重新计算结点数
		h.size = size(h.left) + size(h.right) + 1;
		return x;
	}

	// 红链接右旋
	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;

		x.color = h.color;
		h.color = RED;

		x.size = h.size;
		h.size = size(h.left) + size(h.right) + 1;
		return x;
	}

	// 将一个结点的两个红色子链接变为黑色
	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}

	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null)
			return 0;
		else
			return x.size;
	}

	/**
	 * 查找key值，找到则更新其值，否则为它新建一个结点
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		root = put(root, key, value);
		root.color = BLACK;
	}

	private Node put(Node h, Key key, Value value) {
		if (h == null)
			// 标准插入操作，用红链接和父结点相连
			return new Node(key, value, 1, RED);
		int cmp = key.compareTo(h.key);
		if (cmp < 0)
			h.left = put(h.left, key, value);
		else if (cmp > 0)
			h.right = put(h.right, key, value);
		else
			h.value = value;

		if (isRed(h.right) && !isRed(h.left))
			// 如果右链接是红色的，左链接是黑色的，则左旋
			h = rotateLeft(h);
		if (isRed(h.left) && isRed(h.left.left))
			// 如果左链接是红色，并且左结点的左链接也是红色（连续红链接），则右旋
			h = rotateRight(h);
		if (isRed(h.left) && isRed(h.right))
			// 如果两条子链接都是红色的，则进行颜色变换
			flipColors(h);
		
		h.size = size(h.left) + size(h.right) + 1;
		return h;
	}
	
	public Value get(Key key) {
		return get(root, key);
	}
	
	private Value get(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.value;
	}
}
