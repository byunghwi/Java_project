package stocksub.stockView;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import stocksub.StockDao;
import stocksub.Stock_info;

public class StockInfoView extends JPanel {

private static final long serialVersionUID = 1L;
	
	public StockDao sdao = new StockDao();
	public JScrollPane stocksScrollPane = new JScrollPane();
	public Vector<String> colNames = getColum();
	public DefaultTableModel tblModel = new DefaultTableModel(colNames, 0);
	public JTable stockTable = new JTable(tblModel);
	//�� ������ ���� ����
	public Vector<String> rows;
	String product_id;
	
	public StockInfoView(String product_id){
		this.product_id = product_id;
		setLayout(null);
	
		stocksScrollPane.setBounds(12, 10, 640, 300);
		add(stocksScrollPane);
		
		stockTable.setRowMargin(10);
		stockTable.setRowHeight(30);		
		stockTable.setFont(new Font("���� ���", Font.PLAIN, 15));
		
		//���̺� �ο� �� �� �ٸ� ���� ����.
		stockTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		addStockLine(sdao.stockInfos(product_id)); 
		
		stocksScrollPane.setViewportView(stockTable);
	}

	//Jtable�� �ο� �ϳ��� �߰��ϱ�.
	public void addStockLine(ArrayList<Stock_info> stock_infos) {
		int size = stock_infos.size();

		for (int i = 0; i < size; i++) {
			rows = new Vector<String>();
			rows.addElement(stock_infos.get(i).getProduct_id());
			rows.addElement(stock_infos.get(i).getProduct_name());
			rows.addElement(Integer.toString(stock_infos.get(i).getQuantity()));
			rows.addElement(stock_infos.get(i).getManu_date().toString());
			rows.addElement(stock_infos.get(i).getDis_date().toString());
			

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
		colNames.add("������");
		colNames.add("�����");


		return colNames;
	}
}
