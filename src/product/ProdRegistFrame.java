package product;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;



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
		String[] textHints = new String[] {"상품코드를 입력하세요.",  "상품명을 입력하세요.", "가격을 입력하세요"};
		
		public JLabel[] labels;
		public JLabel titleLabel;
		public Product product = new Product();
		
		public JTextField tf1;
		public JTextField tf2;
		public JTextField tf3;
		
		public JDateChooser dateChooser1 = new JDateChooser();
		public JDateChooser dateChooser2 = new JDateChooser();
		
		public ProdRegistFrame(){

			titleLabel = new JLabel("[ 상품 등록 ]");
			titleLabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
			titleLabel.setBounds(0,20, 100, 50);
						
			setFont(new Font("맑은 고딕", Font.BOLD, 20));
			setTitle("상품등록");		
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 340, 420);
			contentPanel = new JPanel(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPanel);
			setResizable(false);
			setLocationRelativeTo(null);
			setVisible(false);
			contentPanel.setLayout(null);
			
			pIn = new JPanel();
			pIn.setBounds(5, 5, 310, 400);
			contentPanel.add(pIn);
			pIn.setLayout(null);
			pIn.setFocusable(false);
			
			labels = new JLabel[fieldNames.length];
			
			//상품코드
			tf1 = new HintTextField(textHints[0]);
			tf1.setBounds(130, 50, 170 , 30);
			
			//상품명
			tf2 = new HintTextField(textHints[1]);
			tf2.setBounds(130, 100, 170 , 30);
			
			//제조일
			dateChooser1.setBounds(130, 150, 170 , 30);
			//폐기일
			dateChooser2.setBounds(130, 200, 170 , 30);
			
			//가격
			tf3 = new HintTextField(textHints[2]);
			tf3.setBounds(130, 250, 170 , 30);
			
			for (int j = 0; j < fieldNames.length; j++) {
				labels[j] = new JLabel(fieldNames[j]);
				labels[j].setFont(new Font("맑은 고딕", Font.BOLD, 12));
				labels[j].setBounds(30, (j+1)*50, 50 , 30);
				pIn.add(labels[j]);
			}
			
			pIn.add(tf1);
			pIn.add(tf2);
			pIn.add(dateChooser1);
			pIn.add(dateChooser2);
			pIn.add(tf3);

			regBtn = new JButton("등록");
			regBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			regBtn.setBounds(90, 320, 70, 30);

			cancelBtn = new JButton("취소");
			cancelBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
			cancelBtn.setBounds(190, 320, 70, 30);
			
			pIn.add(regBtn, BorderLayout.SOUTH);
			pIn.add(cancelBtn, BorderLayout.SOUTH);

		}
		
		//필드값 초기화 해주기.
		public void resetText() {
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			dateChooser1.setDate(null);
			dateChooser2.setDate(null);
		}
}
