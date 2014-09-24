package Tony_Lab3Del1;

import java.awt.Color;
import java.awt.Graphics;

public class Rect extends FillableShape {
	double width, height;

	public Rect(double x, double y, double width, double height, Color color, boolean filled) {
		super(x, y, color, filled);
		this.width = width;
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(getColor());
		g.fillRect((int) super.getX(), (int) super.getY(), (int) width,
				(int) height);
	}
	
	@Override
	protected void constrain() {

		double x0 = super.getBoundingBox().getX(), y0 = super.getBoundingBox().getY();
		double x1 = x0 + super.getBoundingBox().width;
		double y1 = y0 + super.getBoundingBox().height;
		double dx = getDX(), dy = getDY();
		
		// If outside box, change direction
		if(this.getX() < x0) dx = Math.abs(dx);
		if(this.getX()+this.getWidth() > x1) dx = -Math.abs(dx);
		if(this.getY() < y0) dy = Math.abs(dy);
		if(this.getY()+this.getHeight() > y1) dy = -Math.abs(dy);
		
		setVelocity(dx, dy);
	}
	
}
