// домашнее задание с лекции Абрамского М.М
// переписать функцию подсчета чисел фиббоначи через мемоизацию
import java.util.Arrays;
import java.util.Scanner;


public class Homework {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введите число n для поиска n-ого числа Фиббоначи: ");
		// впринципе максимум для int это 46, т.к 47 число превышает 2^16 и идут отрицательные числа
		int n = sc.nextInt();
		System.out.println(fib(n));
	}

	public static int fib(int n) {
		int[] f = new int[n];
		if (n == 1 || n == 2) {
			return 1;
		} else {
			f[0] = 1;
			f[1] = 1;
			for (int i = 2; i < n; ++i) {
				f[i] = f[i - 1] + f[i - 2];
			}
			System.out.println(Arrays.toString(f)); // метод с лекции
			return f[n - 1];
		}
	}
}