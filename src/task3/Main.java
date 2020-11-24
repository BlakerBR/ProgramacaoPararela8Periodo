package task3;

import java.lang.Thread.State;

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
		int numN = Integer.parseInt(Util.getNumber());
	
		ChildThread sum = new ChildThread (numA, numB, numN, '+', "SOMA");
		ChildThread sub = new ChildThread (numA, numB, numN, '-', "SUBTRACAO");
		ChildThread mul = new ChildThread (numA, numB, numN, '*', "MULTIPLICACAO");
		ChildThread div = new ChildThread (numA, numB, numN, '/', "DIVISAO");
		
		try {
			sum.start();
			sub.start();
			mul.start();
			div.start();

			Thread.sleep(3000);

			for(int i = 0; i < numN; i++) {
				sum.notice();
				while((sum.getState() != State.WAITING) && (sum.getState() != State.TERMINATED))
					Thread.sleep(1000);
				
				sub.notice();
				while((sub.getState() != State.WAITING) && (sub.getState() != State.TERMINATED))
					Thread.sleep(1000);
				
				mul.notice();
				while((mul.getState() != State.WAITING) && (mul.getState() != State.TERMINATED))
					Thread.sleep(1000);
				
				div.notice();
				while((div.getState() != State.WAITING) && (div.getState() != State.TERMINATED))
					Thread.sleep(1000);
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
