package controller;

import model.Model;

public class Display implements Command {

	Model model;
	
	
	public Display(Model model) {
		super();
		this.model = model;
	}


	@Override
	public void doCommand(String name) {
		model.mazeDisplay(name);

	}

}
