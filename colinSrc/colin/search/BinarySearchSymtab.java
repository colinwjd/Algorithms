package colin.search;

import colin.base.Queue;

/**
 * 基于两个平行数组实现的有序符号表
 * 
 * @author ColinWang{wjdwjd@live.cn}
 * @date Feb 15, 2015
 */
public class BinarySearchSymtab<Key extends Comparable<Key>, Value> {

	private Key[] keys;
	private Value[] values;
	private int size;

	@SuppressWarnings("unchecked")
	public BinarySearchSymtab(int cap) {
		keys = (Key[]) new Comparable[cap];
		values = (Value[]) new Object[cap];
	}

	public int size() {
		return size;
	}

	public Value get(Key key) {
		if (isEmpty()) {
			return null;
		}
		int count = rank(key);
		if (count < size && keys[count].compareTo(key) == 0) {
			return values[count];
		} else {
			return null;
		}
	}

	public void put(Key key, Value value) {
		// 取得小于key的键的数量
		int count = rank(key);
		if (count < size && keys[count].compareTo(key) == 0) {
			// 查询命中则替换
			values[count] = value;
		}
		for (int i = size; i > count; i--) {
			keys[i] = keys[i - 1];
			values[i] = values[i - 1];
		}
		keys[count] = key;
		values[count] = value;
		size++;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * 返回该键的排名（从零开始计数）
	 * 
	 * @param key
	 * @return
	 */
	public int rank(Key key) {
		int low = 0;
		int high = size - 1;
		while (low <= high) {
			int mid = (low + high) >> 1;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0) {
				high = mid - 1;
			} else if (cmp > 0) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return low;
	}

	public void delete(Key key) {
		put(key, null);
	}

	public Key min() {
		return keys[0];
	}

	public Key max() {
		return keys[size - 1];
	}

	/**
	 * 返回排名为k的键
	 * 
	 * @param k
	 * @return
	 */
	public Key select(int k) {
		return keys[k];
	}

	/**
	 * 向上取整，返回大于等于该键的最小键
	 * 
	 * @param key
	 * @return
	 */
	public Key ceiling(Key key) {
		int count = rank(key);
		return keys[count];
	}

	/**
	 * 向下取整，返回小于等于该键的最大键
	 * 
	 * @param key
	 * @return
	 */
	public Key floor(Key key) {
		int count = rank(key);
		return keys[count - 1];
	}

	public boolean contains(Key key) {
		return get(key) != null;
	}

	public Iterable<Key> keys(Key low, Key high) {
		Queue<Key> queue = new Queue<>();
		for (int i = rank(low); i < rank(high); i++) {
			queue.enqueue(keys[i]);
		}
		if (contains(high)) {
			queue.enqueue(keys[rank(high)]);
		}
		return queue;
	}
}
