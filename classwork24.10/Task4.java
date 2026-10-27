public class Task4 {
	public static void main(String[] args) {
		cifr(345427287);
	}

	public static void cifr(int m) {
		if (m < 10) {
			System.out.print(m + " ");
		} else {
			cifr(m / 10);
			System.out.print(m % 10 + " "); 
		}
	}
}