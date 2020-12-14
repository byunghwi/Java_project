package commute.List;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import commute.Commute;
import product.ProductDao;

public class Commute_ListView extends JPanel {

	private static final long serialVersionUID = 1L;
	

	public JScrollPane CommutesScrollPane = new JScrollPane();
	public Vector<String> colNames = getColum();
	public DefaultTableModel tblModel = new DefaultTableModel(colNames, 0);
	public JTable commuteTable = new JTable(tblModel);
	public Vector<String> rows;
	Commute_ListDao clist = null;
	String start_date;
	String end_date;
	String mem_name;
	
	public Commute_ListView() {
		
		
	}
	
	public Commute_ListView(String start_date,String end_date,String mem_name) {
		
		
		clist = new Commute_ListDao(start_date, end_date, mem_name);
		setLayout(null);
		
		CommutesScrollPane.setBounds(12, 10, 500, 550);
		add(CommutesScrollPane);
		
		commuteTable.setRowMargin(10);
		commuteTable.setRowHeight(30);		
		commuteTable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		//테이블 로우 중 한 줄만 선택 가능.
		
		commuteTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addCommuteLine(clist.commutelist()); 
		CommutesScrollPane.setViewportView(commuteTable);
		
	}
	
		public void addCommuteLine(ArrayList<Commute> commutes) {
			int size = commutes.size();
			for (int i = 0; i < size; i++) {
				rows = new Vector<String>();
				rows.addElement(commutes.get(i).getDc_date().toString());
				rows.addElement(commutes.get(i).getMem_no().toString());
				rows.addElement(commutes.get(i).getOn_time().toString());
				rows.addElement(commutes.get(i).getOff_time().toString());
				tblModel.addRow(rows);
			}
			
			CommutesScrollPane.setViewportView(commuteTable);
		}
		
		private Vector<String> getColum() {
			colNames = new Vector<String>();
			colNames.add("출근날짜");
			colNames.add("사원명");
			colNames.add("출근시간");
			colNames.add("퇴근시간");
			return colNames;
		}
}