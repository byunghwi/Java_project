package commute.List;

import java.awt.BorderLayout; 
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import commute.CommutePanel;
import commute.MainCommuteFrame.CommuteMainFrame;
import product.HintTextField;

public class List_Input extends JFrame {

	JTextField name;
	
	public JButton check;
	JPanel contentPanel;
	JPanel pIn;
	
	String[] fieldNames = new String[]{"시작날짜", "종료날짜", "사원이름"};
	
	public JLabel[] labels;
	
	public JTextField mem_name;
	
	public  JDateChooser st_date = new JDateChooser();
	public JDateChooser en_date = new JDateChooser();
	
	public CommutePanel cv = null;
	
	SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd"); 
	
	
	public List_Input() {
		
		setTitle("월별 근태목록조회");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 340, 420);
		contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
		contentPanel.setLayout(null);
		setVisible(true);
		
		pIn = new JPanel();
		pIn.setBounds(5, 5, 310, 400);
		contentPanel.add(pIn);
		pIn.setLayout(null);
		pIn.setFocusable(false);
		
		labels = new JLabel[fieldNames.length];
		
		//조회시작날짜
		st_date.setBounds(130, 57, 150 , 24);
		
		//조회종료날짜
		en_date.setBounds(130, 107, 150 , 24);
		
		//사원이름
		mem_name = new HintTextField("사원이름을 입력하세요");
		mem_name.setBounds(130, 154, 170 , 30);
		
		for (int j = 0; j < fieldNames.length; j++) {
			labels[j] = new JLabel(fieldNames[j]);
			labels[j].setFont(new Font("맑은 고딕", Font.BOLD, 12));
			labels[j].setBounds(30, (j+1)*50, 50 , 30);
			pIn.add(labels[j]);
		}
		
		check = new JButton("확인");
		check.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		check.setBounds(180, 320, 70, 30);
		
	      
		check.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			//JDateChooser이용해 나온 날짜 문자열로 바꿈
			String start_date = dcn.format(st_date.getDate()); 
			String end_date = dcn.format(en_date.getDate()); 
            String name=mem_name.getText();
            cv.IndividualtblModel.setNumRows(0);
            cv.addCommuteIndividualLine(new Commute_ListDao(start_date,end_date,name).commutelist());
			JOptionPane.showMessageDialog(null, "[SYSTEM] 조회되었습니다.", "확인", JOptionPane.CLOSED_OPTION);
            
			
		}  
	  });
	  
		  pIn.add(mem_name);
		  pIn.add(check);
		  pIn.add(st_date);
		  pIn.add(en_date);
	  
	    this.setVisible(true);
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocation(300,100);
		this.setSize(450,450);
		this.setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new List_Input();
		
	}
   	
}

	


		
