package Thread;

public class helloThread extends Thread {
	int number;
	static int count = 0;

	public helloThread() {
		count++;
		number = count;
	}

	public void run() {
		if (count < 49) {
			helloThread t = new helloThread();	//Recursively create new helloThread
			t.start();
			try {
				t.join();						//then wait until it is done
			} catch (InterruptedException e) {	//auto filled catch block, i don't know what it is actually
				e.printStackTrace();		
			}
		}
		System.out.println("Hello from Thread " + number + "!");
	}
	//you will not go on compile if you miss '[]' in 'String[] args'
	public static void main(String[] args) throws InterruptedException {
		helloThread h = new helloThread();
		h.start();
		h.join();
	}
}
