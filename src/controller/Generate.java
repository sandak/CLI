package controller;

import model.Model;
import view.View;

public class Generate implements Command {
Model model;
View view;

	public Generate(Model model, View view) {
	super();
	this.model = model;
	this.view = view;
}

	@Override
	public void doCommand(String string) {
		String[] s = string.split(" ");
		try{
		
		if (s[0].equals("3d")&&s[1].equals("maze")&&s.length>5)
		   model.generate(s[2],Integer.parseInt(s[3]),Integer.parseInt(s[4]),Integer.parseInt(s[5]));
		else
		view.display("missing parameters");
	}catch(NumberFormatException e)
		{view.display("invalid parameters");}
	}
}
