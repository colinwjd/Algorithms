package colin.sort;

import colin.common.StdIn;

/**
 * 归并排序（自顶向下）
 * 
 * @author ColinWang{wjdwjd@mail.com}
 * @date Feb 11, 2015
 */
public class Merge {

	// 归并排序的辅助数组，避免了在每次归并时都创建一个新数组
	@SuppressWarnings("rawtypes")
	private static Comparable[] aux;

	private Merge() {
	}

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}

	@SuppressWarnings("rawtypes")
	private static void sort(Comparable[] a, int low, int high) {
		if (high <= low) {
			return;
		}
		int mid = (low + high) >> 1;
		// 将左边排序
		sort(a, low, mid);
		// 将右边排序
		sort(a, mid + 1, high);
		// 合并
		merge(a, low, mid, high);
	}

	@SuppressWarnings("rawtypes")
	private static void merge(Comparable[] a, int low, int mid, int high) {

		// 将a[low...high]复制到aux[low...high]
		for (int k = low; k <= high; k++) {
			aux[k] = a[k];
		}

		// 左右数组指针
		int left = low;
		int right = mid + 1;

		for (int k = low; k <= high; k++) {
			if (left > mid) {
				// 左半边元素取尽，将右边剩余元素放入原数组
				a[k] = aux[right++];
			} else if (right > high) {
				// 右边元素取尽，将左边剩余元素放入原数组
				a[k] = aux[left++];
			} else if (SortUtil.less(aux[left], aux[right])) {
				// 左边元素比右边元素小，取小者放入原数组
				a[k] = aux[left++];
			} else {
				a[k] = aux[right++];
			}
		}
	}

	public static void main(String[] args) {
		String[] data = StdIn.readAllStrings();
		Heap.sort(data);
		SortUtil.show(data);
	}
}
