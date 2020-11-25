package util;

import java.util.Random;

import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;

public class Util {
	
	public static String getNumber() {
		String number;
		
		do
		{
			number = (String)JOptionPane.showInputDialog("Insira um n�mero:");
			if (!StringUtils.isNumeric(number))
				JOptionPane.showMessageDialog(null, "Caracter inserido n�o � um n�mero!", null, JOptionPane.WARNING_MESSAGE);
		}while(!StringUtils.isNumeric(number));
		
		return number;
	}
	
	public static int generateNumber(int min, int max) {;
		Random numberGenrator = new Random();
		return numberGenrator.nextInt(max)+min;
	}
}
