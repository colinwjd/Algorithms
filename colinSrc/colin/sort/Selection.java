package colin.sort;

/**
 * 插入排序
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
				if (less(a[j], a[minIndex])) {
					minIndex = j;
				}
			}
			swap(a, i, minIndex);
		}
	}

	// 比较两个元素的大小
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	// 交换数组中a[i]和a[j]
	private static void swap(Object[] a, int i, int j) {
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
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		String[] testStrings = new String[]{"S","O","R","T","E","X","A","M","P","L","E"};
		Selection.sort(testStrings);
		show(testStrings);
		
		Integer[] testInts = new Integer[]{1,9,9,3,1,2,1,8};
		Selection.sort(testInts);
		show(testInts);
	}
}
