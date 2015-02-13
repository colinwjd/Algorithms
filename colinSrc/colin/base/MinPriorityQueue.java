package colin.base;

/**
 * 小值优先队列，基于数组实现（可用于大量数据求TopM）
 * 
 * @author ColinWang{wjdwjd@mail.com}
 * @date Feb 12, 2015
 */
public class MinPriorityQueue<Key extends Comparable<Key>> {

	private Key[] keys;
	private int size;

	// 默认初始化队列容量为1
	public MinPriorityQueue() {
		this(1);
	}

	@SuppressWarnings("unchecked")
	public MinPriorityQueue(int cap) {
		keys = (Key[]) new Comparable[cap + 1];
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void insert(Key key) {
		if (size == keys.length) {
			int newSize = keys.length * 2; // or keys.length << 1;
			resize(newSize);
		}
		keys[++size] = key;
		swim(size);
	}

	@SuppressWarnings("unchecked")
	private void resize(int newSize) {
		Key[] newKeys = (Key[]) new Comparable[newSize];
		for (int i = 1; i <= size; i++) {
			newKeys[i] = keys[i];
		}
		keys = newKeys;
	}

	public Key min() {
		return keys[1];
	}

	public Key delMin() {
		Key min = keys[1];
		swap(1, size);
		keys[size] = null;
		size--;
		sink(1);
		if (size > 0 && size * 4 <= keys.length - 1) {
			int newSize = keys.length / 2;
			resize(newSize);
		}
		return min;
	}

	// 小元素上浮
	private void swim(int k) {
		while (k > 1 && less(k, k / 2)) {
			// 如果该元素不是根元素（根节点无父节点）:k>1
			// 该元素比父元素小，则交换
			swap(k, k / 2);
			k = k / 2;
		}
	}

	// 大元素下沉
	private void sink(int k) {
		while (2 * k <= size) {
			int child = 2 * k;
			if (child < size && less(child + 1, child)) {
				child++;
			}
			if (!less(child, k)) {
				break;
			}
			swap(k, child);
			k = child;
		}
	}

	private boolean less(int i, int j) {
		return keys[i].compareTo(keys[j]) < 0;
	}

	private void swap(int i, int j) {
		Key temp = keys[i];
		keys[i] = keys[j];
		keys[j] = temp;
	}
}
