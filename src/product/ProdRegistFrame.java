package product;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

//상품 등록 버튼 누를시 Sub 프레임 생성 및 입력해주기.
public class ProdRegistFrame extends JFrame{
		/**
		 * 
		 */
		public JButton regBtn;
		public JButton cancelBtn;
		JPanel contentPanel;
		JPanel pIn;
		
		String[] fieldNames = new String[]{"상품코드", "상품명", "제조일", "폐기일", "가격"};
		String[] textHints = new String[] {"상품코드를 입력하세요.",  "상품명을 입력하세요." , "YYYYmmdd", "YYYYmmdd", "가격을 입력하세요"};
		
		public JLabel[] labels;
		public JLabel titleLabel;
		public JTextField[] fields;
		public Product product = new Product();
		
		public ProdRegistFrame(){
			
			
			titleLabel = new JLabel("[ 상품 등록 ]");
			titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			titleLabel.setBounds(0,20, 100, 50);
			
			
			setFont(new Font("맑은 고딕", Font.BOLD, 20));
			setTitle("상품등록");		
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 340, 400);
			contentPanel = new JPanel(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPanel);
			setResizable(false);
			setLocationRelativeTo(null);
			setVisible(false);
			contentPanel.setLayout(null);
			
			pIn = new JPanel();
			pIn.setBounds(5, 5, 300, 400);
			contentPanel.add(pIn);
			pIn.setLayout(null);
			
			labels = new JLabel[fieldNames.length];
			fields = new JTextField[fieldNames.length];
			
			for (int i = 0; i < fieldNames.length; i++) {
				//System.out.println(fieldNames[i]);
				labels[i] = new JLabel(fieldNames[i]);
				labels[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
				labels[i].setBounds(30, (i+1)*50, 50 , 30);
				
				fields[i] = new HintTextField(textHints[i]);
				//fields[i].setFont(new Font("맑은 고딕", Font.BOLD, 12));
				fields[i].setBounds(130, (i+1)*50, 170 , 30);
				
				pIn.add(labels[i]);
				pIn.add(fields[i]);
			}

			regBtn = new JButton("등록");
			regBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			regBtn.setBounds(90, 320, 70, 30);

			cancelBtn = new JButton("취소");
			cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			cancelBtn.setBounds(190, 320, 70, 30);
			
			pIn.add(regBtn, BorderLayout.SOUTH);
			pIn.add(cancelBtn, BorderLayout.SOUTH);
			pIn.setBounds(0, 0, 300, 400);

		}
		
		//텍스트필드 초기화 해주기.
		public void resetText(JTextField[] fields) {
			if(fields.length > 0) {
				for (int i = 0; i < fields.length; i++) {
					fields[i].setText("");
				}
			}
		}
}
