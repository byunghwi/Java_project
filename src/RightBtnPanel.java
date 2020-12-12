import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;


public class RightBtnPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton registProdBtn;
	public JButton editProdBtn;
	public JButton delProdBtn;

	public RightBtnPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		registProdBtn = new JButton("상품등록");
		editProdBtn = new JButton("상품수정");
		delProdBtn = new JButton("상품삭제");

		registProdBtn.setForeground(Color.WHITE);
		registProdBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		registProdBtn.setBackground(new Color(204, 206, 206));
		registProdBtn.setBounds(0, 0, 140, 120);
		
		editProdBtn.setForeground(Color.WHITE);
		editProdBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		editProdBtn.setBackground(new Color(204, 206, 206));
		editProdBtn.setBounds(0, 120, 140, 120);
		
		delProdBtn.setForeground(Color.WHITE);
		delProdBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		delProdBtn.setBackground(new Color(204, 206, 206));
		delProdBtn.setBounds(0, 240, 140, 120);

		add(registProdBtn);
		add(editProdBtn);
		add(delProdBtn);
	}

}