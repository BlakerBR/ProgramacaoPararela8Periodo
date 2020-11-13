package task3;

import java.util.Random;

public class Shared {

	private static int time;
	private static Random numberGenrator;
	
	public static void generateTime() {
		numberGenrator = new Random();
		time = numberGenrator.nextInt(10)+1;
	}
	
	public static int getTime() {
		return time;
	}
}
