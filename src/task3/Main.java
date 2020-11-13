package task3;

import task2.ChildThread;
import util.Util;

//TASK:
//Develop an algorythm which uses four Threads, where each one is going to calculate and print one of the four basic operations about the 
//numbers a and b in the following order, N times: Sum (So), subtraction (Su), multiplication (Mu) and division (Di).
//The numbers a, b [b=/=0] and N (N E Z) have to be read by the keyboard. One whole time ti should be randomly generated from 1 to 10
//where iE [So,Su,Mi,Di]. Each of the N sequences of the calculus and printing should be completed and uninterrupted. That is, 
//a mechanism of Concurrence control shouldbe utilized ( a street light, for example) to guarantee the correct order (Sum, subtrations,
//multiplication and division) of each one of the sequences and also assure that a sequence only begins after the conclusion
//of the sequence before. Finally, each ti time generated [iE{So,Su,Mi,Di}] will be used to sleepen the respective Thread for ti seconds
//after gaining the right of execution, but before printing the end result of the operation, each one, N times.

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
