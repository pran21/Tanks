import java.awt.*;

public class Projectile {
	private int centerX, centerY;
	private int velocity;
	private int direction;
	
	public Projectile(int x, int y) {
		centerX = x;
		centerY = y;
		velocity = 0;
		direction = 0;
	}
	
	public void draw(Graphics g) {
		Color oldColor = g.getColor();
		g.setColor(Color.BLACK);
		g.fillOval(centerX - 30, centerY - 30, 60, 60);
		g.setColor(oldColor);
	}
	
	public void move(int xAmount, int yAmount) {
		centerX += xAmount;
		centerY += yAmount;
	}
	
	public void move() {
		move((int) (velocity * Math.cos(Math.toRadians(direction))),
				(int) (velocity * Math.sin(Math.toRadians(direction))));
	}
	
	public void turn(int degrees) {
		direction += (degrees % 360);
	}
	
	public void setDirection(int degrees) {
		direction = degrees % 360;
	}
	
	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}
	
	public void setPosition(int x, int y) {
		centerX = x;
		centerY = y;
	}
	
	public void setInMotion(int x, int y) {
		int dX = x - centerX;
		int dY = y - centerY;
		
		//calculates distance between clicked point and position of projectile
		//farther away the click, the higher the velocity
		double distance = Math.sqrt((Math.pow(dX, 2) + Math.pow(dY, 2)));
		int newVelocity = (int)distance / 75;
		setVelocity(newVelocity);
		System.out.println("New Velocity: " + newVelocity);
		
		//calculates angle between clicked point and position of projectile
		//projectile moves directly opposite from click
		double angle = Math.toDegrees(Math.atan(dY/dX));
		int oppositeAngle = (int)angle + 180;
		setDirection(oppositeAngle);
		System.out.println("Launch Angle: " + oppositeAngle);

	}
}
