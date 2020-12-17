package calc.MainCalcFrame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;

import com.toedter.calendar.JDateChooser;

import calc.Chart.CalcChart;
import calc.Calc;
import calc.CalcDao;
import calc.CalcView;
import commute.List.Commute_ListDao;
import commute.List.Commute_ListView;

public class Calc_Reference_Btn extends JPanel{

	String[] fieldNames = new String[]{"시작날짜", "종료날짜"};
	public JLabel[] labels;
	
	public MainFrame m1 = null;
	public JButton check;
	public  JDateChooser st_date = new JDateChooser();
	public JDateChooser en_date = new JDateChooser();
	public ArrayList<Calc> cl = null;
	public CalcChart calcg = new CalcChart() ;
	public ChartPanel chart_p = null;
	
	public CalcView clv = null;
	
	SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
	
	public Calc_Reference_Btn() {
		
		setBackground(Color.WHITE);
		setLayout(null);
		JLabel lbShowDate = new JLabel("조회일자");
		lbShowDate.setBounds(12, 0, 101, 37);
		add(lbShowDate);
		lbShowDate.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		
		
		
		st_date.setBounds(60, 37, 150 , 24);
		
		en_date.setBounds(280, 37, 150 , 24);
		
		labels = new JLabel[fieldNames.length];
		
		for (int j = 0; j < fieldNames.length; j++) {
			labels[j] = new JLabel(fieldNames[j]);
			labels[j].setFont(new Font("맑은 고딕", Font.BOLD, 12));
			labels[j].setBounds((j+1)*220, 34, 50 , 30);
		    add(labels[j]);
		}
		
		check = new JButton("조회");
		check.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		check.setBounds(520, 34, 70, 30);
		
		add(check);
		add(st_date);
		add(en_date);
		
		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(st_date.getDate()==null||en_date.getDate()==null) {
					JOptionPane.showMessageDialog(null, "[SYSTEM] 날짜를 지정해주세요.", "확인", JOptionPane.CLOSED_OPTION);
				}else {
					
					String start_date = dcn.format(st_date.getDate()); 
					String end_date = dcn.format(en_date.getDate()); 
					clv.cblModel.setNumRows(0);
					cl = new CalcDao(start_date,end_date).calclist();
					clv.addCalcLine(cl);
					calcg.cl = cl;
					m1.chart_p.setChart(calcg.getChart());
					JOptionPane.showMessageDialog(null, "[SYSTEM] 조회되었습니다.", "확인", JOptionPane.CLOSED_OPTION);
			
				}
			}
		});
		
	}
	
	
	
}
