package controller;

import java.io.File;

import view.View;

public class Dir implements Command {
View view;

public Dir(View view)
{
	this.view=view;
}

	@Override
	public void doCommand(String string) {
		if (string!=null)
			view.display(new File(string).list());
		else
			view.display("missing parameters");
	}

}
