package Order;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		OrderGui frame = new OrderGui();
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}