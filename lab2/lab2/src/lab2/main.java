package lab2;

import java.awt.BufferCapabilities;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		System.out.println("1 - шифруем ; 2 - дешифруем");
		Scanner scan = new Scanner(System.in);
		Integer n = scan.nextInt();
		
		System.out.println("Введите a:");
		Scanner scan2 = new Scanner(System.in);
		Integer a = scan2.nextInt();
		System.out.println("Введите b:");
		Scanner scan3 = new Scanner(System.in);
		Integer b = scan3.nextInt();
	
		encryption E = new encryption();
		decryption D = new decryption();
		System.out.println("1)Введите текст");
		BufferedReader str = new BufferedReader(new InputStreamReader(System.in));


		
		switch(n) {
	    case 1: 
	    	try {
	    		System.out.println(E.Encrypt(str.readLine(),a,b));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 2: 
			try {
				System.out.println(D.Decrypt(str.readLine(), a, b));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			break;		
		default: 
		    System.out.println("Не правельный ввод");;
		    break;
	}
		
		
		
	
	}
	
	
}
