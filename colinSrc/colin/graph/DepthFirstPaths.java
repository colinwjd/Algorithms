package colin.graph;

import colin.base.Stack;

/**
 * 路径查找，基于深度优先搜索
 * 
 * @author ColinWang{wjdwjd@live.cn}
 * @date Feb 22, 2015
 */
public class DepthFirstPaths {
	// 顶点是否已经访问过？
	private boolean[] marked;
	// 从起点到一个顶点的已知路径上的最后一个顶点
	private int[] edgeTo;
	// 起点
	private final int s;

	public DepthFirstPaths(Graph g, int s) {
		this.s = s;
		marked = new boolean[g.V()];
		edgeTo = new int[g.V()];
		dfs(g, s);
	}

	private void dfs(Graph g, int v) {
		marked[v] = true;
		// 遍历v的所有邻接点
		for (int w : g.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;
				dfs(g, w);
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
