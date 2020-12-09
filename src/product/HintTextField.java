package product;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

// Swing에 placeholder 기능없어서 따로 만듦
public class HintTextField extends JTextField {
	
	
	Font gainFont = new Font("맑은 고딕", Font.PLAIN, 12);
	Font lostFont = new Font("맑은 고딕", Font.ITALIC, 12);

	public HintTextField(String hint) {
		
		setText(hint);
		setFont(lostFont);
		setForeground(Color.GRAY);

		this.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (getText().equals(hint) || getText().length() == 0) {
					setText(hint);
					setFont(lostFont);
				} else {
					setForeground(Color.BLACK);
					setText(getText());
					setFont(gainFont);
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (getText().equals(hint) || getText().length() == 0) {
					setText("");
					setFont(lostFont);
					setForeground(Color.GRAY);
				} else {
					setForeground(Color.BLACK);
					setText(getText());
					setFont(gainFont);					
				}
			}
		});
	}
}
