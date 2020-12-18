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

import commute.List.Commute_ListDao;

public class TimeView extends JPanel {

private static final long serialVersionUID = 1L;
	
	public Commute_ListDao clist = null;
	public TimeDao tlist = null;
	
	public  JScrollPane CommutesScrollPane = new JScrollPane();//출퇴근목록 보여줄 스크롤 패널
	public JScrollPane CommutesIndividualScrollPane = new JScrollPane();//개인별 출퇴근 목록 보여줄 패널
	
	public Vector<String> listNames = getColum("list");
	public Vector<String> IndividuallistNames = getColum("Individuallist");
	
	public  DefaultTableModel tblModel = new DefaultTableModel(listNames, 0);
	public  DefaultTableModel IndividualtblModel = new DefaultTableModel(IndividuallistNames, 0);
	
	public  JTable commuteTable = new JTable(tblModel) {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	public  JTable commuteIndividualTable = new JTable(IndividualtblModel) {
		public boolean isCellEditable(int row, int column) {
			return false;
		};
	};
	
	public JLabel lbShowDate; 		   //출퇴근 목록 라벨
	public JLabel IndividuallbShowDate;//개인별 출퇴근 목록 라벨
	
	// 행 정보들 담을 벡터
	public Vector<String> rows;
	public Vector<String> Individualrows;
	
	public Commute_ListDao commutelist;
	
	public TimeView() {
		
		tlist = new TimeDao();
		clist = new Commute_ListDao(null, null, null);
	
		setLayout(null);
		
		lbShowDate = new JLabel("출퇴근목록");
		lbShowDate.setBounds(12, 0, 101, 37);
		lbShowDate.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		IndividuallbShowDate = new JLabel("개인출퇴근목록");
		IndividuallbShowDate.setBounds(550, 0, 130, 37);
		IndividuallbShowDate.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		add(lbShowDate);
		add(IndividuallbShowDate);
		
		CommutesScrollPane.setBounds(12, 40, 500, 532);
		CommutesIndividualScrollPane.setBounds(550, 40, 550, 532);
		add(CommutesScrollPane);
		add(CommutesIndividualScrollPane);
		
		commuteTable.setRowMargin(10);
		commuteTable.setRowHeight(30);		
		commuteTable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		commuteIndividualTable.setRowMargin(10);
		commuteIndividualTable.setRowHeight(30);		
		commuteIndividualTable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		
		
		//테이블 로우 중 한 줄만 선택 가능.
		commuteTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		commuteIndividualTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		addCommuteLine(tlist.commute_Time()); 
		addCommuteIndividualLine(clist.commutelist());
		
		CommutesScrollPane.setViewportView(commuteTable);
		CommutesIndividualScrollPane.setViewportView(commuteIndividualTable);
		
	}
		//Jtable에 로우 하나씩 추가하기
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
				
				//로우마다 테이블에 뿌려주기.
				tblModel.addRow(rows);
			}
			CommutesScrollPane.setViewportView(commuteTable);
		}
		
		public void addCommuteIndividualLine(ArrayList<Commute> Individualcommutescommutes) {
			int size = Individualcommutescommutes.size();
			for (int i = 0; i < size; i++) {
				Individualrows = new Vector<String>();
				Individualrows.addElement(Individualcommutescommutes.get(i).getDc_date().toString());
				Individualrows.addElement(Individualcommutescommutes.get(i).getMem_no().toString());
				Individualrows.addElement(Individualcommutescommutes.get(i).getOn_time().toString());
				Individualrows.addElement(Individualcommutescommutes.get(i).getOff_time().toString());
				
				//로우마다 테이블에 뿌려주기.
				IndividualtblModel.addRow(Individualrows);
			}
			
			CommutesIndividualScrollPane.setViewportView(commuteIndividualTable);
		}
		
		private Vector<String> getColum(String check) {
			Vector<String> colNames = new Vector<String>();
			if(check.equals("list")) {
				colNames = new Vector<String>();
				
				colNames.add("출근날짜");
				colNames.add("사원명");
				colNames.add("출근시간");
				colNames.add("퇴근시간");
				
				
				colNames =  colNames;
			}else if(check.equals("Individuallist")){
				IndividuallistNames = new Vector<String>();
				IndividuallistNames.add("출근날짜");
				IndividuallistNames.add("사원명");
				IndividuallistNames.add("출근시간");
				IndividuallistNames.add("퇴근시간");
				
				
				colNames =  IndividuallistNames;
			}

			return colNames;
		}
}
