package model;

import java.util.HashMap;

import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.MyMaze3dGenerator;
import controller.Controller;

public class MyModel implements Model {
	Controller controller;
    HashMap<String,Maze3d> mazeMap;
	
	public MyModel(){
		mazeMap = new  HashMap<String,Maze3d>();
	}

	public Controller getController() {
		return controller;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	public void generate(String name, int i, int j, int k) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				 Maze3d tmpMaze = new MyMaze3dGenerator().generate(i, j, k);
				 mazeMap.put(name, tmpMaze);
				 controller.display(name + " maze is ready");
				
			}
		}).start();
		
	}

	@Override
	public void mazeDisplay(String name) {
		Maze3d tmp = mazeMap.get(name);
		if (tmp != null)
			controller.display(name + "\n\n" + tmp.toString());
		else
			controller.display("unaviable maze");
		
	}
	

}
