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
		centerY -= yAmount;
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
		double angle = 0;
		double dX = Math.abs(x - centerX);
		double dY = Math.abs(y - centerY);
		double ratio = dY / dX; //trig ratio
		
		//System.out.println("dX: " + dX);
		//System.out.println("dY: " + dY);
		//System.out.println("ratio: " + ratio);
		
		//calculates distance between clicked point and position of projectile
		//farther away the click, the higher the velocity
		double distance = Math.sqrt((Math.pow(dX, 2) + Math.pow(dY, 2)));
		int newVelocity = (int)distance / 75;
		setVelocity(newVelocity);
		//System.out.println("New Velocity: " + newVelocity);
		
		//calculates angle between clicked point and position of projectile
		//projectile moves directly opposite from click
		angle = Math.toDegrees(Math.atan(ratio));
		if ((x > centerX) && (y < centerY)) {
			angle = angle;  //first quadrant
		} else if ((x < centerX) && (y < centerY)) {
			angle = (180 - angle);  //second quadrant
		} else if ((x < centerX) && (y > centerY)) {
			angle = angle + 180;  //third quadrant
		} else if ((x > centerX) && (y > centerY)) {
			angle = (360 - angle);  //fourth quadrant
		}
		//System.out.println("angle: " + (int)angle);
		setDirection((int) angle + 180);

	}
}
