import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to store information about user strokes on the canvas
 * @author SHavard
 *
 */
public class Segment {
	private ArrayList<Point> points;
	
	/**
	 * Default constructor
	 * Instantiates empty list to store Points
	 */
	public Segment() {
		points = new ArrayList<Point>();
	}
	
	/**
	 * Constructor to produce a new Segment from a given Point
	 * @param p Point to be added as start of Segment
	 */
	public Segment(Point p) {
		points = new ArrayList<Point>();
		points.add(p);
	}
	
	/**
	 * Add method to provide a new Point in the Segment
	 * @param p Point to be added to the Segment
	 */
	public void addPoint(Point p) {
		points.add(p); 
	}
	
	/**
	 * Add method to add multiple points to the Segment at once
	 * @param ps List of Points to add to the Segment
	 */
	public void addPoints(List<Point> ps) {
		points.addAll(ps);
	}
	
	/**
	 * Method to display the Segment instance on the canvas.
	 * Will display a single point or a line connecting all Points in the Segment
	 * @param g Graphics object from the parent Panel
	 */
	public void show(Graphics g) {
		System.out.println("showing segment");
		g.setColor(Color.WHITE);
		if (points.size() == 1) {
			System.out.println("Drawing Point");
			Point p = points.get(0);
			g.drawLine(p.getX(), p.getY(), p.getX(), p.getY());
		} else if (points.size() > 1) {
			System.out.println("Drawing Line");
			Point prev = points.get(0);
			for (int i = 1; i < points.size(); i++) {
				Point curr = points.get(i);
				g.drawLine(prev.getX(), prev.getY(), curr.getX(), curr.getY());
				prev = curr;
			}
		}
		g.setColor(PaintPanel.BG);
	}

}
