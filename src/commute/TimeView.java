package commute;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class TimeView extends JPanel {

private static final long serialVersionUID = 1L;
	

	public  JScrollPane CommutesScrollPane = new JScrollPane();
	public Vector<String> colNames = getColum();
	public  DefaultTableModel tblModel = new DefaultTableModel(colNames, 0);
	public  JTable commuteTable = new JTable(tblModel);
	public  Vector<String> rows;
	TimeDao tlist = null;
	
	public TimeView() {
		
		tlist = new TimeDao();
	
		setLayout(null);
		
		JLabel lbShowDate = new JLabel("출퇴근목록");
		lbShowDate.setBounds(12, 0, 101, 37);
		add(lbShowDate);
		lbShowDate.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		CommutesScrollPane.setBounds(12, 40, 500, 532);
		add(CommutesScrollPane);
		
		commuteTable.setRowMargin(10);
		commuteTable.setRowHeight(30);		
		commuteTable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		//테이블 로우 중 한 줄만 선택 가능.
		
		commuteTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		addCommuteLine(tlist.commute_Time()); 
		CommutesScrollPane.setViewportView(commuteTable);
		
	}
	
		public  void addCommuteLine(ArrayList<Commute> commutes) {
			int size = commutes.size();
			for (int i = 0; i < size; i++) {
				rows = new Vector<String>();
				rows.addElement(commutes.get(i).getDc_date().toString());
				rows.addElement(commutes.get(i).getMem_no().toString());
				rows.addElement(commutes.get(i).getOn_time().toString());
				if(commutes.get(i).getOff_time()==null) {
					rows.addElement(" ");
				}else {
				rows.addElement(commutes.get(i).getOff_time().toString());
				}
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
