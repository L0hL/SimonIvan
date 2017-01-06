package simonFinished;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import GUIpractice.components.Action;
import GUIpractice.components.TextLabel;
import GUIpractice.components.Visible;
import GUIpractice.sampleGames.ClickableScreen;

public class SimonScreenIvan extends ClickableScreen implements Runnable {
	private TextLabel label;
	private ButtonInterfaceIvan button;
	private ProgressInterfaceIvan progress;
	private ArrayList<MoveInterfaceIvan> move;
	
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	int lastSelectedButton;


	public SimonScreenIvan(int width, int height) {
		super(width,height);
		Thread app = new Thread(this);
		app.start();
	}

	@Override
	public void run() {
		label.setText("");
		nextRound();
		
	}

	private void nextRound() {
		// TODO Auto-generated method stub
		
	}
	public void changeText(String s){
		try{
			Thread.sleep(1000);
			
		}catch (InterruptedException e) {								
			e.printStackTrace();
		}
		
	}
	public void playSequence(){
		
	}
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();
		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		move = new ArrayList<MoveInterfaceIvan>();
		//add 2 moves to start
		lastSelectedButton = -1;
		move.add(randomMove());
		move.add(randomMove());
		roundNumber = 0;
		viewObjects.add(progress);
		viewObjects.add(label);
		
	}


	private void addButtons() {
		int numberOfButtons = 7;
		Color colors[] = { Color.red, Color.orange, Color.yellow, Color.green, Color.blue, 
								new Color(75,0,130), new Color(238,130,238)};
		for(int i = 0; i < numberOfButtons; i++ ){
			final ButtonInterfaceIvan b = getAButton();
			b.setColor(colors[i]);
		    b.setX(25);
		    b.setY(50);
		    b.setAction(new Action(){
		    	public void act(){
		    		if(acceptingInput){
		    			Thread blink = new Thread(new Runnable(){
		    				public void run(){
		    					b.highlight();
		    					try {
									Thread.sleep(800);
								} catch (InterruptedException e) {								
									e.printStackTrace();
								}
		    					b.dim();
		    				}
		    			});
		    			
		    			blink.start();
		    			if(b == move.get(sequenceIndex).getButton()){
							sequenceIndex++;
						}else{
		    				ProgressInterfaceIvan.gameOver();
		    			}
		    			
		    			if(sequenceIndex == move.size()){
		    				Thread nextRound = new Thread(SimonScreenIvan.this);
		    				nextRound.start(); 
						}
		    			
		    		}
		    	}
		    });
		    viewObjects.add(b); // had to change to protected in Screen <not sure if correct way>
		}
		

	}




	private ButtonInterfaceIvan getAButton() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	Placeholder until partner finishes implementation of ProgressInterface
	*/
	public ProgressInterfaceIvan getProgress() {
		// TODO Auto-generated method stub
		return null;
	}

	public MoveInterfaceIvan randomMove() {
		Button b;
		//code that randomly selects a ButtonInterfaceX
		return getMove(b)
	}




}
