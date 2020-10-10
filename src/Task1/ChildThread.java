package Task1;

// This is a task which has the objective to develop an algorithm which uses two threads. 
// One of them to  print "Programação paralela" on the console, and the second one to print
// “Instituto Federal Fluminense” on the console.

public class ChildThread implements Runnable {
	
	public void run() {
		try {
			for(int i = 0; i < 10; i++) {
				System.out.println("Programacao Paralela");
				Thread.sleep(3000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
