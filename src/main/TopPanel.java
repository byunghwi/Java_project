package main;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TopPanel extends JPanel {
	public JLabel clockLabel;
	public JLabel titleLabel;
	public SimpleDateFormat sd;
	private boolean chk = true;

	public TopPanel() {

		setLayout(null);
		setBounds(0, 0, 1300, 50);
		setBackground(Color.DARK_GRAY);
		
		titleLabel = new JLabel();
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBackground(Color.WHITE);
		titleLabel.setFont(new Font("굴림체", Font.BOLD, 18));
		titleLabel.setBounds(12, 15, 300, 20);
		titleLabel.setText("편의점 프로그램");

		clockLabel = new JLabel();
		clockLabel.setFont(new Font("굴림체", Font.BOLD, 13));
		clockLabel.setBounds(1050, 15, 300, 20);
		clockLabel.setForeground(Color.WHITE);
		clockLabel.setBackground(Color.WHITE);
		
		add(titleLabel);
		add(clockLabel);

		threadClock();

	}

	public void threadClock() {
		sd = new SimpleDateFormat("YYYY년 MM월 dd일 a HH:mm:ss");

		Thread thread = new Thread() {
			public void run() {

				while (chk) {

					clockLabel.setText(sd.format(new Date()));
					//System.out.println(sd.format(new Date()));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						chk = false;
					}
				}

			}

		};

		thread.start();
	}
}
