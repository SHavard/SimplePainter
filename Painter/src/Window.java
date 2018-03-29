import javax.swing.JFrame;

/**
 * Simple JFrame to deploy custom JPanel
 * @author SHavard
 *
 */
public class Window extends JFrame{

	/**
	 * constructor for Window
	 * creates a new JFrame and sets custom JPanel as content pane
	 */
	public Window() {
		super("Painter");
		this.setSize(800, 600);
		this.setContentPane(new PaintPanel());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Window();
	}
}
