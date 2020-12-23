package stock.stockframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.toedter.calendar.JDateChooser;

import common.RoundedButton;
import stock.StockDao;
import stock.stockView.DisposalInfoView;

// 폐기 정보에 대한 프레임
public class DisposalInfoFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	Date choose_date;
	Date now = new Date();
	public JDateChooser dateChooser = new JDateChooser();
	public RoundedButton go = new RoundedButton("GO");
	JLabel this_date = new JLabel();
	SimpleDateFormat transFormat = new SimpleDateFormat("YYYY-MM-dd");
	
	public DisposalInfoView div = new DisposalInfoView();
	StockDao sd = new StockDao();
	
	
	public DisposalInfoFrame() {
		
		this_date = new JLabel(transFormat.format(now));
		this_date.setFont(new Font("나눔 고딕", Font.BOLD, 18));
		
		this_date.setBounds(280, -5, 100, 50);
		add(this_date);
		
		JLabel newLabel = new JLabel("폐기 정보");
		newLabel.setFont(new Font("나눔고딕", Font.BOLD, 15));
		newLabel.setBounds(35, 15, 174, 15);
		add(newLabel);
		
		dateChooser.setBounds(500, 10, 100, 20);
		add(dateChooser);
		
		div.setBounds(12, 30, 700, 350);
		add(div);
		
		go.setBounds(605, 10, 55, 20);
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
		
		setResizable(false);
		setLayout(null);
		setFont(new Font("나눔고딕", Font.BOLD, 15));
		setTitle("폐기 정보");		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 100, 700, 400);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new DisposalInfoFrame();
	}
}
