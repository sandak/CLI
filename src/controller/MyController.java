package controller;

import java.util.HashMap;

import model.Model;
import view.View;

public class MyController implements Controller {
	
	Model model;
	View view;
	HashMap<String,Command> commandMap;
	
	public MyController(Model model, View view)
	{
		this.model = model;
		this.view = view;
		commandMap = new HashMap<String,Command>();
		commandMap.put("test", new Test(view));
		commandMap.put("dir", new Dir(view));
		commandMap.put("generate", new Generate(model, view));
		commandMap.put("display", new Display(model));
		view.setCommands(commandMap);
	}

	@Override
	public void display(String string) {
		view.display(string);		
	}

}
