package lab1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class decryption {
	public char temp = 0;
	public int[] sortKeyColn = new int[5];;
	public int[] sortKeyRow = new int[5];;

	public char[] keyColnArray = null;
	public char[] keyRowArray = null;
	
	public int[] TempIDlistColn = new int[5];
	public int[] TempIDlistRow = new int[5];
	
	public int[] IDlistColn = new int[5];
	public int[] IDlistRow = new int[5];
	public List<Character> text = new ArrayList<>();
	// Текст для проверки: веиПракКимяЗбТексатМт?уов
	// public static char[] alfavit = { 'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
	// 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р',
	// 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я' };

	public char[] array = null;
	public char[][] mass = new char[5][5];
	public char[][] newmass = new char[5][5];
	public char[][] newmass3 = new char[5][5];


	public List<Character> Decryption(String str, String keyColn, String keyRow) {
		// Ваше предложение
		System.out.println("");
		array = str.toCharArray();
		// Выводим правильно ли мы разбили предложение
		int i = 0;
		// System.out.println(Arrays.toString(array));
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
			// System.out.print(+listColn[i] + " ");
		}
		System.out.println("");

		// Узнаем айди каждой буквы во втором ключе
		for (i = 0; i < keyRowArray.length; i++) {
			IDlistRow[i] = (int) keyRowArray[i];
			// System.out.print(listRow[i] + " ");
		}
		System.out.println("");
		// Шифрование и сортировка
		// Сортируем ключ по колонкам
		System.out.println("ДО:" + Arrays.toString(IDlistColn));
		System.out.println("Вывод результата после сортировки ключа по колонкам: ");
		TempIDlistColn = Arrays.copyOf(IDlistColn, IDlistColn.length);
		sortKeyColn = Arrays.copyOf(sortKey(IDlistColn), IDlistColn.length );
		IDlistColn = Arrays.copyOf(TempIDlistColn, TempIDlistColn.length);;

		// Сортируем ключ по строкам
		System.out.println("ДО: " + Arrays.toString(IDlistRow));
		System.out.println("Вывод результата после сортировки ключа по строкам: ");
		
		TempIDlistRow = Arrays.copyOf(IDlistRow, IDlistRow.length);
		sortKeyRow = Arrays.copyOf(sortKey(IDlistRow), IDlistRow.length );
		IDlistRow = Arrays.copyOf(TempIDlistRow, TempIDlistRow.length);
		
		// Сортируем по второму ключу
		mass = sortRow(IDlistRow, mass, sortKeyRow,newmass);
		print(newmass);
		// Сортируем по первому ключу
		newmass = sortColn(IDlistColn, newmass, sortKeyColn ,newmass3);
		print(newmass);
		
		
		
		
		// Выводим двумерный массив после обработки первым ключем
		System.out.println("Зашифрованный текст: ");
		print(newmass);
		
		// Добавляем шифрованный текст в list
		for (int y = 0; y < newmass.length; y++) {
			for (int x = 0; x < newmass[y].length; x++) {
				text.add(newmass[y][x]);
			}
		}

		System.out.println("Выводим зашифрованный текст: ");
		for (i = 0; i < text.size(); i++) {
			System.out.print(text.get(i));
		}
		return text;
	}

	// Функция шифрует текст по второму ключу
	private char[][] sortColn(int IDlistColn[], char newmass[][], int sortKeyColn[],char newmass3[][]) {
		
		System.out.println("Сортируем по колонкам");
		int tempTop = 0;
		for (int j = 0; j < IDlistColn.length; j++) {
			for (int i = 0; i < IDlistColn.length; i++) {
				// Проверяем больше ли следующее число в массиве
				System.out.println(Arrays.toString(IDlistColn));
				System.out.println(Arrays.toString(sortKeyColn));
				System.out.println("IDlistColn[j] = "+ IDlistColn[j] + " ;sortKeyColn[j] = "+ sortKeyColn[i]);
				if (IDlistColn[j] == sortKeyColn[i]) {
					System.out.println("Yes");
				
					// Меняем местами столбцы в двумерном массиве
					for (int row = 0; row < IDlistRow.length; row++) {
						// System.out.println("i =" + i + "i+1 =" + (i + 1));
						newmass3[row][j] = newmass[row][i];
					}
					print(newmass3);
				}
			}
		}
		System.out.println(Arrays.toString(IDlistColn));
		return newmass3;
	}

	// Функция шифрует текст по второму ключу
	private char[][] sortRow(int IDlistRow[], char mass[][], int sortKeyRow[] , char newmass[][]) {
		
		System.out.println("Сортируем по строкам");
		int tempTop = 0;
		for (int j = 0; j < IDlistRow.length; j++) {
			for (int i = 0; i < IDlistRow.length; i++) {
				System.out.println(Arrays.toString(IDlistRow));
				System.out.println(Arrays.toString(sortKeyRow));
				System.out.println("IDlistRow[j] = "+ IDlistRow[j] + " ;sortKeyRow[j] = "+ sortKeyRow[i]);
				// Проверяем больше ли следующее число в массиве
				if (IDlistRow[j] == sortKeyRow[i]) {
					System.out.println("Yes");
					
					// Меняем местами столбцы в двумерном массиве
					for (int coln = 0; coln < IDlistColn.length; coln++) {
						// System.out.println("i =" + i + "i+1 =" + (i + 1));
						
						newmass[j][coln] = mass[i][coln];
				

					}
					print(newmass);
				}
			}

		}
		
		
		
		
		System.out.println(Arrays.toString(IDlistRow));
		return newmass;
	}

	// Функция cортировки ключей
	private int[] sortKey(int IDlist[]) {
		int tempTop = 0;
		for (int j = 0; j < IDlist.length; j++) {
			for (int i = 0; i < IDlist.length - 1; i++) {
				// System.out.println("Проход , смотрим i = " + i);
				// Проверяем больше ли следующее число в массиве
				if (IDlist[i] > IDlist[i + 1]) {
					// System.out.println("Это list[i] = " + list[i] + "> list[i+1] = " + list[i +
					// 1]);
					tempTop = IDlist[i + 1];
					IDlist[i + 1] = IDlist[i];
					IDlist[i] = tempTop;
				}
			}

		}

		System.out.println(Arrays.toString(IDlist));
		return IDlist;
	}

	// Выводим двумерный массив
	void print(char[][] mass) {
		for (int y = 0; y < mass.length; y++) {
			for (int x = 0; x < mass[y].length; x++) {
				System.out.print(mass[y][x] + " ");
			}
			System.out.println();
		}
	}

}
