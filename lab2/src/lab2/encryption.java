package lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class encryption {

	public int temp = 0;
	

	public List<Character> text = new ArrayList<>();
	
	public static char[] alfavit = { '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�',
			'�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�', '�' , ' '};

	public char[] array = null;


	public String Encrypt(String str, int a, int b) {
		int m = alfavit.length;
		int[] alfavitNew = new int[alfavit.length];
		// ���� �����������
		System.out.println("");
		array = str.toCharArray();

		System.out.println(Arrays.toString(array));

		System.out.print("������ �������:");
		for (int t = 0; t < alfavit.length; t++) {
			System.out.print(t + "  ");
		}
		System.out.println("");
		System.out.print("����� �������:");
		for (int t = 0; t < alfavit.length; t++) {
			alfavitNew[t] = (a * t + b) % m;
			System.out.print(alfavitNew[t] + "  ");
		}

		for (int i = 0; i < array.length; i++) {
			for (int t = 0; t < alfavit.length; t++) {
				if (array[i] == alfavit[t]) {
					temp = alfavitNew[t];
					text.add(alfavit[temp]);
				}
			}
		}

		String encrypted = "";
		System.out.println("");
		System.out.println("������� ������������� �����: ");
		for (int i = 0; i < text.size(); i++) {
			encrypted += text.get(i);
		}
		return encrypted;
	}
}
