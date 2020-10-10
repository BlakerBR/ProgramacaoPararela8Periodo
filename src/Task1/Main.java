package Task1;

//This is a task which has the objective to develop an algorithm which uses two threads. 
//One of them to  print "Programação paralela" on the console, and the second one to print
//“Instituto Federal Fluminense” on the console.

public class Main {

	public static void main(String[] args) {
		Thread thread = new Thread (new ChildThread ());
		thread.start();
		try {
			for(int i = 0; i < 10; i++) {
				System.out.println("Instituto Federal Fluminense");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
