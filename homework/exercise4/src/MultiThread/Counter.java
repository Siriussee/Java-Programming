package MultiThread;

public class Counter {
	private int count;
	
	//add synchronized, then OK
	public synchronized void increment() {
		count++;
	}

	public int get() {
		return count;
	}
}
