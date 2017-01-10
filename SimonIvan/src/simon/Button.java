package simon;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import GUIpractice.component.Action;
import GUIpractice.component.Component;

public class Button extends Component implements ButtonInterfaceIvan {

	private final static int WIDTH = 50;
	private final static int HEIGHT = 50;
	private Action action;
	private Color display;
	private Color color;
	
	public Button() {
		super(0, 0, WIDTH, HEIGHT);
	}
	
	@Override
	public void act() {
		action.act();
	}

	@Override
	public boolean isHovered(int x, int y) {
		if(x > 0 && x < getX() + getWidth() && y > 0 && y < getY() + getHeight())
			return true;
		return false;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
		display = color;
		update();
	}

	@Override
	public void setAction(Action a) {
		action = a;
	}

	@Override
	public void highlight() {
		if(color != null)
			display = color;
		update();
	}

	@Override
	public void dim() {
		display = Color.gray;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if(display != null)
			g.setColor(display);
		else
			g.setColor(Color.gray);//make it gray if color is not specified 
		
		g.fillOval(0, 0, WIDTH, HEIGHT);
		g.setColor(Color.black);
		g.drawOval(0, 0, WIDTH-1, HEIGHT-1);
	}
}
