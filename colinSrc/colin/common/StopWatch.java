package colin.common;

/**
 * 一种计时器（停表）
 * 
 * @author ColinWang{wjdwjd@live.cn}
 * @date Feb 13, 2015
 */
public class StopWatch {
	
	private final long start;

	public StopWatch() {
		start = System.currentTimeMillis();
	}

	/**
	 * 返回自该计时器创建以来到调用该方法时经过的秒数
	 * 
	 * @return
	 */
	public double elapsedTime() {
		long now = System.currentTimeMillis();
		long period = now - start;
		return period / 1000.0;
	}

}
