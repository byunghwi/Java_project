package stocksub;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class StockView extends JPanel {
	
	
	private static final long serialVersionUID = 1L;
	
	public StockDao sdao = new StockDao();
	public JScrollPane stocksScrollPane = new JScrollPane();
	public Vector<String> colNames = getColum();
	public DefaultTableModel tblModel = new DefaultTableModel(colNames, 0);
	public JTable stockTable = new JTable(tblModel);
	//�� ������ ���� ����
	public Vector<String> rows;
	
	public StockView(){
		setLayout(null);
	
		stocksScrollPane.setBounds(12, 10, 1133, 532);
		add(stocksScrollPane);
		
		stockTable.setRowMargin(10);
		stockTable.setRowHeight(30);		
		stockTable.setFont(new Font("���� ���", Font.PLAIN, 15));
		
		//���̺� �ο� �� �� �ٸ� ���� ����.
		stockTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		addStockLine(sdao.stockAll()); 
		
		stocksScrollPane.setViewportView(stockTable);
	}

	//Jtable�� �ο� �ϳ��� �߰��ϱ�.
	public void addStockLine(ArrayList<Stock> stocks) {
		int size = stocks.size();

		for (int i = 0; i < size; i++) {
			rows = new Vector<String>();
			rows.addElement(stocks.get(i).getProduct_id());
			rows.addElement(stocks.get(i).getProduct_name());
			rows.addElement(Integer.toString(stocks.get(i).getQuantity()));
			rows.addElement(Integer.toString(stocks.get(i).getPrice()));

			//�ο츶�� ���̺� �ѷ��ֱ�.
			tblModel.addRow(rows);
		}
		
		stocksScrollPane.setViewportView(stockTable);
	}
	
	private Vector<String> getColum() {
		colNames = new Vector<String>();
		colNames.add("��ǰ�ڵ�");
		colNames.add("��ǰ��");
		colNames.add("����");
		colNames.add("����");


		return colNames;
	}
}