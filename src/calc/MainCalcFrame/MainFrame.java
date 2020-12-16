package calc.MainCalcFrame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import calc.CalcView;
import calc.add.Calc_Add_Date;
import commute.Action.Add_Commute_Off_Time;
import commute.Action.Check_on_Time;
import commute.List.List_Input;


public class MainFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	// 상단 정보 보여줄 패널
	TopPanel topPanel = new TopPanel();
	CalcBtnPanel calcBtnPanel = new CalcBtnPanel();
	public CardLayout cardlayout;
	public JPanel contentPanel;
	
	public JPanel topView;
	public JPanel cView;
	public JPanel Calc_Btn;
	public CalcView clv = null;
	public JPanel calcBtnView;
	
	
	Calc_Reference_Btn cb=null;
	
	public MainFrame() {
		
		cardlayout = new CardLayout();
		
		cb=new Calc_Reference_Btn();
		clv=new CalcView(null,null);
		cb.clv=this.clv;
		
		
		
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
		setTitle("정산프로그램");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1326, 800);
		setVisible(true);
		
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);
		
		topView = new JPanel();
		topView.add(topPanel, "topPanel");
		topView.setBounds(0, 0, 1326, 50);
		topView.setBackground(new Color(0, 255, 204));
		topView.setLayout(new BorderLayout());
		contentPanel.add(topView);
		
		Calc_Btn = new JPanel();
		Calc_Btn.setBounds(5, 50, 600, 100);
		Calc_Btn.add(cb, "topPanel");
		Calc_Btn.setLayout(cardlayout);
		contentPanel.add(Calc_Btn);
		
		cView = new JPanel();
		cView.add(clv , "CalcView");
		cView.setBackground(Color.WHITE);
		cView.setBounds(0, 150, 550, 200);
		cView.setLayout(cardlayout);
		contentPanel.add(cView);
		
		calcBtnView = new JPanel();
		calcBtnView.setBackground(Color.WHITE);
		calcBtnView.setBounds(1158, 50, 164, 675);
		calcBtnView.add(calcBtnPanel, "CalcBtnPanel");
		calcBtnView.setLayout(cardlayout);
		contentPanel.add(calcBtnView);
		
		
		calcBtnPanel.calc_Btn.addActionListener(this);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked_btn =(JButton)e.getSource();

		if (clicked_btn == calcBtnPanel.calc_Btn) {
			new Calc_Add_Date();
			JOptionPane.showMessageDialog(null, "[SYSTEM] 금일정산처리되었습니다.", "확인", JOptionPane.CLOSED_OPTION);
			calcBtnPanel.calc_Btn.setEnabled(false);
		} 
		
	} 
	
	public static void main(String[] args) {
		new MainFrame();
	}
	
	

}
