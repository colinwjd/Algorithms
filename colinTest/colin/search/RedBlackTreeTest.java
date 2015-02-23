/**
 * 
 */
package colin.search;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author ColinWang{wjdwjd@live.cn}
 * @date Feb 23, 2015
 */
public class RedBlackTreeTest {

	private RedBlackTree<String,Integer> rbTree;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		rbTree = new RedBlackTree<>();
	}

	/**
	 * Test method for {@link colin.search.RedBlackTree#size()}.
	 */
	@Test
	public void testSize() {
		assertTrue(rbTree.size() == 0);
		rbTree.put("hello", 1);
		assertTrue(rbTree.size() == 1);
		rbTree.put("colin", 2);
		assertTrue(rbTree.size() == 2);
		rbTree.put("wang", 3);
		assertTrue(rbTree.size() == 3);
	}

	/**
	 * Test method for {@link colin.search.RedBlackTree#put(java.lang.Comparable, java.lang.Object)}.
	 */
	@Test
	public void testPut() {
		rbTree.put("hello", 1);
		rbTree.put("colin", 2);
		rbTree.put("wang", 3);
		assertTrue(rbTree.get("hello") == 1);
		assertTrue(rbTree.get("colin") == 2);
		assertTrue(rbTree.get("wang") == 3);
	}

	/**
	 * Test method for {@link colin.search.RedBlackTree#get(java.lang.Comparable)}.
	 */
	@Test
	public void testGet() {
		rbTree.put("hello", 1);
		rbTree.put("colin", 2);
		rbTree.put("wang", 3);
		assertTrue(rbTree.get("hello") == 1);
		assertTrue(rbTree.get("colin") == 2);
		assertTrue(rbTree.get("wang") == 3);
	}

	/**
	 * Test method for {@link colin.search.RedBlackTree#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(rbTree.isEmpty());
		rbTree.put("hello", 1);
		rbTree.put("colin", 2);
		rbTree.put("wang", 3);
		assertFalse(rbTree.isEmpty());
	}

	/**
	 * Test method for {@link colin.search.RedBlackTree#deleteMin()}.
	 */
	@Test
	public void testDeleteMin() {
		rbTree.put("hello", 1);
		rbTree.put("colin", 2);
		rbTree.put("wang", 3);
		assertEquals("colin", rbTree.min());
		rbTree.deleteMin();
		assertEquals("hello", rbTree.min());
		rbTree.deleteMin();
		assertEquals("wang", rbTree.min());
	}

	/**
	 * Test method for {@link colin.search.RedBlackTree#delete(java.lang.Comparable)}.
	 */
	@Test
	public void testDelete() {
		rbTree.put("hello", 1);
		rbTree.put("colin", 2);
		rbTree.put("wang", 3);
		assertTrue(rbTree.get("hello") == 1);
		assertTrue(rbTree.get("colin") == 2);
		assertTrue(rbTree.get("wang") == 3);
		rbTree.delete("hello");
		assertTrue(rbTree.get("hello") == null);
		rbTree.delete("colin");
		assertTrue(rbTree.get("colin") == null);
		rbTree.delete("wang");
		assertTrue(rbTree.get("wang") == null);
	}

	/**
	 * Test method for {@link colin.search.RedBlackTree#min()}.
	 */
	@Test
	public void testMin() {
		rbTree.put("hello", 1);
		rbTree.put("colin", 2);
		rbTree.put("wang", 3);
		assertEquals("colin", rbTree.min());
	}

}
