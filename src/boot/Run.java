package boot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import controller.Controller;
import controller.MyController;
import model.MyModel;
import view.MyView;

public class Run {

	public static void main(String[] args) {
try {
MyView view = new MyView(new BufferedReader(new FileReader("1.txt")),new PrintWriter(new FileWriter("3.txt")));
MyModel model = new MyModel();
Controller controller = new MyController(model,view);
view.setController(controller);
model.setController(controller);
view.start();
	
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}}
