package task3;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ChildThread implements Runnable {
	
	private String numA;
	private String numB;
	private char operator;
	private String name;
	
	private ScriptEngine graalEngine = new ScriptEngineManager().getEngineByName("graal.js");
	
	public ChildThread(String numA, String numB, char operator, String name) {
		this.numA = numA;
		this.numB = numB;
		this.operator = operator;
		this.name = name;
	}
	
	public void run() {
		try {
			Object result = graalEngine.eval(numA + operator + numB);
			System.out.println("Eu sou a Thread " + name + " e meu resultado é " + result + "!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
