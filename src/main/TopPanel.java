package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import sale.SalePanel;

public class TopPanel extends JPanel {
	public JLabel clockLabel;
	public JLabel titleLabel;
	public SimpleDateFormat sd;
	private boolean chk = true;

	public TopPanel() {

		setLayout(null);
		setBounds(70, 0, 1300, 50);
		setBackground(new Color(105, 105, 105));
		
		titleLabel = new JLabel();
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setForeground(Color.WHITE);
		titleLabel.setBackground(Color.WHITE);
		titleLabel.setFont(new Font("나눔고딕", Font.BOLD, 18));
		titleLabel.setBounds(50, 0, 162, 50);
		titleLabel.setText("편의점 프로그램");

		clockLabel = new JLabel();
		clockLabel.setFont(new Font("나눔고딕", Font.BOLD, 14));
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
