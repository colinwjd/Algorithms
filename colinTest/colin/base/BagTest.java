package colin.base;

import static org.junit.Assert.*;

import org.junit.Test;

public class BagTest {

	@Test
	public void testAdd() {
		Bag<Integer> bag = new Bag<>();
		bag.add(1);
		bag.add(2);
		assertTrue(bag.size() == 2);
	}

	@Test
	public void testIsEmpty() {
		Bag<Integer> bag = new Bag<>();
		assertTrue(bag.isEmpty());
	}

	@Test
	public void testSize() {
		Bag<Integer> bag = new Bag<>();
		bag.add(1);
		bag.add(2);
		assertTrue(bag.size() == 2);
	}

	@Test
	public void testIterator() {
		Bag<Integer> bag = new Bag<>();
		bag.add(1);
		bag.add(2);
		bag.add(4);
		bag.add(3);
		for (Integer integer : bag) {
			System.out.println(integer);
		}
	}

}
