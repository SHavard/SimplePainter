import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Custom JPanel acting as a canvas to create simple drawings on
 * Single colour drawing at set stroke weight
 * @author SHavard
 *
 */
public class PaintPanel extends JPanel{

	/**
	 * Constant background colour value
	 */
	public final static Color BG = Color.BLACK;

	private ArrayList<Segment> segments;

	/**
	 * Sole constructor for custom panel.
	 * Sets up listeners and canvas
	 */
	public PaintPanel() {
		this.setBackground(BG);
		Brush b = new Brush();
		this.addMouseListener(b);
		this.addMouseMotionListener(b);
		segments = new ArrayList<Segment>();
	}

	/**
	 * Simple canvas reset- clears drawing space and removes stored strokes
	 */
	private void reset() {
		segments = new ArrayList<Segment>();
		repaint();
	}

	/**
	 * Overridden paintComponent to display user's strokes
	 */
	@Override
	public void paintComponent(Graphics g) {
		System.out.println("Painting panel");
		super.paintComponent(g);
		if (segments.size() < 1) {
			System.out.println("<1 segment in panel. Clearing panel");
			g.setColor(BG);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
		} else if (segments.size() >= 1) {
			System.out.println(">1 segment in panel. Drawing segments");
			for (Segment s : segments) {
				s.show(g);
			}
		}
	}

	/**
	 * Method to remove code from mousePressed event.
	 * Creates a new segment on left mouse button
	 * Clears canvas on right mouse button
	 * @param e MouseEvent object from mousePressed event
	 */
	private void press(MouseEvent e) {
		System.out.println("mouse pressed");
		switch (e.getButton()) {
		case MouseEvent.BUTTON1:
			System.out.println("Button 1");
			//create new segment and add current mouse position to segment
			Segment s = new Segment(new Point(e.getX(), e.getY()));
			segments.add(s);
			break;
		case MouseEvent.BUTTON3:
			System.out.println("Button 3");
			//clear background
			reset();
			break;
		default: 
			//do nothing
			break;
		}
		repaint();
	}
	
	/**
	 * Method to remove code from mouseDragged event.
	 * Adds new Points to the most recently created Segment on LMB drags
	 * @param e MouseEvent object from mouseDragged event
	 */
	private void drag(MouseEvent e) {
		System.out.println("mouse dragged");
		System.out.println("Button " + e.getButton() + " dragged");
		if (SwingUtilities.isLeftMouseButton(e)) {
			System.out.println("Button 1 dragged");
			//get most recent segment
			Segment s = segments.get(segments.size() -1);
			//add mouse position to segment
			s.addPoint(new Point(e.getX(), e.getY()));
			repaint();
		}
	}

	/**
	 * Very simple MouseListener
	 * Detects mouse presses or drags and hands them off to encapsulating panel
	 * @author SHavard
	 *
	 */
	private class Brush extends MouseAdapter {

		public void mouseDragged(MouseEvent e) {
			drag(e);
		}

		public void mousePressed(MouseEvent e) {
			press(e);
		}

	}


}
