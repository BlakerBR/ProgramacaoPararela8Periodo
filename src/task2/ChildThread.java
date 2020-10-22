package task2;

import java.util.Random;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class ChildThread implements Runnable {
	
	String numA;
	String numB;
	char operator;
	String name;
	
	Random numberGenerator = new Random();
	ScriptEngineManager manager = new ScriptEngineManager();
	ScriptEngine engine = manager.getEngineByName("js");
	
	public ChildThread(String numA, String numB, char operator, String name) {
		this.numA = numA;
		this.numB = numB;
		this.operator = operator;
		this.name = name;
	}
	
	public void run() {
		try {
			int time = numberGenerator.nextInt(20)+1;
			Object result = engine.eval(numA + operator + numB);
			System.out.println("Eu sou a Thread " + name + " (" + result + ") e vou dormir por " + time + " segundos!");
			Thread.sleep((time*1000));
			System.out.println("Eu sou a Thread " + name + " (" + result + "). Já se passaram " + time + " segundos, então terminei!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}