package NumberFormatException;

public class test {
	public static int bin2Dec(String binaryString) {
		int ans = 0;
		for(int i = binaryString.length()-1; i >=0; --i)
		{
			if(binaryString.charAt(i) != '0' && binaryString.charAt(i) != '1')
				throw new NumberFormatException("Not a vaild binary string!");
			if(binaryString.charAt(i) == '1')
				ans += Math.pow(2, i);
		}
		return ans;
	}
	public static void main(String[] args) {
		String test1 = "1001";
		String test2 = "103561";
		String test3 = "100010";
		try {
			System.out.println(bin2Dec(test1));
			System.out.println(bin2Dec(test2));
			System.out.println(bin2Dec(test3));
		}
		catch(NumberFormatException ex){
			System.out.println("Invaild string");
		}
	}
}
