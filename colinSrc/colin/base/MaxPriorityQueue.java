package colin.base;

/**
 * 大值优先队列，基于数组实现
 * 
 * @author ColinWang{wjdwjd@mail.com}
 * @date Feb 12, 2015
 */
public class MaxPriorityQueue<Key extends Comparable<Key>> {

	private Key[] keys;
	private int size;

	// 保留位置0不使用
	private static final int INIT_CAPACITY = 11;

	public MaxPriorityQueue() {
		this(INIT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public MaxPriorityQueue(int cap) {
		keys = (Key[]) new Comparable[cap + 1];
	}

	@SuppressWarnings("unchecked")
	public MaxPriorityQueue(Key[] a) {
		int size = a.length;
		keys = (Key[]) new Comparable[size + 1];
		
	}

	public void insert(Key key) {
		if (size == keys.length -1) {
			int newSize = keys.length << 1;
			resize(newSize);
		}
		// 保留位置0不使用，从1开始插入
		keys[++size] = key;
		swim(size);
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int newSize){
		Key[] newKeys = (Key[]) new Comparable[newSize+1];
		for (int i = 1; i <= size; i++){
			newKeys[i] = keys[i];
		}
		keys = newKeys;
	}

	public Key max() {
		return keys[1];
	}

	public Key delMax() {
		Key max = keys[1];
		swap(1, size);
		// 防止对象游离，便于gc
		keys[size] = null;
		size--;
		sink(1);
		
		if (size > 0 && size << 2 <= keys.length - 1) {
			int newSize = keys.length >> 1;
			resize(newSize);
		}
		return max;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	// 由下至上的堆有序化（大元素上浮）
	private void swim(int k) {
		int parent = k >> 1;
		while (k > 1 && less(parent, k)) {
			// 该元素比父元素大，则交换
			swap(parent, k);
			k = parent;
		}
	}

	// 由上至下的堆有序化（小元素下沉）
	private void sink(int k) {
		// 孩子指针指向左孩子
		int child = k << 1;
		while (child <= size) {
			if (child < size && less(child, child + 1)) {
				// 右孩子比左孩子大时，孩子指针指向大者（右孩子）
				child++;
			}
			if (!less(k, child)) {
				// 当该元素不小于其两个孩子时，该元素已在堆中正确的位置
				break;
			}
			// 将该元素与比它大的孩子交换
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
