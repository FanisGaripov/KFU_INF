public class Task1 {
	public static void main(String[] main) {
		String[] a = {"гарипов", "абдуллин", "сайфуллин"};
		bubbleSort(a);
		for (int i = 0; i < a.length; ++i) {
			System.out.println(a[i]);
		}
	}

	public static int compare(char a, char b) {
		if (a == 'ё' && b != 'ё') {
			if (b <= 'е') {
				return 1;
			} else {
				return -1;
			}
		}
		else if (a != 'ё' && b == 'ё') {
			if (a <= 'е') {
				return -1;
			} else {
				return 1;
			}
		}
		return a - b;
	}

	public static int compare(String a, String b) {
		int minLength = a.length() < b.length() ? a.length(): b.length();
		for (int i = 0; i < minLength; ++i) {
			int res = compare(a.charAt(i), b.charAt(i));
			if (res != 0) {
				return res;
			}
		}
		return a.length() - b.length();
	}

	public static void bubbleSort(String[] a) {
		for (int i = 0; i < a.length - 1; ++i) {
			for (int j = 0; j < a.length - 1; ++j) {
				if (compare(a[j], a[j + 1]) > 0) {
					String temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
}
// лексикографическая сортировка