package colin.sort;

import colin.common.StdIn;

/**
 * 希尔排序
 * 
 * @author ColinWang{wjdwjd@mail.com}
 * @date Feb 11, 2015
 */
public class Shell {

	private Shell() {

	}

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		int size = a.length;
		// 数组中任意间隔为h的元素都是有序的（h有序数组）
		int h = 1;
		// h的递增序列，数组规模越大则h也越大
		while (h < size / 3) {
			h = 3 * h + 1;
		}

		while (h >= 1) {
			// 将数组变为h有序，当数组为1有序的时候，则整个数组有序
			for (int i = h; i < size; i++) {
				// 将a[i]插入到a[i-h],a[i-2*h],a[i-3*h]...中
				for (int j = i; j >= h; j -= h) {
					if (SortUtil.less(a[j], a[j - h])) {
						SortUtil.swap(a, j, j - h);
					}
				}
			}
			// 将h缩小，插入排序对局部有序的小数组效率很高
			h = h / 3;
		}
	}

	public static void main(String[] args) {
		String[] data = StdIn.readAllStrings();
		Heap.sort(data);
		SortUtil.show(data);
	}
}
