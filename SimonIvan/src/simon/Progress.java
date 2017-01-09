package simon;

import java.awt.Graphics2D;

import guiPractice.components.Component;

public class Progress extends Component implements ProgressInterfaceIvan {

	private static final int WIDTH = 50;
	private static final int HEIGHT = 50;
	
	public Progress(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public Progress() {
		super(0, 0, WIDTH, HEIGHT);
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRound(int round) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSequencesSize(int sequence) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Graphics2D g) {
		// TODO Auto-generated method stub

	}

}
