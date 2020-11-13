package task3;

import java.util.concurrent.Semaphore;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ChildThread implements Runnable {
	
	private String numA;
	private String numB;
	private int numN;
	private char operator;
	private String name;
	private Semaphore sem;
	
	private ScriptEngine graalEngine = new ScriptEngineManager().getEngineByName("graal.js");
	
	public ChildThread(String numA, String numB, int numN, char operator, String name, Semaphore sem) {
		this.numA = numA;
		this.numB = numB;
		this.numN = numN;
		this.operator = operator;
		this.name = name;
		this.sem = sem;
	}
	
	public void run() {
		try {
			for(int i = 0; i < numN; i++)
			{
				sem.acquire();
				Object result = graalEngine.eval(numA + operator + numB);
				System.out.println("Eu sou a Thread " + name + " e meu resultado � " + result + "!");
				sem.release();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
