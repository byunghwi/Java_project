package account.fr;
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
		setBounds(0, 0, 1326, 50);
		setBackground(new Color(051,255,255));
		
		titleLabel = new JLabel();
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		titleLabel.setBounds(20, 15, 300, 20);
		titleLabel.setText("편의점 프로그램");

		clockLabel = new JLabel();
		clockLabel.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		clockLabel.setBounds(1050, 15, 300, 20);
		
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
