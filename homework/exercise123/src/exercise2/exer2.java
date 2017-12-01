package exercise2;

public class exer2 {
	public static void main(String[] args) {
		for(int i = 1; i < 20; ++i) {
			MyInt myint = new MyInt(i);
			System.out.println(i + " is odd? " + myint.isOdd() + "    is even? " + myint.isEven()
			+ "    is prime? " + myint.isPrime());
		}
	}
}
class MyInt{
	int data;
	
	MyInt(int d){
		data = d;
	}
	public boolean isOdd() {
		if(data%2 == 1)
			return true;
		return false;
	}
	public boolean isEven() {
		return (!isOdd());
	}
	public boolean isPrime() {
		if(data == 1)
			return false;
		if(data ==2){
			return true;
		}else{
			for(int n = 2;n<=Math.sqrt(data);n++){
				if(data % n == 0)
					return false;
			}
			return true;
		}
	}
}