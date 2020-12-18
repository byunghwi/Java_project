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

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import calc.Chart.CalcChart;
import calc.CalcView;
import calc.BtnAction.CalcBtnAction;
import calc.add.Calc_Add_Date;
import commute.Action.Add_Commute_Off_Time;
import commute.Action.Check_on_Time;
import commute.List.List_Input;


public class CalcMainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	// 상단 정보 보여줄 패널
	TopPanel topPanel = new TopPanel();
	public CalcBtnPanel calcBtnPanel = new CalcBtnPanel();
	public CardLayout cardlayout;
	public JPanel contentPanel;
	
	public JPanel topView;
	public JPanel cView;
	public JPanel Calc_Btn;
	public CalcView clv = null;
	public JPanel calcBtnView;
	public ChartPanel chart_p = new ChartPanel(null);
	
	public Calc_Reference_Btn cb=null;
	
	public CalcMainFrame() {
		
		cardlayout = new CardLayout();
		
		cb=new Calc_Reference_Btn();
		clv=new CalcView(null,null);
		cb.clv=this.clv;
		cb.chart_p = this.chart_p ;
		cb.m1 = this;
		
		
		
		setFont(new Font("맑은 고딕", Font.BOLD, 20));
		setTitle("정산프로그램");
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1326,1800);
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
		
		
		calcBtnPanel.calc_Btn.addActionListener(new CalcBtnAction(this));
		
		add(chart_p).setBounds(0, 350, 1100, 450);
		
	}
	
	
	public static void main(String[] args) {
		new CalcMainFrame();
	}
	
	

}