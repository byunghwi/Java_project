package stock.stockView;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import stock.Disposal;
import stock.StockDao;
import stock.Stock_info;

// 폐기 정보에 테이블에 대응하는 패널
public class DisposalInfoView extends JPanel {

	public StockDao sdao = new StockDao();
	public JScrollPane disposalInfosScrollPane = new JScrollPane();
	public Vector<String> colNames = getColum();
	public DefaultTableModel tblModel = new DefaultTableModel(colNames, 0){ 
		public boolean isCellEditable(int i, int c)
		{ 
			return false; 
		}};
	public JTable disposalInfoTable = new JTable(tblModel);

	public Vector<String> rows;
	
	public DisposalInfoView(){
		setLayout(null);
	
		disposalInfosScrollPane.setBounds(12, 10, 640, 250);
		add(disposalInfosScrollPane);
		
		disposalInfoTable.setShowGrid(false);
		disposalInfoTable.setSelectionBackground(Color.PINK);
		disposalInfoTable.setShowVerticalLines(false);
		disposalInfoTable.setShowHorizontalLines(false);
		
		disposalInfoTable.setRowMargin(10);
		disposalInfoTable.setRowHeight(30);		
		disposalInfoTable.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		
		disposalInfoTable.getTableHeader().setBackground(new Color(32, 136, 203));
		disposalInfoTable.getTableHeader().setForeground(new Color(255, 255, 255));
		
		disposalInfoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		addDisposalInfoLine(sdao.disposals("default")); 
		
		disposalInfosScrollPane.setViewportView(disposalInfoTable);
	}


	public void addDisposalInfoLine(ArrayList<Disposal> disposals) {
		int size = disposals.size();

		for (int i = 0; i < size; i++) {
			rows = new Vector<String>();
			rows.addElement(disposals.get(i).getDisposalcode());
			rows.addElement(disposals.get(i).getProduct_id());
			rows.addElement(disposals.get(i).getManu_date().toString());
			rows.addElement(disposals.get(i).getDis_date().toString());
			rows.addElement(Integer.toString(disposals.get(i).getQuantity()));
			rows.addElement(disposals.get(i).getMem_id());
			rows.addElement(disposals.get(i).getSave_time().toString());


			tblModel.addRow(rows);
		}
		
		disposalInfosScrollPane.setViewportView(disposalInfoTable);
	}
	
	private Vector<String> getColum() {
		colNames = new Vector<String>();
		colNames.add("폐기번호");
		colNames.add("상품코드");
		colNames.add("제조일");
		colNames.add("폐기일");
		colNames.add("수량");
		colNames.add("처리자");
		colNames.add("처리날짜");


		return colNames;
	}
}