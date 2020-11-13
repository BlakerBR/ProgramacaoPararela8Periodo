package task2;

import util.Util;

// TASK:
// Consider two numbers a and b (b≠ 0) read by the keyboard and a time ti, 
// randomly generated from 1 to 20, where ∈{Sum,Sub,Mul,Div}. Develop an 
// algorithm which creates four threads, where each one will calculate one of 
// four basic options about a and b: Sum, Subtraction, Multiplication e Division.
// Besides every operation, each thread should execute other two basic operations,
// printing the time ti on the screen (in seconds) where it will "sleep"
// and print it on the screen, after the passing of the ti seconds, which it is then going to end.

public class Main {
	
	public static void main(String[] args) {
		String numA = Util.getNumber();
		String numB = Util.getNumber();
		
		Thread sub = new Thread (new ChildThread (numA, numB, '-', "SUBTRACAO"));
		Thread sum = new Thread (new ChildThread (numA, numB, '+', "SOMA"));
		Thread div = new Thread (new ChildThread (numA, numB, '/', "DIVISAO"));
		Thread mul = new Thread (new ChildThread (numA, numB, '*', "MULTIPLICACAO"));
		
		sub.start();
		sum.start();
		div.start();
		mul.start();
	}
}
