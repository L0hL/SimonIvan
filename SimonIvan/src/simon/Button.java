package simon;

import java.awt.Color;
import java.awt.Graphics2D;

//import GUIpractice.component.Action;
//import GUIpractice.component.Component;

import guiPractice.components.Action;
import guiPractice.components.Component;

public class Button extends Component implements ButtonInterfaceIvan {

	private final static int WIDTH = 50;
	private final static int HEIGHT = 50;
	private Action action;
	private Color display;
	
	
	
	public Button(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public Button() {
		super(0, 0, WIDTH, HEIGHT);
	}
	
	@Override
	public void act() {
		action.act();
	}

	@Override
	public boolean isHovered(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setColor(Color color) {
		display = color;

	}

	@Override
	public void setAction(Action a) {
		action = a;
	}

	@Override
	public void highlight() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dim() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub

	}
}
