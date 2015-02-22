package colin.graph;

import colin.base.Queue;
import colin.base.Stack;

/**
 * 广度优先搜索
 * 
 * @author ColinWang{wjdwjd@live.cn}
 * @date Feb 22, 2015
 */
public class BreadthFirstPath {
	// 顶点是否已经访问过？
	private boolean[] marked;
	// 从起点到一个顶点的已知路径上的最后一个顶点
	private int[] edgeTo;
	// 起点
	private final int s;

	public BreadthFirstPath(Graph g, int s) {
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		this.s = s;
		bfs(g, s);
	}

	/*
	 * 广度优先遍历和深度优先遍历的不同之处仅在于数据结构中获取下一个顶点的规则，
	 * 广度优先遍历是获取最早加入的顶点，所以使用队列这种数据结构，最早加入的顶点最早出队。
	 * 深度优先遍历是获取最晚加入的顶点，所以使用栈这种数据结构，最后入栈的顶点最先出栈。
	 */
	private void bfs(Graph g, int s) {
		Queue<Integer> queue = new Queue<>();
		// 访问起点s，并将s加入队列
		marked[s] = true;
		queue.enqueue(s);
		while (!queue.isEmpty()) {
			// 取出队头元素，即先入队的元素
			int v = queue.dequeue();
			// 遍历该顶点的所有邻接点
			for (int w : g.adj(v)) {
				// 如果它的邻接点还没有被访问
				if (!marked[w]) {
					edgeTo[w] = v;
					marked[w] = true;
					// 访问该邻接点之后将其加入队列
					queue.enqueue(w);
				}
			}
		}
	}

	public boolean hasPathTo(int v) {
		return marked[v];
	}

	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<>();
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}
}
