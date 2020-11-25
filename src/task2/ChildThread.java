package task2;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import util.Util;

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
			int time = Util.generateNumber(1, 20);
			Object result = graalEngine.eval(numA + operator + numB);
			System.out.println("Eu sou a Thread " + name + " (" + result + ") e vou dormir por " + time + " segundos!");
			Thread.sleep((time*1000));
			System.out.println("Eu sou a Thread " + name + " (" + result + "). Já se passaram " + time + " segundos, então terminei!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}