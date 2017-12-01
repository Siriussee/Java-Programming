package MultiThread;

public class UnsafeCounterDemo extends Thread {
	private UnsafeCounter u;

	UnsafeCounterDemo(UnsafeCounter u) {
		this.u = u;
	}

	public void run() {
		for (int i = 0; i < 1000000; ++i) {
			u.increment();
		}
		System.out.println(Thread.currentThread().getName() + " ended, counter now is "+ u.get());
	}
	public static void main(String[] args) {
		UnsafeCounter u = new UnsafeCounter();
		UnsafeCounterDemo u1 = new UnsafeCounterDemo(u);
		UnsafeCounterDemo u2 = new UnsafeCounterDemo(u);
		u1.start();
		u2.start();
		try {
			u1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}try {
			u2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("All ended, counter now is "+ u.get());
	}

}
