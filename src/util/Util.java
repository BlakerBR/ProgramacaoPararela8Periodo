package util;

import java.util.Random;

import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;

public class Util {

	private static Random numberGenerator;
	private static int randTime;
	
	public static String getNumber() {
		String number;
		
		do
		{
			number = (String)JOptionPane.showInputDialog("Insira um número:");
			if (!StringUtils.isNumeric(number))
				JOptionPane.showMessageDialog(null, "Caracter inserido não é um número!", null, JOptionPane.WARNING_MESSAGE);
		}while(!StringUtils.isNumeric(number));
		
		return number;
	}

	public static void genNewRandTime() {
		numberGenerator = new Random();
		randTime = numberGenerator.nextInt();
	}
	
	public static int getRandTime() {
		return randTime;
	}
}
