package join;

class JoinDemo1 {
	public static void main(String args[]) {
		ThreadM tm = new ThreadM();
		tm.start();
		ThreadN tn = new ThreadN(); //change to see difference
		tn.start();
		try {
			tm.join();
			//changed code
			//ThreadN tn = new ThreadN();
			//tn.start();
			tn.join();
			System.out.println("Both threads have finished");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
