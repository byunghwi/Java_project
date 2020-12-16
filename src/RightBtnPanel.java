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
	public JButton registEventBtn;

	public RightBtnPanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		registProdBtn = new JButton("상품등록");
		editProdBtn = new JButton("상품수정");
		delProdBtn = new JButton("상품삭제");
		registEventBtn = new JButton("이벤트등록");

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
		
		registEventBtn.setForeground(Color.WHITE);
		registEventBtn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		registEventBtn.setBackground(new Color(204, 206, 206));
		registEventBtn.setBounds(0, 360, 140, 120);

		add(registProdBtn);
		add(editProdBtn);
		add(delProdBtn);
		add(registEventBtn);
	}

}