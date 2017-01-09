package simonFinished;

public class Move implements MoveInterfaceIvan{

	
	public ButtonInterfaceIvan button;
	public Move(ButtonInterfaceIvan button){
		this.button = button;
	}
	@Override
	public ButtonInterfaceIvan getButton() {
		// TODO Auto-generated method stub
		return button;
	}

}
