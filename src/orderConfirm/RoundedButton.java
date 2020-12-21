package orderConfirm;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class RoundedButton extends JButton { 
	
	public RoundedButton() {
		super(); 
		decorate(); 
	} 
	
	public RoundedButton(String text) {
		super(text); 
		decorate(); 
	} 
	
	public RoundedButton(Action action) {
		super(action); 
		decorate(); 
	} 
	
	public RoundedButton(Icon icon) {
		super(icon); 
		decorate(); 
	} 
	
	public RoundedButton(String text, Icon icon) {
		super(text, icon); 
		decorate(); 
	} 
	
	protected void decorate() {
		setBorderPainted(false); 
		setOpaque(false); 
	} 
	
	protected void paintComponent(Graphics g) {
		int width = getWidth(); 
		int height = getHeight(); 
		
		Graphics2D graphics = (Graphics2D) g; 
		
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
		
		// 버튼 클릭, 올리는 action따라 색깔다르게
//		if (getModel().isArmed()) {
//			graphics.setColor(getBackground().darker()); 
//		} else if (getModel().isRollover()) { 
//			graphics.setColor(getBackground().brighter()); 
//		} else {
//			graphics.setColor(getBackground().BLACK); 
//		} 
		
		Color color = new Color(71, 115, 133);
		
		if (getModel().isArmed()) {
			graphics.setColor(getBackground().brighter()); 
		} else if (getModel().isRollover()) { 
			graphics.setColor(getBackground().darker()); 
		} else {
			graphics.setColor(color); 
		} 
		
		graphics.fillRoundRect(0, 0, width, height, 10, 10); 
		
		FontMetrics fontMetrics = graphics.getFontMetrics(); 
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); 
		
		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
		
		graphics.setColor(Color.WHITE); 
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY); 
		graphics.dispose(); 
		
		super.paintComponent(g);

	}

	
	
	
	
}
