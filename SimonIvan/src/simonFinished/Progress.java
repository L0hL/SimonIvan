package simonFinished;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import GUIpractice.component.Component;

public class Progress extends Component implements ProgressInterfaceIvan {
	
	public boolean gameOver = false;
	public int width;
	public int height;

	
	/**
		Records your movement?
		Should be able to tell if you lose or continue to the next level?
	 */
	
	
	
	
	public Progress(int x, int y, int height, int width) {
		super(x, y, height, width);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void gameOver() {
		gameOver = true;
		update();
		
	}
	@Override
	public void setRound(int round) {
		
		update();
		
	}

	@Override
	public void setSequencesSize(int sequence) {
		
		update();
		
	}

	@Override
	public void update(Graphics2D g) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		g.setColor(Color.black);
		if(gameOver){
			
		}
		if(!gameOver){
			
		}
		
	}



}
