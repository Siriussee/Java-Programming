package exercise;

import java.util.Scanner;

public class exercise3 {
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the Number: ");
		Long n = input.nextLong();
		double ans = 0.0;
		for(Long i = 1L; i <= n; ++i) {
			ans += Math.pow(-1,i+1) * 1/(2*i -1);
		}
		System.out.print(4*ans);
	}
}
