package colin.sort;

import colin.common.StdIn;

/**
 * 快速排序
 * 
 * @author ColinWang{wjdwjd@mail.com}
 * @date Feb 11, 2015
 */
public class Quick {

	private Quick() {
	}

	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}

	@SuppressWarnings("rawtypes")
	private static void sort(Comparable[] a, int low, int high) {
		if (high <= low) {
			return;
		}

		// 对数组进行划分，每次划分后都能排好一个元素
		int p = partition(a, low, high);
		// 左半部分排序
		sort(a, low, p - 1);
		// 右半部分排序
		sort(a, p + 1, high);
	}

	@SuppressWarnings("rawtypes")
	private static int partition(Comparable[] a, int low, int high) {
		// 左右扫描指针
		int left = low;
		int right = high + 1;

		// 划分主元（根据这个元素对数组进行划分）
		Comparable key = a[low];
		while (true) {
			while (SortUtil.less(a[++left], key)) {
				if (left == high) {
					// 左边元素都小于主元
					break;
				}
			}
			while (SortUtil.less(key, a[--right])) {
				if (right == low) {
					// 右边元素都大于主元
					break;
				}
			}
			if (left >= right) {
				break;
			}
			// 左边元素大于主元，右边元素小于主元，将这个两个元素交换
			SortUtil.swap(a, left, right);
		}
		// 将key放入正确的位置
		SortUtil.swap(a, low, right);
		return right;
	}

	public static void main(String[] args) {
		String[] data = StdIn.readAllStrings();
		Heap.sort(data);
		SortUtil.show(data);
	}
}
