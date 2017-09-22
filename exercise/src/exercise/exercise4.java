package exercise;
import java.util.Scanner;
public class exercise4 {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
		while(true) {
			int n = input.nextInt();
			int m = input.nextInt();
			if(m == 0 && n == 0)
				break;
			String[] matrix = new String[n];
			for(int i = 0; i < n; ++i) {
				matrix[n] = input.next();
			}
		}
	}
}
