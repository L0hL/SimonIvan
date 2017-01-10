package simon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import GUIpractice.ClickableScreen;
import GUIpractice.component.Action;
import GUIpractice.component.TextLabel;
import GUIpractice.component.Visible;

public class SimonScreenIvan extends ClickableScreen implements Runnable {
	
	private TextLabel label;
	private ButtonInterfaceIvan[] button;
	private ProgressInterfaceIvan progress;
	private ArrayList<MoveInterfaceIvan> move;
	
	private int roundNumber;
	private boolean acceptingInput;
	private int sequenceIndex;
	int prevButton;
	
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
		acceptingInput = false;
		roundNumber++;
		
		progress.setRound(roundNumber);
		move.add(randomMove());
		
		progress.setSequencesSize(move.size());
		
		changeText("Simon's turn.");
		label.setText("");
		
		playSequence();
		
		changeText("Your turn.");
		label.setText("");
		
		acceptingInput = true;
		sequenceIndex = 0;
	}
	
	public void changeText(String s){
		try{
			label.setText(s);
			Thread.sleep(1000);
		}catch (InterruptedException e) {								
			e.printStackTrace();
		}
		
	}
	
	public void playSequence(){
		ButtonInterfaceIvan b = null;
		for(MoveInterfaceIvan m: move){
			if(b != null)
				b.dim();
			
			b = m.getButton();
			b.highlight();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		b.dim();
	}
	
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		addButtons();

		progress = getProgress();
		label = new TextLabel(130,230,300,40,"Let's play Simon!");
		move = new ArrayList<MoveInterfaceIvan>();
		
		prevButton = -1;
		move.add(randomMove());
		move.add(randomMove());
		
		roundNumber = 0;
		
		viewObjects.add(progress);
		viewObjects.add(label);
	}
	
	private void addButtons() {
		int numberOfButtons = 7;
		Color colors[] = {Color.red, Color.orange, Color.yellow, Color.green, Color.blue, 
								new Color(75,0,130), new Color(238,130,238)};
		
		button = new ButtonInterfaceIvan[numberOfButtons];

		for(int i = 0; i < numberOfButtons; i++){
			button[i] = getAButton();
			
			button[i].setColor(colors[i]);
		    button[i].setX(50 + (i*10));
		    button[i].setY(50 + (i*10));
		    
		    final ButtonInterfaceIvan b = button[i];
		    
		    b.dim();//off in the beginning
		    
		    button[i].setAction(new Action(){
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
		    			
		    			if(b == move.get(sequenceIndex).getButton())
							sequenceIndex++;
						else{
		    				progress.gameOver();
		    				return;
		    			}
		    			
		    			if(sequenceIndex == move.size()){
		    				Thread nextRound = new Thread(SimonScreenIvan.this);
		    				nextRound.start(); 
						}
		    			
		    		}
		    	}
		    });
		    viewObjects.add(b);
		}
	}

	private ButtonInterfaceIvan getAButton() {
		return new Button();
	}

	public ProgressInterfaceIvan getProgress() {
		return new Progress();
	}

	public MoveInterfaceIvan randomMove() {
		int rand = (int) (Math.random() * button.length);
		while (rand == prevButton)
			rand = (int) (Math.random() * button.length);
		
		prevButton = rand;
		
		return new Move(button[rand]);
	}
	
}
