package colin.search;

/**
 * 无序符号表，基于链表实现
 * 
 * @author ColinWang{wjdwjd@live.cn}
 * @date Feb 20, 2015
 */
public class SequentialSearchSymtab<Key, Value> {
	private Node first;
	private int size;

	private class Node {
		Key key;
		Value value;
		Node next;

		public Node(Key key, Value value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	public Value get(Key key) {
		for (Node i = first; i != null; i = i.next) {
			if (key.equals(i.key))
				return i.value;
		}
		return null;
	}

	public void put(Key key, Value value) {
		for (Node i = first; i != null; i = i.next) {
			if (key.equals(i.key)) {
				i.value = value;
				return;
			}
		}
		first = new Node(key, value, first);
		size++;
	}

	public int size() {
		return size;
	}
}
