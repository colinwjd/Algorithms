/**
 * 
 */
package colin.string;

/**
 * 低位优先的字符串排序算法，基于键索引计数法(稳定的)
 * 
 * @author ColinWang{wjdwjd@live.cn}
 * @date Feb 26, 2015
 */
public class LSD {
	/**
	 * 通过前w个字符，将a排序
	 * 
	 * @param a
	 * @param w
	 */
	public static void sort(String[] a, int w) {
		int N = a.length;
		int R = 256;
		// 建立辅助数组
		String[] aux = new String[N];

		// 根据第d个字符用键索引计数法排序
		for (int d = w - 1; d >= 0; d--) {
			int[] count = new int[R + 1];
			// 计算第d个字符的出现频率
			for (int i = 0; i < N; i++) {
				count[a[i].charAt(d) + 1]++;
			}
			// 将频率转换为起始索引
			for (int r = 0; r < R; r++) {
				count[r + 1] += count[r];
			}
			// 将数组a中的元素根据第d个字符分类
			for (int i = 0; i < N; i++) {
				aux[count[a[i].charAt(d)]++] = a[i];
			}
			// 把排序结果写入原数组中
			for (int i = 0; i < N; i++) {
				a[i] = aux[i];
			}
		}
	}
}
