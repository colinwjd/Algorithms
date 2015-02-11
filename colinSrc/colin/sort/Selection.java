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
				if (SortUtil.less(a[j], a[minIndex])) {
					minIndex = j;
				}
			}
			SortUtil.swap(a, i, minIndex);
		}
		assert SortUtil.isSorted(a);
	}

	

	public static void main(String[] args) {
		String[] testStrings = new String[]{"S","O","R","T","E","X","A","M","P","L","E"};
		Selection.sort(testStrings);
		SortUtil.show(testStrings);
		
		Integer[] testInts = new Integer[]{1,9,9,3,1,2,1,8};
		Selection.sort(testInts);
		SortUtil.show(testInts);
	}
}
