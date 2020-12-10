package commute;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;

import commute.Action.Add_Commute_Off_Time;
import commute.Action.Add_Commute_On_Time;



public class Commute_btn extends JFrame{

	JButton on_time= new JButton("출근");
	JButton off_time= new JButton("퇴근");
	JButton list= new JButton("월별목록");
	
	public Commute_btn() {
	
		JFrame frame = new JFrame("근태관리 시스템");

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
					new List_Input();
				}
			}
		};
		
		on_time.addActionListener(btn_date);
		off_time.addActionListener(btn_date);
		list.addActionListener(btn_date);
		
		frame.add(on_time);
		frame.add(off_time);
		frame.add(list);
		
		
		frame.setLayout(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocation(300,100);
		frame.setSize(500,500);
		frame.setVisible(true);
		
	}

}