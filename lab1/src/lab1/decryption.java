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
	// ����� ��� ��������: ���������������������?���
	// public static char[] alfavit = { '�', '�', '�', '�', '�', '�', '�', '�', '�',
	// '�', '�', '�', '�', '�', '�', '�', '�', '�',
	// '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�' };

	public char[] array = null;
	public char[][] mass = new char[5][5];
	public char[][] newmass = new char[5][5];
	public char[][] newmass3 = new char[5][5];


	public List<Character> Decryption(String str, String keyColn, String keyRow) {
		// ���� �����������
		System.out.println("");
		array = str.toCharArray();
		// ������� ��������� �� �� ������� �����������
		int i = 0;
		// System.out.println(Arrays.toString(array));
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
			// System.out.print(+listColn[i] + " ");
		}
		System.out.println("");

		// ������ ���� ������ ����� �� ������ �����
		for (i = 0; i < keyRowArray.length; i++) {
			IDlistRow[i] = (int) keyRowArray[i];
			// System.out.print(listRow[i] + " ");
		}
		System.out.println("");
		// ���������� � ����������
		// ��������� ���� �� ��������
		System.out.println("��:" + Arrays.toString(IDlistColn));
		System.out.println("����� ���������� ����� ���������� ����� �� ��������: ");
		TempIDlistColn = Arrays.copyOf(IDlistColn, IDlistColn.length);
		sortKeyColn = Arrays.copyOf(sortKey(IDlistColn), IDlistColn.length );
		IDlistColn = Arrays.copyOf(TempIDlistColn, TempIDlistColn.length);;

		// ��������� ���� �� �������
		System.out.println("��: " + Arrays.toString(IDlistRow));
		System.out.println("����� ���������� ����� ���������� ����� �� �������: ");
		
		TempIDlistRow = Arrays.copyOf(IDlistRow, IDlistRow.length);
		sortKeyRow = Arrays.copyOf(sortKey(IDlistRow), IDlistRow.length );
		IDlistRow = Arrays.copyOf(TempIDlistRow, TempIDlistRow.length);
		
		// ��������� �� ������� �����
		mass = sortRow(IDlistRow, mass, sortKeyRow,newmass);
		print(newmass);
		// ��������� �� ������� �����
		newmass = sortColn(IDlistColn, newmass, sortKeyColn ,newmass3);
		print(newmass);
		
		
		
		
		// ������� ��������� ������ ����� ��������� ������ ������
		System.out.println("������������� �����: ");
		print(newmass);
		
		// ��������� ����������� ����� � list
		for (int y = 0; y < newmass.length; y++) {
			for (int x = 0; x < newmass[y].length; x++) {
				text.add(newmass[y][x]);
			}
		}

		System.out.println("������� ������������� �����: ");
		for (i = 0; i < text.size(); i++) {
			System.out.print(text.get(i));
		}
		return text;
	}

	// ������� ������� ����� �� ������� �����
	private char[][] sortColn(int IDlistColn[], char newmass[][], int sortKeyColn[],char newmass3[][]) {
		
		System.out.println("��������� �� ��������");
		int tempTop = 0;
		for (int j = 0; j < IDlistColn.length; j++) {
			for (int i = 0; i < IDlistColn.length; i++) {
				// ��������� ������ �� ��������� ����� � �������
				System.out.println(Arrays.toString(IDlistColn));
				System.out.println(Arrays.toString(sortKeyColn));
				System.out.println("IDlistColn[j] = "+ IDlistColn[j] + " ;sortKeyColn[j] = "+ sortKeyColn[i]);
				if (IDlistColn[j] == sortKeyColn[i]) {
					System.out.println("Yes");
				
					// ������ ������� ������� � ��������� �������
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

	// ������� ������� ����� �� ������� �����
	private char[][] sortRow(int IDlistRow[], char mass[][], int sortKeyRow[] , char newmass[][]) {
		
		System.out.println("��������� �� �������");
		int tempTop = 0;
		for (int j = 0; j < IDlistRow.length; j++) {
			for (int i = 0; i < IDlistRow.length; i++) {
				System.out.println(Arrays.toString(IDlistRow));
				System.out.println(Arrays.toString(sortKeyRow));
				System.out.println("IDlistRow[j] = "+ IDlistRow[j] + " ;sortKeyRow[j] = "+ sortKeyRow[i]);
				// ��������� ������ �� ��������� ����� � �������
				if (IDlistRow[j] == sortKeyRow[i]) {
					System.out.println("Yes");
					
					// ������ ������� ������� � ��������� �������
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

	// ������� c��������� ������
	private int[] sortKey(int IDlist[]) {
		int tempTop = 0;
		for (int j = 0; j < IDlist.length; j++) {
			for (int i = 0; i < IDlist.length - 1; i++) {
				// System.out.println("������ , ������� i = " + i);
				// ��������� ������ �� ��������� ����� � �������
				if (IDlist[i] > IDlist[i + 1]) {
					// System.out.println("��� list[i] = " + list[i] + "> list[i+1] = " + list[i +
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

	// ������� ��������� ������
	void print(char[][] mass) {
		for (int y = 0; y < mass.length; y++) {
			for (int x = 0; x < mass[y].length; x++) {
				System.out.print(mass[y][x] + " ");
			}
			System.out.println();
		}
	}

}
