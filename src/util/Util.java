package util;

import java.util.Random;

import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;

public class Util {

	private static int time;
	private static Random numberGenrator;
	
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
	
	public static void generateTime(int min, int max) {
		numberGenrator = new Random();
		time = numberGenrator.nextInt(max)+min;
	}
	
	public static int getTime() {
		return time;
	}
}
