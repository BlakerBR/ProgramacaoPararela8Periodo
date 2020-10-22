package task2;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringUtils;

// TASL:
// Consider two numbers a e b (b≠ 0) read by the keyboard and a time ti, 
// randomly generated from 1 to 20, where ∈{Sum,Sub,Mul,Div}. Develop an 
// algorithm which creates four threads, where each one will calculate one of 
// four basic options about a and b: Sum, Subtraction, Multiplication e Division.
// Besides every operation, each thread should execute other two basic operations,
// printing the time ti on the screen (in seconds) where it will "sleep"
// and print it on the screen, after the passing of the ti seconds, which it is then going to end.

public class Main {
	
	public static void main(String[] args) {
		String numA;
		String numB;
		
		do
		{
			numA = (String)JOptionPane.showInputDialog("Insira um número:");
			if (!StringUtils.isNumeric(numA))
				JOptionPane.showMessageDialog(null, "Caracter inserido não é um número!", null, JOptionPane.WARNING_MESSAGE);
		}while(!StringUtils.isNumeric(numA));
		
		do
		{
			numB = (String)JOptionPane.showInputDialog("Insira outro número:");
			if (!StringUtils.isNumeric(numB))
				JOptionPane.showMessageDialog(null, "Caracter inserido não é um número!", null, JOptionPane.WARNING_MESSAGE);
		}while(!StringUtils.isNumeric(numB));
		
		Thread sub = new Thread (new ChildThread ("1", "2", '-', "SUBTRACAO "));
		Thread sum = new Thread (new ChildThread ("1", "2", '+', "SOMA"));
		Thread div = new Thread (new ChildThread ("1", "2", '/', "DIVISAO "));
		Thread mul = new Thread (new ChildThread ("1", "2", '*', "MULTIPLICACAO"));
		sub.start();
		sum.start();
		div.start();
		mul.start();
	}

}
