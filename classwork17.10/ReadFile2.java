import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class ReadFile2 {
	static String[] words = new String[21000];
	static int[] counts = new int[21000];
	static int count = -1;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("Labirint.java"));
		int symbols = 0;
		int maxi_len = 0;
		int words_count = 0;
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			int len = line.length();
			String[] line_words = line.split(" ");
			if (maxi_len < len) {
				maxi_len = len;
			}
			symbols += len;
			words_count += line_words.length;

			for (int i = 0; i < line_words.length; ++i) {
				String clearedWord = clearWord(line_words[i]).toLowerCase();
				if (!clearedWord.isBlank()) {
					int index = findWord(clearedWord);
					if (index == -1) {
						words[++count] = clearedWord;
						counts[count] = 1;
					} else {
						counts[index] += 1;
					}
				}
			}
		}
		System.out.println("Количество символов: " + symbols);
		System.out.println("Максимальная длина строки: " + maxi_len);
		System.out.println("Количество слов (разделение через пробел): " + words_count);
		System.out.println("Список слов в формате - Слово: кол-во повторений");
		for (int i = 0; i < count + 1; ++i) {
			System.out.println(words[i] + ": " + counts[i]);
		}
	}

	static int findWord(String word) {
		String clearedWord = clearWord(word.toLowerCase());
		for (int i = 0; i < count + 1; ++i) {
			if (clearedWord.equals(words[i])) {
				return i;
			}
		}
		return -1;
	}

	static String clearWord(String word) {
		char[] clearedWord = new char[word.length()];
		int index = 0;
		for (int i = 0; i < word.length(); ++i) {
			if (!(word.charAt(i) == ' '
				|| word.charAt(i) == '.'
				|| word.charAt(i) == ','
				|| word.charAt(i) == ':'
				|| word.charAt(i) == '!'
				|| word.charAt(i) == '?'
				|| word.charAt(i) == ';'
				|| word.charAt(i) == '\t'
				|| word.charAt(i) == '{'
				|| word.charAt(i) == '}'
				)) {
				clearedWord[index++] = (char) word.charAt(i);
			}
		}
		return new String(clearedWord, 0, index);
	}
}
// P.S - этот файл ничем не отличается от ReadFile.java. Просто в этом файле убраны лишние куски кода в виде комментариев и само задание :)