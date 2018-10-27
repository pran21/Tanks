import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GamePanel extends JPanel {
	private Projectile shot;
	private javax.swing.Timer gameLoop;
	private int clickX, clickY;
	
	public GamePanel() {
		shot = new Projectile(700, 400);
		gameLoop = new javax.swing.Timer(5, new gameListener());
		addMouseListener(new clickListener());
		
		gameLoop.start();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		shot.draw(g);
	}
	
	private class gameListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			shot.move();
			repaint();
		}
	}
	
	private class clickListener extends MouseAdapter {
		
		public void mousePressed(MouseEvent e) {
			clickX = e.getX();
			clickY = e.getY();
			shot.setInMotion(clickX, clickY);
		}
		
	}
}
