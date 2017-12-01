package Thread;

public class sharedCounter extends Thread {
	static int count = 0;

	public void run() {
			count += 10;
			System.out.println(Thread.currentThread().getName() + " ended" + "current count is " + count);
	}

	public static void main(String[] args) {
		sharedCounter[] sc = new sharedCounter[10];
		for (int i = 0; i < 10; ++i) {
			sc[i] = new sharedCounter();
			sc[i].start();
			/*
			try {
				sc[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		}
		System.out.println("final count is " + count);
	}

}
