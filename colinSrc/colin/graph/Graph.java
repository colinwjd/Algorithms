package colin.graph;

import book.src.StdOut;
import colin.base.Bag;
import colin.common.In;

/**
 * 无向图的表示，邻接表表示法
 * 
 * @author ColinWang{wjdwjd@live.cn}
 * @date Feb 21, 2015
 */
public class Graph {
	// 顶点数目
	private final int V;
	// 边的数目
	private int E;
	// 邻接表
	private Bag<Integer>[] adj;

	@SuppressWarnings("unchecked")
	public Graph(int V) {
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[]) new Bag[V];
		// 把每一个链表初始化
		for (int i = 0; i < V; i++) {
			adj[i] = new Bag<>();
		}
	}

	public Graph(In in) {
		// 使用读取的V将图初始化
		this(in.readInt());
		// 读取边数
		int E = in.readInt();
		for (int i = 0; i < E; i++) {
			int v = in.readInt();
			int w = in.readInt();
			addEdge(v, w);
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	/**
	 * 取得和v相连的所有顶点
	 * 
	 * @param v
	 * @return
	 */
	public Iterable<Integer> adj(int v) {
		return adj[v];
	}

	@Override
	public String toString() {
		String s = V + " vertices," + E + " edges.\n";
		for (int v = 0; v < V; v++) {
			s += v + ": ";
			for (int w : this.adj(v)) {
				s += w + " ";
			}
			s += "\n";
		}
		return s;
	}

	public static void main(String[] args) {
		In in = new In(args[0]);
		Graph G = new Graph(in);
		StdOut.println(G);
	}
}
