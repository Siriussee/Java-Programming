package Thread;

public class ReverseHello {
	public class HelloThread extends Thread{
		public int number;
		
		public HelloThread() {
			count++;
			number = count;
		}
	}
	public static int count = 0;
	public void run() throws InterruptedException {
		if(count < 49) {
			HelloThread t = new HelloThread();
			t.start();
			t.join();
		}
		System.out.println("Hello from Thread "+number+"!");
	}
	public static void main(String args) throws InterruptedException {
		HelloThread h = new HelloThread();
		h.start();
		h.join();
	}
}
