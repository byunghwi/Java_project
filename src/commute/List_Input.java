package commute;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class List_Input extends JFrame {

	JTextField start_date,end_date,mem_name;
	
	public List_Input() {
		
		setTitle("월별근태목록");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
		JButton button = new JButton("확인");
		JLabel label=new JLabel("정보입력");
		
		this.setLayout(new GridLayout(5,2));
		
		
		JPanel panel1 = new JPanel();
		panel1 .add(new JLabel("시작날짜"));
		start_date=new JTextField(20);
		panel1.add(start_date);
		
		JPanel panel2 = new JPanel();
		panel2 .add(new JLabel("종료날짜"));
		end_date=new JTextField(20);
		panel2.add(end_date);
		
		JPanel panel3 = new JPanel();
		panel3 .add(new JLabel("사원이름"));
		mem_name=new JTextField(20);
		panel2.add(mem_name);
	      
	  button.addActionListener(new ActionListener() {

		  
		  
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String st_date =start_date.getText();
	        String en_date =end_date.getText();
            String name=mem_name.getText();
            
			new Commute_list(st_date,en_date,name);
			
			
         
		}  
	  });
	  
	      add(label);
		  add(panel1);
	      add(panel2);
	      add(panel3);
	      add(button);
	  
	    this.setVisible(true);
	    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocation(3000,100);
		this.setSize(500,500);
		this.setVisible(true);
		
		
	}
   
}
	


		
