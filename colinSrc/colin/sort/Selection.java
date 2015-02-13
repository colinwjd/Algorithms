package colin.sort;

import colin.common.StdIn;

/**
 * 选择排序
 * 
 * @author ColinWang{wjdwjd@mail.com}
 * @date Feb 11, 2015
 */
public class Selection {

	private Selection() {
	}

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		int size = a.length;
		for (int i = 0; i < size; i++) {
			int minIndex = i;
			// 从剩余元素中找出最小元素
			for (int j = i + 1; j < size; j++) {
				if (SortUtil.less(a[j], a[minIndex])) {
					minIndex = j;
				}
			}
			SortUtil.swap(a, i, minIndex);
		}
	}

	public static void main(String[] args) {
		String[] data = StdIn.readAllStrings();
		Heap.sort(data);
		SortUtil.show(data);
	}

}
