package colin.search;

/**
 * 散列表，基于拉链法
 * 
 * @author ColinWang{wjdwjd@live.cn}
 * @date Feb 20, 2015
 */
public class SeparateChainingHashSymtab<Key, Value> {
	// 散列表容量
	private int cap;
	// 存放每个链表对象的数组
	private SequentialSearchSymtab<Key, Value>[] symtabs;

	public SeparateChainingHashSymtab() {
		this(97);
	}

	@SuppressWarnings("unchecked")
	public SeparateChainingHashSymtab(int cap) {
		this.cap = cap;
		symtabs = (SequentialSearchSymtab<Key, Value>[]) new SequentialSearchSymtab[cap];
		for (int i = 0; i < cap; i++) {
			// 为每个散列值新建一个“桶”
			symtabs[i] = new SequentialSearchSymtab<Key, Value>();
		}
	}

	private int hash(Key key) {
		// 屏蔽符号位，将一个32位整数变成一个31位负整数
		// 再利用除留余数法，将值散列到0到cap-1之间
		return (key.hashCode() & 0x7fffffff) % cap;
	}

	public Value get(Key key) {
		// “桶”的索引
		int index = hash(key);
		// 在对应的“桶”中取出value
		Value value = symtabs[index].get(key);
		return value;
	}
	
	public void put(Key key, Value value) {
		int index = hash(key);
		symtabs[index].put(key, value);
	}
}
