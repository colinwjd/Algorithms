package colin.sort;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class InsertionTest {

	@Test
	public void testSort() {
		String[] testStrings = new String[] { "S", "O", "R", "T", "E", "X",
				"A", "M", "P", "L", "E" };
		Insertion.sort(testStrings);
		SortUtil.show(testStrings);
		assertTrue(SortUtil.isSorted(testStrings));
		
		Integer[] testInts = new Integer[] { 1, 9, 9, 3, 1, 2, 1, 8 };
		Insertion.sort(testInts);
		SortUtil.show(testInts);
		assertTrue(SortUtil.isSorted(testInts));
	}

}
