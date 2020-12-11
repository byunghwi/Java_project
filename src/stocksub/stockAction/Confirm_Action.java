package stocksub.stockAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Confirm_Action implements ActionListener {
	JFrame j;
	
	public Confirm_Action(JFrame j) {
		this.j = j;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		j.dispose();
		
	}
	
}
