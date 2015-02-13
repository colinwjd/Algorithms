package colin.sort;

import colin.common.StdIn;

/**
 * 插入排序
 * 
 * @author ColinWang{wjdwjd@mail.com}
 * @date Feb 11, 2015
 */
public class Insertion {
	private Insertion() {
	}

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		int size = a.length;
		for (int i = 1; i < size; i++) {
			// 寻找插入位置（从后向前）
			for (int j = i; j > 0; j--) {
				if (SortUtil.less(a[j], a[j - 1])) {
					SortUtil.swap(a, j, j - 1);
				}
			}
		}
	}

	public static void main(String[] args) {
		String[] data = StdIn.readAllStrings();
		Heap.sort(data);
		SortUtil.show(data);
	}
}
