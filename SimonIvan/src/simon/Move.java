package simon;

import simon.ButtonInterfaceIvan;
import simon.MoveInterfaceIvan;

public class Move implements MoveInterfaceIvan {

	private ButtonInterfaceIvan b;
	
	public Move(ButtonInterfaceIvan b) {
		this.b = b;
	}

	@Override
	public ButtonInterfaceIvan getButton() {
		return b;
	}

}
