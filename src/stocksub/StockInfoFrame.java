package stocksub;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

public class StockInfoFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Stock stock = new Stock();
	
	
	public StockInfoFrame(){
		
		
		setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		setTitle("Á¦Ç° »ó¼¼ Á¤º¸");		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 100, 700, 400);
		setVisible(false);
		
		

		
	}
}
