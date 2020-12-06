package commute;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;



public class Commute_btn extends JFrame{

	public Commute_btn() {
	
		SimpleDateFormat simple=new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");
		Date now=new Date();
		Date now2=new Date();
		
		Calendar korea_time=Calendar.getInstance();
	//System.out.println(simple.format(now));
		
		JButton on_time= new JButton("출근");
		JButton off_time= new JButton("퇴근");
		
		
		on_time.setBounds(50,50,100,50);
		off_time.setBounds(200,50,100,50);
		
		
		on_time.setEnabled(true);
		off_time.setEnabled(true);
		
		ActionListener btn_date=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JButton clicked_btn =(JButton)e.getSource();
				
				if(clicked_btn==on_time) {
					System.out.println("출근시간:"+simple.format(now));
				}else if(clicked_btn==off_time) {
					System.out.println("퇴근시간:"+simple.format(now2));
				}
			}
		};
		
		on_time.addActionListener(btn_date);
		off_time.addActionListener(btn_date);
		
		add(on_time);
		add(off_time);
		
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(3000,100);
		setSize(350,200);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		
		new Commute_btn();
		
	}
}