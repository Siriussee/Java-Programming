package ArrayIndexOutOfBoundsException;

import java.util.*;

public class testArray {
	public static void main(String[] args) {
		int[] arr = new int[100];
		for(int i=0; i <100; ++i) {
			arr[i] = i;
		}
		Scanner input = new Scanner(System.in);
		System.out.print("which number wiil you get? ");
		int index = input.nextInt();
		try {
			System.out.println(arr[index]);
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.out.println("ArrayIndexOutOfBoundsException");
		}

	}

}
