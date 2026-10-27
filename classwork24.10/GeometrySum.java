public class GeometrySum {
	public static void main(String[] args) {
		System.out.println(sum(5, 8, 0.5));
	}

	public static double sum(double n, double b1, double q) {
		if (n == 0) return 0;
		double q2 = 1;
		for (int i = 0; i < n - 1; ++i) {
			q2 = q2 * q;
		}
		double bn = b1 * q2;
		return sum(n - 1, b1, q) + bn;
	}
}