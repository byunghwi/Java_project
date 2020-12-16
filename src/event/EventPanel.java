package event;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;


public class EventPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	EventDao eventdao = new EventDao();
	public JScrollPane eventScrollPane = new JScrollPane();
	public Vector<String> colNames = getColum();
	public DefaultTableModel tblModel = new DefaultTableModel(colNames, 0);
	public JTable eventTable = new JTable(tblModel);
	//행 정보들 담을 벡터
	public Vector<String> rows;
	
	public EventPanel(){
		setLayout(null);
		
	
		eventScrollPane.setBounds(12, 10, 1133, 532);
		add(eventScrollPane);
		
		eventTable.setRowMargin(10);
		eventTable.setRowHeight(30);		
		eventTable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		//테이블 로우 중 한 줄만 선택 가능.
		eventTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		addEventLine(eventdao.eventAll()); 
		
		eventScrollPane.setViewportView(eventTable);
		
	}

	//Jtable에 로우 하나씩 추가하기.
	public void addEventLine(ArrayList<Event> events) {
		int size = events.size();

		for (int i = 0; i < size; i++) {
			rows = new Vector<String>();

			rows.addElement(events.get(i).getEvent_no()); 	// 이벤트코드
			rows.addElement(events.get(i).getEvent_type()); // 이벤트명
			rows.addElement(events.get(i).getProduct_id());	// 상품코드
			rows.addElement(events.get(i).getProduct_nm()); // 상품명
			rows.addElement(events.get(i).getStart_date()); // 이벤트 시작일
			rows.addElement(events.get(i).getEnd_date());	// 이벤트 종료일
			rows.addElement(events.get(i).getWorker_no());	// 이벤트 등록자
			rows.addElement(events.get(i).getSave_time());	// 이벤트 등록일

			//로우마다 테이블에 뿌려주기.
			tblModel.addRow(rows);
		}
		
		eventScrollPane.setViewportView(eventTable);
	}
	
	private Vector<String> getColum() {
		colNames = new Vector<String>();
		colNames.add("이벤트코드");
		colNames.add("이벤트명");
		colNames.add("상품코드");
		colNames.add("상품명");
		colNames.add("시작일");
		colNames.add("종료일");
		colNames.add("등록자");
		colNames.add("등록시간");

		return colNames;
	}
}