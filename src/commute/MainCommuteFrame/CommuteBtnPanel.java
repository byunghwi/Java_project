package commute.MainCommuteFrame;

import java.awt.BorderLayout;  
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CommuteBtnPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton on_timeBtn;
	public JButton off_timeBtn;
	public JButton commuteBtn;

	public CommuteBtnPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		on_timeBtn = new JButton("출근");
		off_timeBtn = new JButton("퇴근");
		commuteBtn = new JButton("근태목록");

		on_timeBtn.setForeground(Color.WHITE);
		on_timeBtn.setFont(new Font("나눔 고딕", Font.BOLD, 20));
		on_timeBtn.setBackground(new Color(204, 206, 206));
		on_timeBtn.setBounds(0, 0, 140, 120);
		
		off_timeBtn.setForeground(Color.WHITE);
		off_timeBtn.setFont(new Font("나눔 고딕", Font.BOLD, 20));
		off_timeBtn.setBackground(new Color(204, 206, 206));
		off_timeBtn.setBounds(0, 120, 140, 120);
		
		commuteBtn.setForeground(Color.WHITE);
		commuteBtn.setFont(new Font("나눔 고딕", Font.BOLD, 20));
		commuteBtn.setBackground(new Color(204, 206, 206));
		commuteBtn.setBounds(0, 240, 140, 120);

		add(on_timeBtn);
		add(off_timeBtn);
		add(commuteBtn);
	}

}
