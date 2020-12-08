package commute;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;



public class Commute_btn extends JFrame{

	JButton on_time= new JButton("출근");
	JButton off_time= new JButton("퇴근");
	JButton list= new JButton("월별목록");
	
	public Commute_btn() {
	

		on_time.setBounds(50,50,100,50);
		off_time.setBounds(150,50,100,50);
		list.setBounds(300,50,150,50);
		
		on_time.setEnabled(true);
		off_time.setEnabled(true);
		list.setEnabled(true);
		
		ActionListener btn_date=new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JButton clicked_btn =(JButton)e.getSource();
				
				if(clicked_btn==on_time) {
					new Add_Commute_On_Time();
				}else if(clicked_btn==off_time) {
					new Add_Commute_Off_Time();
				}else {
					new Commute_list();
				}
			}
		};
		
		on_time.addActionListener(btn_date);
		off_time.addActionListener(btn_date);
		list.addActionListener(btn_date);
		
		add(on_time);
		add(off_time);
		add(list);
		
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocation(3000,100);
		setSize(500,500);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		
		new Commute_btn();
		
	}
}