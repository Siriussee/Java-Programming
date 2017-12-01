package MultiThread;

public class CounterDemo extends Thread {
	private Counter u;

	CounterDemo(Counter u) {
		this.u = u;
	}

	public void run() {
		for (int i = 0; i < 1000000; ++i) {
			u.increment();
		}
		System.out.println(Thread.currentThread().getName() + " ended, counter now is "+ u.get());
	}
	public static void main(String[] args) {
		Counter u = new Counter();
		CounterDemo u1 = new CounterDemo(u);
		CounterDemo u2 = new CounterDemo(u);
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
