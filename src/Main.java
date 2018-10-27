import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Testing tank game");
		GUI MainScreen = new GUI();
		Container pane = MainScreen.getContentPane();
		GamePanel game = new GamePanel();
		pane.add(game);
		MainScreen.setVisible(true);
		
		Projectile test = new Projectile(0, 0);
		test.setInMotion(2, 2);
		
	}

}
 