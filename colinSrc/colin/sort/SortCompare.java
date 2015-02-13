package colin.sort;

/**
 * 比较两种排序算法的性能
 * 
 * @author ColinWang{wjdwjd@live.cn}
 * @date Feb 13, 2015
 */
public class SortCompare {

	@SuppressWarnings("rawtypes")
	public static double time(String alg, Comparable[] a) {
		StopWatch timer = new StopWatch();

		switch (alg.toLowerCase()) {
		case "insertion":
			Insertion.sort(a);
			break;
		case "selection":
			Selection.sort(a);
			break;
		case "shell":
			Shell.sort(a);
			break;
		case "heap":
			Heap.sort(a);
			break;
		case "merge":
			Merge.sort(a);
			break;
		case "quick":
			Quick.sort(a);
			break;
		default:
			System.out.println("Not Support");
			break;
		}
		return timer.elapsedTime();
	}

	// 使用alg算法将count个长度为size的数组排序，计算总花费时间
	public static double timeRandomInput(String alg, int size, int count) {
		double total = 0.0;
		Double[] a = new Double[size];

		for (int i = 0; i < count; i++) {
			for (int j = 0; j < size; j++) {
				a[j] = StdRandom.uniform();
			}
			total += time(alg, a);
		}

		return total;
	}

	public static void main(String[] args) {
		String alg1 = args[0];
		String alg2 = args[1];
		int size = Integer.parseInt(args[2]);
		int count = Integer.parseInt(args[3]);
		double time1 = timeRandomInput(alg1, size, count);
		double time2 = timeRandomInput(alg2, size, count);

		System.out.println("For " + size + "random Doubles:");
		System.out
				.println(alg1 + " is " + time2 / time1 + " times faster than " + alg2);
	}
}
