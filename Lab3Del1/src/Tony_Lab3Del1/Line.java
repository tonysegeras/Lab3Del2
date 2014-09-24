package Tony_Lab3Del1;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	private double x2, y2;
	
	public Line(double x, double y, Color color, int x2, int y2) {
		super(x, y, color);
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public double getX2() {
		return x2;
	}
	
	public double getY2() {
		return y2;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		g.drawLine((int)super.getX(), (int)super.getY(), (int)x2, (int)y2);
	}

	public void move() {
		
		x2 += getDX(); y2 += getDY();
		super.move();
	}
	
	protected void constrain() {

		double x0 = super.getBoundingBox().getX(), y0 = super.getBoundingBox().getY();
		double x1 = x0 + super.getBoundingBox().width;
		double y1 = y0 + super.getBoundingBox().height;
		double dx = getDX(), dy = getDY();
		
		// If outside box, change direction
		if(this.getX() < x0) dx = Math.abs(dx);
		if(this.getX2() > x1) dx = -Math.abs(dx);
		if(this.getY() < y0) dy = Math.abs(dy);
		if(this.getY2() > y1) dy = -Math.abs(dy);
		
		setVelocity(dx, dy);
	} 
	
}
