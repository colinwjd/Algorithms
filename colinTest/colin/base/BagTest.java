package colin.base;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BagTest {

	private Bag<Integer> bag;
	
	@Before
	public void setup(){
		bag = new Bag<>();
	}
	
	@Test
	public void testAdd() {
		bag.add(1);
		bag.add(2);
		assertTrue(bag.size() == 2);
	}

	@Test
	public void testIsEmpty() {
		assertTrue(bag.isEmpty());
	}

	@Test
	public void testSize() {
		bag.add(1);
		bag.add(2);
		assertTrue(bag.size() == 2);
	}

	@Test
	public void testIterator() {
		bag.add(1);
		bag.add(2);
		bag.add(4);
		bag.add(3);
		for (Integer integer : bag) {
			System.out.println(integer);
		}
	}

}
