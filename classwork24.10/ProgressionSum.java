public class ProgressionSum {
	public static void main(String[] args) {
		System.out.println(sum(1, 3, 2));
	}

	public static int sum(int n, int p, int r) {
		if (n == 0) return 0;
		else if (n == 1) return p;
		int a_n = p + r * (n - 1);
		return sum(n - 1, p, r) + a_n;
	}
}