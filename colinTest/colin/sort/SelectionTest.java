package colin.sort;

import org.junit.Test;

public class SelectionTest {

	@Test
	public void testSort() {
		String[] testStrings = new String[] { "S", "O", "R", "T", "E", "X",
				"A", "M", "P", "L", "E" };
		Selection.sort(testStrings);
		SortUtil.show(testStrings);

		Integer[] testInts = new Integer[] { 1, 9, 9, 3, 1, 2, 1, 8 };
		Selection.sort(testInts);
		SortUtil.show(testInts);
	}

}
