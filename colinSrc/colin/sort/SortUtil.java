package colin.sort;

/**
 * 排序算法需要的工具函数
 * 
 * @author ColinWang{wjdwjd@mail.com}
 * @date Feb 11, 2015
 */
public class SortUtil {

	private SortUtil() {
	}

	// 比较两个元素的大小
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	// 交换数组中a[i]和a[j]
	public static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	@SuppressWarnings("rawtypes")
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("rawtypes")
	public static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
