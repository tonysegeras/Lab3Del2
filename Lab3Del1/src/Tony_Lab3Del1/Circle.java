package Tony_Lab3Del1;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends FillableShape {
	double diameter;

	public Circle(double x, double y, double diameter, Color color, boolean filled) {
		super(x, y, color, filled);
		this.diameter = diameter;
	}

	public double getDiameter() {
		return diameter;
	}

	@Override
	public void paint(Graphics g) {
		if (this.getFilled()) {
			g.setColor(super.getColor());
			g.fillOval((int) (super.getX() - diameter / 2),
					(int) (super.getY() - diameter / 2), (int) (diameter),
					(int) (diameter));
		} else {
			g.drawOval((int) (super.getX() - diameter / 2),
					(int) (super.getY() - diameter / 2), (int) (diameter),
					(int) (diameter));
		}

	}

	@Override
	protected void constrain() {

		double x = getX(), y = getY();
		double dx = this.getDX(), dy = this.getDY();
		double radius = this.diameter/2;

		// If outside the box - calculate new dx and dy
		if (x < radius)
			dx = Math.abs(dx);
		else if (x > getBoundingBox().width - radius)
			dx = -Math.abs(dx);
		if (y < radius)
			dy = Math.abs(dy);
		else if (y > getBoundingBox().height - radius)
			dy = -Math.abs(dy);

		setVelocity(dx, dy);
	}
}
