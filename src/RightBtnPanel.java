import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RightBtnPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton registProdBtn;
	public JButton delProdBtn;

	public RightBtnPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		registProdBtn = new JButton("상품등록");
		delProdBtn = new JButton("상품삭제");
		registProdBtn.setBounds(0, 0, 164, 120);
		delProdBtn.setBounds(0, 120, 164, 120);
		add(registProdBtn);
		add(delProdBtn);
		
		registProdBtn.setForeground(Color.WHITE);
		registProdBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		registProdBtn.setBackground(new Color(204, 204, 204));
		registProdBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new OpenSubFrame();
				
			}
		});
		
		delProdBtn.setForeground(Color.WHITE);
		delProdBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		delProdBtn.setBackground(new Color(153, 153, 153));
		delProdBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//new OpenSubFrame();
			}
		});
		
	}
	
	
	class OpenSubFrame extends JFrame{

		/**
		 * 
		 */
		JButton regBtn;
		JButton cancelBtn;
		JPanel contentPanel;
		
		String[] fieldNames = new String[]{"상품코드", "상품명", "제조일", "폐기일", "가격"};
		JLabel[] labels;
		JLabel titleLabel;
		JTextField[] fields;
		
		private static final long serialVersionUID = 1L;
		
		public OpenSubFrame() {
			contentPanel = new JPanel(new BorderLayout());
			
			titleLabel = new JLabel("[ 상품 등록 ]");
			titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			titleLabel.setBounds(0,20, 100, 50);
			
			
			setFont(new Font("맑은 고딕", Font.BOLD, 20));
			setTitle("상품등록");
			setResizable(false);
			setSize(400,470);
			
			setContentPane(contentPanel);
			
			labels = new JLabel[fieldNames.length];
			fields = new JTextField[fieldNames.length];
			
			for (int i = 0; i < fieldNames.length; i++) {
				System.out.println(fieldNames[i]);
				labels[i] = new JLabel(fieldNames[i]);
				labels[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
				labels[i].setBounds(50, (i+1)*50, 50 , 30);
				
				fields[i] = new JTextField();
				fields[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
				fields[i].setBounds(150, (i+1)*50, 170 , 30);
				
				contentPanel.add(labels[i]);
				contentPanel.add(fields[i]);
			}

			regBtn = new JButton("등록");
			regBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			regBtn.setBounds(114, 350, 70, 30);
			cancelBtn = new JButton("취소");
			cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			cancelBtn.setBounds(207, 350, 70, 30);
			
			contentPanel.add(regBtn, BorderLayout.SOUTH);
			contentPanel.add(cancelBtn, BorderLayout.SOUTH);
			contentPanel.setLayout(null);
			contentPanel.setBounds(0, 0, 300, 300);

			setLocationRelativeTo(null);
			setVisible(true);	
		}
	}
}
