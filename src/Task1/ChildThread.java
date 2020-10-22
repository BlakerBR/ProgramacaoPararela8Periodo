package task1;

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
