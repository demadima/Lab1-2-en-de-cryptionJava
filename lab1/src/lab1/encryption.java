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
	//����� ��� ��������: ������������������������?
	// public static char[] alfavit = { '�', '�', '�', '�', '�', '�', '�', '�', '�',
	// '�', '�', '�', '�', '�', '�', '�', '�', '�',
	// '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�' };

	public char[] array = null;
	public char[][] mass = new char[5][5];

	public List<Character> Encrypt(String str ,String keyColn , String keyRow) {
		// ���� �����������
		System.out.println("");
		array = str.toCharArray();
		// ������� ��������� �� �� ������� �����������
		int i = 0;
		//System.out.println(Arrays.toString(array));
		// ���������� ���� ����������� � ��������� ������
		System.out.println("��������� ������ �������� ���:");
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
		// ��������� ������ ���� �� �����
		for (int k = 0; k < keyColn.length(); k++) {
			keyColnArray = keyColn.toCharArray();
			// ������� ��������� �� �� ������� �����������
			System.out.print(keyColnArray[k] + "  ");
		}
		System.out.println("");
		// ��������� ������ ���� �� �����
		for (int k = 0; k < keyRow.length(); k++) {
			keyRowArray = keyRow.toCharArray();
			// ������� ��������� �� �� ������� �����������
			System.out.print(keyRowArray[k] + "  ");
		}
		System.out.println("");
		// ������ ���� ������ ����� � ������ �����
		for (i = 0; i < keyColnArray.length; i++) {
			IDlistColn[i] = (int) keyColnArray[i];
			//System.out.print(+listColn[i] + "  ");
		}
		System.out.println("");

		// ������ ���� ������ ����� �� ������ �����
		for (i = 0; i < keyRowArray.length; i++) {
			IDlistRow[i] = (int) keyRowArray[i];
			//System.out.print(listRow[i] + "  ");
		}
		System.out.println("");
		// ���������� � ����������
		sortColn(IDlistColn, mass);
		// ����� ����������
		System.out.println("����� ���������� ����� ������������ �������: ");
		System.out.println("");
		print(mass);
		
		sortRow(IDlistRow, mass);
		// ����� ����������
		System.out.println("����� ���������� ����� ������������ �����: ");
		System.out.println("");
		print(mass);
		// ������� ��������� ������ ����� ��������� ������ ������

		System.out.println("������������� �����: ");

		print(mass);
		//��������� ����������� ����� � list
		for (int y = 0; y < mass.length; y++) {
			for (int x = 0; x < mass[y].length; x++) {
				text.add(mass[y][x]);				
			}	
		}
		
		System.out.println("������� ������������� �����: ");
		for ( i = 0; i < text.size(); i++) {
			System.out.print(text.get(i));
		}		
		return text;
	}

	// ������� ������� ����� �� ������� �����
	private char[][] sortRow(int listRow[], char mass[][]) {
		int tempTop = 0;
		for (int j = 0; j < listRow.length; j++) {
			for (int i = 0; i < listRow.length - 1; i++) {
				// System.out.println("������ , ������� i = " + i);
				// ��������� ������ �� ��������� ����� � �������
				if (listRow[i] > listRow[i + 1]) {
					// System.out.println("��� list[i] = " + list[i] + "> list[i+1] = " + list[i +
					// 1]);
					tempTop = listRow[i + 1];
					listRow[i + 1] = listRow[i];
					listRow[i] = tempTop;

					//System.out.println(Arrays.toString(listRow));
					// ������ ������� ������� � ��������� �������
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

	// ������� ������� ����� �� ������� �����
	private char[][] sortColn(int listColn[], char mass[][]) {
		int tempTop = 0;
		for (int j = 0; j < listColn.length; j++) {
			for (int i = 0; i < listColn.length - 1; i++) {
				// System.out.println("������ , ������� i = " + i);
				// ��������� ������ �� ��������� ����� � �������
				if (listColn[i] > listColn[i + 1]) {
					// System.out.println("��� list[i] = " + list[i] + "> list[i+1] = " + list[i +
					// 1]);
					tempTop = listColn[i + 1];
					listColn[i + 1] = listColn[i];
					listColn[i] = tempTop;

					//System.out.println(Arrays.toString(listColn));
					// ������ ������� ������� � ��������� �������
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
	//������� ��������� ������
	void print (char[][] mass) {
		for (int y = 0; y < mass.length; y++) {
			for (int x = 0; x < mass[y].length; x++) {
				System.out.print(mass[y][x] + " ");
			}
			System.out.println();
		}
	}

}
