package exercise;

import java.util.Scanner;

public class exercise1 {
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Number of lines: ");
		int line = input.nextInt();
		for(int i = 1; i <= line; ++i) {
			for(int j = line; j > 0; --j) {
				if(j > i) {
					System.out.print("  ");
				}
				if(j <= i) {
					System.out.print(j + " ");
				}	
			}
			for(int j = 2; j <= line; ++j) {
				if(j <= i) {
					System.out.print(j + " ");
				}	
			}
			System.out.println("");
		}
	}
}
