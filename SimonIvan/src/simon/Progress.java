package simon;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import GUIpractice.component.Component;

public class Progress extends Component implements ProgressInterfaceIvan {

	private static final int WIDTH = 110;
	private static final int HEIGHT = 70;
	
	private boolean gameOver;
	private String round;
	private String sequence;
	
	public Progress() {
		super(0, 0, WIDTH, HEIGHT);
	}

	@Override
	public void gameOver() {
		gameOver = true;
		update();
	}

	@Override
	public void setRound(int round) {
		this.round = "Round: " + round;
		update();
	}

	@Override
	public void setSequencesSize(int sequence) {
		this.sequence = "Sequence: " + sequence;
		update();
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		FontMetrics fm = g.getFontMetrics();
		
		g.setColor(Color.darkGray);
		g.fillRect(0,  0,  WIDTH, HEIGHT);
		g.setColor(Color.black);
		g.drawRect(0, 0, WIDTH-1, HEIGHT-1);
		g.setColor(Color.white);
		
		if(gameOver){
			String s = "Game Over!";
			g.drawString(s, (WIDTH - fm.stringWidth(s))/2, 30);
			g.drawString(sequence, (WIDTH - fm.stringWidth(sequence))/2, 50);
		}else{
			if(round != null && sequence != null){
				g.drawString(round, (WIDTH - fm.stringWidth(round))/2, 30);
				g.drawString(sequence, (WIDTH - fm.stringWidth(sequence))/2, 50);
			}
		}

	}

}
