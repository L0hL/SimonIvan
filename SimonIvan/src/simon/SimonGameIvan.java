package simon;

//import GUIpractice.GUIApplication;

import GUIpractice.GUIApplication;

public class SimonGameIvan extends GUIApplication{

	public SimonGameIvan() {
		//???
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		SimonGameIvan game = new SimonGameIvan();
		Thread app = new Thread(game);
		app.start();
	}
	@Override
	protected void initScreen() {
		SimonScreenIvan ssi = 
				new SimonScreenIvan(getWidth(), getHeight());
		setScreen(ssi);
		
	}

}
