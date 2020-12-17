package stock.stockframe;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.toedter.calendar.JDateChooser;

import stock.StockDao;
import stock.stockView.DisposalInfoView;

// 폐기 정보에 대한 프레임
public class DisposalInfoFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	Date choose_date;
	Date now = new Date();
	public JDateChooser dateChooser = new JDateChooser();
	public JButton go = new JButton("GO");
	JLabel this_date = new JLabel();
	SimpleDateFormat transFormat = new SimpleDateFormat("YYYY-MM-dd");
	
	public DisposalInfoView div = new DisposalInfoView();
	StockDao sd = new StockDao();
	
	
	public DisposalInfoFrame() {
		
		this_date = new JLabel(transFormat.format(now));
		this_date.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		
		this_date.setBounds(290, -5, 100, 50);
		add(this_date);
		
		dateChooser.setBounds(500, 10, 100, 20);
		add(dateChooser);
		
		div.setBounds(12, 30, 700, 350);
		add(div);
		
		go.setBounds(600, 10, 60, 20);
		add(go);
		
		// 액션 리스너 분할 예정
		go.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				choose_date = new Date();
				choose_date = dateChooser.getDate();
				String choose = transFormat.format(choose_date);
				
				
				div.tblModel.setNumRows(0);
				div.addDisposalInfoLine(sd.disposals(choose));
				this_date.setText(choose);
				
			}
		});
		
		
		setLayout(null);
		setFont(new Font("맑은 고딕", Font.BOLD, 15));
		setTitle("폐기 정보");		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 100, 700, 400);
		setVisible(true);
		
	}
}
