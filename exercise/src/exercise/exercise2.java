package exercise;

import java.util.Scanner;

public class exercise2 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Input: ");
		String str = input.nextLine();
		char[] cstr = str.toCharArray();
		for(int i = str.length()-1; i >= 0; --i) {
			System.out.print(cstr[i]);
		}
	}
}
