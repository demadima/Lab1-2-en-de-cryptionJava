package lab1;

import java.awt.BufferCapabilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		System.out.println("1 - ������� ; 2 - ���������");
		Scanner scan = new Scanner(System.in);
		Integer n = scan.nextInt();
		
		
		encryption E = new encryption();
		decryption D = new decryption();
		System.out.println("1)������� �����");
		BufferedReader str = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("2)������� 1 ����");
		BufferedReader keyColn = new BufferedReader(new InputStreamReader(System.in));
	
		System.out.println("3)������� 2 ����");
		BufferedReader keyRow = new BufferedReader(new InputStreamReader(System.in));	
		

		
		switch(n) {
	    case 1: 
	    	try {
				E.Encrypt(str.readLine(),keyColn.readLine(),keyRow.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2: 
			try {
				D.Decryption(str.readLine(),keyColn.readLine(),keyRow.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;		
		default: 
		    System.out.println("�� ���������� ����");;
		    break;
	}
		
		
		
	
	}
	
	
}
