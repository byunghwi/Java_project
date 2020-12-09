package order;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		OrderFrame f = new OrderFrame();
		
		f.pack(); //frame에 맞게 크기조절
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}