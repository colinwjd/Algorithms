package colin.graph;

/**
 * 深度优先搜索
 * 
 * @author ColinWang{wjdwjd@live.cn}
 * @date Feb 22, 2015
 */
public class DepthFirstSearch {
	private boolean[] marked;
	private int count;

	public DepthFirstSearch(Graph g, int s) {
		marked = new boolean[g.V()];
		dfs(g, s);
	}

	private void dfs(Graph g, int v) {
		marked[v] = true;
		count++;
		for (int w : g.adj(v)) {
			if (!marked[w])
				dfs(g, w);
		}
	}

	public boolean marked(int v) {
		return marked[v];
	}

	public int count() {
		return count;
	}
}
