package task3;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import util.Util;

public class ChildThread extends Thread {
	
	private String numA;
	private String numB;
	private char operator;
	private String name;
	private int numN;
	private ScriptEngine graalEngine = new ScriptEngineManager().getEngineByName("graal.js");
	
	public ChildThread(String numA, String numB, int numN, char operator, String name) {
		this.numA = numA;
		this.numB = numB;
		this.numN = numN;
		this.operator = operator;
		this.name = name;
	}
	
	public void run() {
		try {
				for(int i = 0; i < numN; i++)
				{
					startWait();
					Util.generateTime(1, 10);
					System.out.println("Sou a thread " + name + " e vou dormir por " + Util.getTime() + " segundos!");
					Thread.sleep(Util.getTime()*1000);
					Object result = graalEngine.eval(numA + operator + numB);
					System.out.println("Eu sou a Thread " + name + " e meu resultado é " + result + "!\n");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private synchronized void startWait() throws InterruptedException {
		wait();
	}
	
	public synchronized void notice() throws InterruptedException {
		notify();
	}
}
