package controller;

import view.View;

public class Test implements Command {

	private View view;
	public Test(View view)
	{this.view = view;}
	
	@Override
	public void doCommand(String string) {
		view.display("tested");
		
	}

}
