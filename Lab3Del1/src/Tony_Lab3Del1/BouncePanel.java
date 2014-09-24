package Tony_Lab3Del1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * BouncePanel represents a canvas (drawing area) for objects of type Shape. A
 * timer-object periodically updates the canvas, in the actionPerformed method, 
 * by moving and repainting the objects.
 */

public class BouncePanel extends JPanel implements ActionListener {

	private int width = 400, height = 300;
	private Timer timer;

	private  ArrayList<Shape> theShapes; 

	public BouncePanel() {

		// Create and initialize objects of (sub types of) Shape
		// . . .
		// . . .
		
		theShapes = new ArrayList<Shape>(); 
		Rectangle r = new Rectangle(0,0,width,height);
		theShapes.add(new Line(10,10,Color.black,90,20));
		theShapes.get(0).setVelocity(5, 5);
		theShapes.get(0).setBoundingBox(r);
		
		theShapes.add(new Circle(200, 200, 30, Color.blue, true));
		theShapes.get(1).setVelocity(2, 2);
		theShapes.get(1).setBoundingBox(r); 
		
		theShapes.add(new Rect(200, 200, 20, 20, Color.red, true));
		theShapes.get(2).setVelocity(5, 5);
		theShapes.get(2).setBoundingBox(r);
		
		for(Shape e : theShapes) {
			if(e instanceof Circle) {
				((Circle) e).setFilled(false); // 
			}
		}
		
		// Set the the dimensions of the drawing area
		setPreferredSize(new Dimension(width, height));

		// Create the timer-object, responsible for the animation
		timer = new Timer(20, this);
		timer.start();
	}

	/**
	 * Define what to draw. Called by repaint().
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw all shape objects
		// ...
		for(Shape e : theShapes) {
			e.paint(g);
		}
	}

	/**
	 * Update the position of the ball and repaint. This method is executed by
	 * the timer-object.
	 */
	public void actionPerformed(ActionEvent event) {
		
		// Move all shape objects
		// ...
		for(Shape e : theShapes) { 
			e.move();	// Dynamic binding
		}
		
		repaint(); // Calls paintComponent(g)
	}

	private static final long serialVersionUID = 1L;
}