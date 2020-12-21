package commute.List;

import java.awt.BorderLayout;
import java.awt.Color;
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

import common.HintTextField;
import common.RoundedButton;
import commute.CommutePanel;

public class List_Input extends JFrame {

	JTextField name;
	
	public JButton check;
	JPanel contentPanel;
	JPanel pIn;
	JPanel pIn2;
	
	
	String[] fieldNames = new String[]{"시작날짜", "종료날짜", "사원이름"};
	
	public JLabel[] labels;
	public JLabel titleLabel;
	
	public JTextField mem_name;
	
	public  JDateChooser st_date = new JDateChooser();
	public JDateChooser en_date = new JDateChooser();
	
	public CommutePanel cv = null;
	
	SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd"); 
	
	
	public List_Input() {
		
		
		
		
		
		
		setTitle("월별 근태목록조회");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		
		contentPanel = new JPanel(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(false);
		contentPanel.setLayout(null);
		setVisible(true);
		contentPanel.setBackground(new Color(128, 128, 128));
		
		titleLabel = new JLabel(" 정보 입력");
		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		titleLabel.setBounds(15, 20, 150, 100);
		titleLabel.setForeground(new Color(255, 255, 255));
		
		contentPanel.add(titleLabel);
		
		
		pIn = new JPanel();
		pIn.setBounds(150, 0, 400, 500);
		contentPanel.add(pIn);
		pIn.setBackground(Color.WHITE);
		pIn.setLayout(null);
		pIn.setFocusable(false);
		
		
		
//		titleLabel = new JLabel("정보 입력");
//		titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
//		titleLabel.setBounds(20, 20, 100, 100);
//		pIn.add(titleLabel);
		
		labels = new JLabel[fieldNames.length];
		
		//조회시작날짜
		st_date.setBounds(50, 40, 150 , 30);
		
		//조회종료날짜
		en_date.setBounds(50, 140, 150 , 30);
		
		//사원이름
		mem_name = new HintTextField("사원이름을 입력하세요");
		mem_name.setBounds(50, 240, 150 , 30);
		
		for (int j = 0; j < fieldNames.length; j++) {
			labels[j] = new JLabel(fieldNames[j]);
			labels[j].setFont(new Font("나눔 고딕", Font.BOLD, 12));
			labels[j].setBounds(50, (j)*100, 50 , 30);
			pIn.add(labels[j]);
		}
		
		check = new RoundedButton("확인");
		check.setFont(new Font("나눔 고딕", Font.BOLD, 12));
		check.setBounds(80, 320, 70, 30);
		check.setBackground(new Color(128, 128, 128));
		check.setForeground(new Color(255, 255, 255));
		
		JFrame j1=this;	  
		
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
            j1.dispose();
			
		}  
	  });
	  
		  pIn.add(mem_name);
		  pIn.add(check);
		  pIn.add(st_date);
		  pIn.add(en_date);
		  
	    this.setVisible(true);
	    this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocation(300,100);
		this.setSize(400,440);
		this.setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new List_Input();
		
	}
   	
}

	


		
