package lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class encryption {

	public char temp = 0;

	
	public char[] keyColnArray = null;
	public char[] keyRowArray = null;

	public int[] IDlistColn = new int[5];
	public int[] IDlistRow = new int[5];
	public List<Character> text = new ArrayList<>();
	//Текст для проверки: ПриветМаксимКакТебяЗовут?
	// public static char[] alfavit = { 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
	// 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р',
	// 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я' };

	public char[] array = null;
	public char[][] mass = new char[5][5];

	public List<Character> Encrypt(String str ,String keyColn , String keyRow) {
		// Ваше предложение
		System.out.println("");
		array = str.toCharArray();
		// Выводим правильно ли мы разбили предложение
		int i = 0;
		//System.out.println(Arrays.toString(array));
		// Засовываем наше предложение в двумерный массив
		System.out.println("Двумерный массив выглядит так:");
		System.out.println(" ");		
		for (int y = 0; y < mass.length; y++) {
			for (int x = 0; x < mass[y].length; x++) {
				if (i < array.length) {
					mass[y][x] = array[i];
				}
				System.out.print(mass[y][x] + " ");
				i++;
			}
			System.out.println();
		}
		// Разбиваем первый ключ на буквы
		for (int k = 0; k < keyColn.length(); k++) {
			keyColnArray = keyColn.toCharArray();
			// Выводим правильно ли мы разбили предложение
			System.out.print(keyColnArray[k] + "  ");
		}
		System.out.println("");
		// Разбиваем второй ключ на буквы
		for (int k = 0; k < keyRow.length(); k++) {
			keyRowArray = keyRow.toCharArray();
			// Выводим правильно ли мы разбили предложение
			System.out.print(keyRowArray[k] + "  ");
		}
		System.out.println("");
		// Узнаем айди каждой буквы в первом ключе
		for (i = 0; i < keyColnArray.length; i++) {
			IDlistColn[i] = (int) keyColnArray[i];
			//System.out.print(+listColn[i] + "  ");
		}
		System.out.println("");

		// Узнаем айди каждой буквы во втором ключе
		for (i = 0; i < keyRowArray.length; i++) {
			IDlistRow[i] = (int) keyRowArray[i];
			//System.out.print(listRow[i] + "  ");
		}
		System.out.println("");
		// Шифрование и сортировка
		sortColn(IDlistColn, mass);
		// Вывод результата
		System.out.println("Вывод результата после перестановки колонок: ");
		System.out.println("");
		print(mass);
		
		sortRow(IDlistRow, mass);
		// вывод результата
		System.out.println("Вывод результата после перестановки строк: ");
		System.out.println("");
		print(mass);
		// Выводим двумерный массив после обработки первым ключем

		System.out.println("Зашифрованный текст: ");

		print(mass);
		//Добавляем шифрованный текст в list
		for (int y = 0; y < mass.length; y++) {
			for (int x = 0; x < mass[y].length; x++) {
				text.add(mass[y][x]);				
			}	
		}
		
		System.out.println("Выводим зашифрованный текст: ");
		for ( i = 0; i < text.size(); i++) {
			System.out.print(text.get(i));
		}		
		return text;
	}

	// Функция шифрует текст по первому ключу
	private char[][] sortRow(int listRow[], char mass[][]) {
		int tempTop = 0;
		for (int j = 0; j < listRow.length; j++) {
			for (int i = 0; i < listRow.length - 1; i++) {
				// System.out.println("Проход , смотрим i = " + i);
				// Проверяем больше ли следующее число в массиве
				if (listRow[i] > listRow[i + 1]) {
					// System.out.println("Это list[i] = " + list[i] + "> list[i+1] = " + list[i +
					// 1]);
					tempTop = listRow[i + 1];
					listRow[i + 1] = listRow[i];
					listRow[i] = tempTop;

					//System.out.println(Arrays.toString(listRow));
					// Меняем местами столбцы в двумерном массиве
					for (int coln = 0; coln < listRow.length; coln++) {
						// System.out.println("i =" + i + "i+1 =" + (i + 1));

						temp = mass[i][coln];
						mass[i][coln] = mass[i + 1][coln];
						mass[i + 1][coln] = temp;

					}
				
				}
			}

		}

		System.out.println(Arrays.toString(listRow));
		return mass;
	}

	// Функция шифрует текст по первому ключу
	private char[][] sortColn(int listColn[], char mass[][]) {
		int tempTop = 0;
		for (int j = 0; j < listColn.length; j++) {
			for (int i = 0; i < listColn.length - 1; i++) {
				// System.out.println("Проход , смотрим i = " + i);
				// Проверяем больше ли следующее число в массиве
				if (listColn[i] > listColn[i + 1]) {
					// System.out.println("Это list[i] = " + list[i] + "> list[i+1] = " + list[i +
					// 1]);
					tempTop = listColn[i + 1];
					listColn[i + 1] = listColn[i];
					listColn[i] = tempTop;

					//System.out.println(Arrays.toString(listColn));
					// Меняем местами столбцы в двумерном массиве
					for (int row = 0; row < listColn.length; row++) {
						// System.out.println("i =" + i + "i+1 =" + (i + 1));

						temp = mass[row][i];
						mass[row][i] = mass[row][i + 1];
						mass[row][i + 1] = temp;

					}
					

				}
			}

		}

		System.out.println(Arrays.toString(listColn));
		return mass;
	}
	//Выводим двумерный массив
	void print (char[][] mass) {
		for (int y = 0; y < mass.length; y++) {
			for (int x = 0; x < mass[y].length; x++) {
				System.out.print(mass[y][x] + " ");
			}
			System.out.println();
		}
	}

}
