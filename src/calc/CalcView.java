package calc;

import java.awt.Font; 
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;



public class CalcView extends JPanel{

	private static final long serialVersionUID = 1L;
	
	public JScrollPane CalcScrollPane = new JScrollPane();
	public Vector<String> colNames = getColum();
	public DefaultTableModel cblModel = new DefaultTableModel(colNames, 0);
	public JTable clacTable = new JTable(cblModel);
	public Vector<String> rows;
	CalcDao claclist = null;
	String start_date;
	String end_date;
	
	public CalcView(String start_date,String end_date) {
		
		claclist = new CalcDao(start_date, end_date);
		setLayout(null);
		
		JLabel lbShowDate = new JLabel("정산목록");
		lbShowDate.setBounds(12, 0, 101, 37);
		add(lbShowDate);
		lbShowDate.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		CalcScrollPane.setBounds(12, 30, 500, 150);
		add(CalcScrollPane);
		
		clacTable.setRowMargin(10);
		clacTable.setRowHeight(30);		
		clacTable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		//테이블 로우 중 한 줄만 선택 가능.
		
		clacTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addCalcLine(claclist.calclist()); 
		CalcScrollPane.setViewportView(clacTable);
		
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
			cblModel.addRow(rows);
		}
		
		CalcScrollPane.setViewportView(clacTable);
	}
	
	
	private Vector<String> getColum() {
		colNames = new Vector<String>();
		colNames.add("판매날짜");
		colNames.add("총판매건수");
		colNames.add("총판매가격");
		colNames.add("정산한직원");
		colNames.add("정산날짜");
		return colNames;
	}
	
}
