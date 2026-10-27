public class Task3 {
	public static void main(String[] args) {
		System.out.println(T(10));
	}

	public static int T(int n) {
		if (n == 0) return 0;
		else if (n == 1) return 1;
		return 3 * T(n - 1) - 5 * T(n - 2);
	}
}