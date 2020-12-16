package account;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import account.action.Login_Action;
import account.action.PopJoin_Action;
import product.HintPasswordField;
import product.HintTextField;


public class FirstFrame extends JFrame {
	
	public JTextField[] infos = new JTextField[2]; 
	String [] info_data = new String[2];
	JLabel[] names = new JLabel[2];
	

	ImageIcon login_button = new ImageIcon("C:/Users/Young/git/Java_project/src/로그인버튼.jpg");
	ImageIcon join_button = new ImageIcon("C:/Users/Young/git/Java_project/src/회원가입.jpg");
	JButton login = new JButton(login_button);
	JButton join = new JButton(join_button);
    JScrollPane scrollPane;
    
	Image backgroundimg = new ImageIcon("C:/Users/Young/git/Java_project/src/로그인틀.jpg").getImage();
	
	
    public FirstFrame() {
        //배경 Panel 생성후 컨텐츠페인으로 지정      
    	JPanel background = new JPanel() {
            public void paintComponent(Graphics g) {
             
                g.drawImage(backgroundimg, 0, 0, null);
              
                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
                super.paintComponent(g);
        }
    };
    	
    	login.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    	join.setBorder(javax.swing.BorderFactory.createEmptyBorder());
    	background.add(join).setBounds(212, 551, 55, 20);
	 	background.add(login).setBounds(48, 400, 300, 70);
	 	background.setLayout(null);
	 	
    	scrollPane = new JScrollPane(background);
    	setContentPane(scrollPane);
    	this.getContentPane().setBackground(Color.WHITE);
 	 	
     	
    	infos[0] = new HintTextField("아이디 입력");
    	infos[0].setBorder(javax.swing.BorderFactory.createEmptyBorder());
		this.add(infos[0]).setBounds(40, 175 ,200,30);
		
    	infos[1] = new HintPasswordField("패스워드 입력");   
		infos[1].setBorder(javax.swing.BorderFactory.createEmptyBorder());
		this.add(infos[1]).setBounds(40, 275, 200, 30);
		
        
		login.addActionListener(new Login_Action(this));
		join.addActionListener(new PopJoin_Action());
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(410, 670);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("LOGIN");
        setVisible(true);
        setLayout(null);
        
        

    }


	

	
	public static void main(String[] args) {
		new FirstFrame();
	}
}
