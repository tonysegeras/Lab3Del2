package Tony_Lab3Del1;

import java.awt.Color;

abstract public class FillableShape extends Shape {
	private boolean filled;
	
	public FillableShape(double x, double y, Color color, boolean filled) {
		super(x, y, color);
		this.filled = filled;
	}
	
	public boolean getFilled() {
		return filled;
	}
	
	public void setFilled(boolean set) {
		filled = set;
	}
}
