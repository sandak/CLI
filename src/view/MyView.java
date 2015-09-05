package view;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;
import controller.Controller;

public class MyView implements View {
	
	Controller controller;
	BufferedReader in;
    PrintWriter out;
	CLI cli;
	


	public MyView(BufferedReader in, PrintWriter out) {
		super();
		this.in = in;
		this.out = out;
	}

	@Override
	public void start() {
		cli.start();
	
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void setCommands(HashMap<String, Command> commandMap) 
	{
			cli = new CLI(in,out , commandMap);
	
	}
	@Override
	public void display(String[] string) {
		for (String s : string) {
			out.println(s);
		}
		out.flush();
	}
	
	@Override
	public void display(String string) {
       out.println(string);		
       out.flush();
	}
	

}
