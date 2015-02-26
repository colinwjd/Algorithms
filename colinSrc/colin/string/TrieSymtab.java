/**
 * 
 */
package colin.string;

/**
 * 基于单词查找数的符号表
 * 
 * @author ColinWang{wjdwjd@live.cn}
 * @date Feb 26, 2015
 */
public class TrieSymtab<Value> {
	// 基数
	private static int R = 256;
	// 单词查找树的根节点
	private Node root;

	private static class Node {
		private Object value;
		private Node[] next = new Node[R];
	}

	@SuppressWarnings("unchecked")
	public Value get(String key) {
		Node x = get(root, key, 0);
		if (x == null)
			return null;
		return (Value) x.value;
	}

	private Node get(Node x, String key, int d) {
		if (x == null)
			return null;
		if (d == key.length())
			return x;
		char c = key.charAt(d);
		return get(x.next[c], key, d + 1);
	}

	public void put(String key, Value val) {
		root = put(root, key, val, 0);
	}

	private Node put(Node x, String key, Value val, int d) {
		if (x == null)
			x = new Node();
		if (d == key.length()) {
			x.value = val;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d + 1);
		return x;
	}
}
