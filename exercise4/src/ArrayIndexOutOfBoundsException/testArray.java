package ArrayIndexOutOfBoundsException;
import java.util.*;
public class testArray {
		public static int At(int arr[],int a)
		{
			if(a >= 100)
			{
				throw new ArrayIndexOutOfBoundsException();
			}
			return arr[a];
		}
		public static void main(String args) {
			int[] arr = new int[100];
			Scanner input = new Scanner(System.in);
			int index = input.nextInt();
			try {
				System.out.println(At(arr,index));
			}
			catch(ArrayIndexOutOfBoundsException ex) {
				System.out.println("ArrayIndexOutOfBoundsException");
			}
			
		}
	

}
