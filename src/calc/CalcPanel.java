package calc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartPanel;

import com.toedter.calendar.JDateChooser;

import calc.Chart.CalcChart;
import calc.MainCalcFrame.CalcMainFrame;
import common.RoundedButton;



public class CalcPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public CalcDao claclist = null;
	String start_date;
	String end_date;
	
	public JScrollPane CalcListScrollPane = new JScrollPane();//정산목록 보여줄 패널

	
	public Vector<String> CalclistNames = getColum();
	public DefaultTableModel CalcModel = new DefaultTableModel(CalclistNames, 0);
	public JTable clacTable = new JTable(CalcModel);
	
	
	public  JTable calcTable = new JTable(CalcModel) {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	
	public JLabel lbShowDate;//정산목록 라벨
	public JLabel referencelbShowDate;//조회일자 라벨
	
	//행 정보들 담을 벡터
	public Vector<String> rows;
	
	String[] fieldNames = new String[]{"시작날짜", "종료날짜"};
	public JLabel[] labels;
	/////////////
	public CalcMainFrame m1 = null;
	public JButton check;
	public  JDateChooser st_date = new JDateChooser();
	public JDateChooser en_date = new JDateChooser();
	public ArrayList<Calc> cl = null;
	public CalcChart calcg = new CalcChart() ;
	public ChartPanel chart_p = null;
	
	SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
	
	
	
	public CalcPanel(String start_date,String end_date) {
		
		claclist = new CalcDao(start_date, end_date);
		setLayout(null);
		
		JLabel lbShowDate = new JLabel("정산목록");
		lbShowDate.setBounds(12, 55, 101, 37);
		lbShowDate.setFont(new Font("나눔고딕", Font.BOLD, 15));
		
		JLabel referencelbShowDate = new JLabel("조회일자");
		referencelbShowDate.setBounds(12, 0, 101, 37);
		referencelbShowDate.setFont(new Font("나눔고딕", Font.BOLD, 15));
		
		add(lbShowDate);
		add(referencelbShowDate);
		
		
		CalcListScrollPane.setBounds(10, 90, 550, 150);
		
		
		add(CalcListScrollPane);
		
		clacTable.setRowMargin(10);
		clacTable.setRowHeight(30);		
		clacTable.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		clacTable.getTableHeader().setBackground(new Color(32, 136, 203));
		clacTable.getTableHeader().setForeground(new Color(255, 255, 255));
		clacTable.setShowGrid(false);
		clacTable.setSelectionBackground(Color.PINK);
		clacTable.setShowVerticalLines(false);
		clacTable.setShowHorizontalLines(false);
		
		//테이블 로우 중 한 줄만 선택 가능.
		
		clacTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addCalcLine(claclist.calclist()); 
		CalcListScrollPane.setViewportView(clacTable);
		
		//캘린더 위치 설정
		st_date.setBounds(60, 37, 120 , 24);
		en_date.setBounds(250, 37, 120 , 24);
		
		labels = new JLabel[fieldNames.length];
		
		for (int j = 0; j < fieldNames.length; j++) {
			labels[j] = new JLabel(fieldNames[j]);
			labels[j].setFont(new Font("나눔고딕", Font.BOLD, 12));
			labels[j].setBounds((j+1)*190, 34, 50 , 30);
		    add(labels[j]);
		}
		
		check = new RoundedButton("조회");
		check.setFont(new Font("나눔고딕", Font.BOLD, 13));
		check.setBounds(465, 34, 70, 30);
		check.setBackground(new Color(128, 128, 128));
		check.setForeground(new Color(255, 255, 255));
		
		add(check);
		add(st_date);
		add(en_date);
		add(calcg.chart_p).setBounds(10, 250, 1110, 300);
		
		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(st_date.getDate()==null||en_date.getDate()==null) {
					JOptionPane.showMessageDialog(null, "[SYSTEM] 날짜를 지정해주세요.", "확인", JOptionPane.CLOSED_OPTION);
				}else {
					
					String start_date = dcn.format(st_date.getDate()); 
					String end_date = dcn.format(en_date.getDate()); 
					CalcModel.setNumRows(0);
					cl = new CalcDao(start_date,end_date).calclist();
					addCalcLine(cl);
					calcg.cl = cl;
					calcg.chart_p.setChart(calcg.getChart());
					JOptionPane.showMessageDialog(null, "[SYSTEM] 조회되었습니다.", "확인", JOptionPane.CLOSED_OPTION);
			
				}
			}
			
		});
		
	}
	
	
	public void addCalcLine(ArrayList<Calc> calcs) {
		int size = calcs.size();
		for (int i = 0; i < size; i++) {
			rows = new Vector<String>();
			rows.addElement(calcs.get(i).getsale_date().toString());
			rows.addElement(Integer.toString(calcs.get(i).gettotal_sale_quantity()));
			rows.addElement(Integer.toString(calcs.get(i).gettotal_sale_price()));
			rows.addElement(calcs.get(i).getworker_no().toString());
			rows.addElement(calcs.get(i).getsave_time().toString());
			CalcModel.addRow(rows);
		}
		
		CalcListScrollPane.setViewportView(clacTable);
	}
	
	
	private Vector<String> getColum() {
		CalclistNames = new Vector<String>();
		CalclistNames.add("판매날짜");
		CalclistNames.add("총판매건수");
		CalclistNames.add("총판매가격");
		CalclistNames.add("정산한직원");
		CalclistNames.add("정산날짜");
		return CalclistNames;
	}
	
	
}
