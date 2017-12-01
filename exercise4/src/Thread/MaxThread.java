package Thread;

public class MaxThread extends Thread{
	private int lo, hi;
	private int[] arr;
	private int ans = 0;

	public MaxThread(int[] arr, int lo, int hi) {
		this.lo = lo;
		this.hi = hi;
		this.arr = arr;
	}

	@Override
	public void run() {
		for (int i = lo; i < hi; i++) {
			if(i < 99 && arr[i] < arr[i + 1] )
				ans = arr[i+1];
		}
	}
	public static int max(int[] arr) throws InterruptedException {
		int len = arr.length;
		int ans = 0;

		// Create and start 4 threads.
		MaxThread[] ts = new MaxThread[4];
		for (int i = 0; i < 4; i++) {
			ts[i] = new MaxThread(arr, (i * len) / 4, ((i + 1) * len / 4));
			ts[i].start();
		}

		// Wait for the threads to finish and sum their results.
		for (int i = 0; i < 4; i++) {
			ts[i].join();
			if(i < 3 && ts[i].ans < ts[i+1].ans)
				ans = ts[i+1].ans;
		}
		return ans;
	}
	public static void main(String[] args) throws InterruptedException {
		int[] arr = new int[100];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		int max = max(arr);
		System.out.println("Max: " + max);
	}
}
