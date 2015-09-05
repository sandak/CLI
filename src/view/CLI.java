package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;

public class CLI {
	
	BufferedReader in;
    PrintWriter out;
    HashMap<String,Command> commandMap;
    
    public CLI(	BufferedReader in,PrintWriter out,HashMap<String,Command> commandMap)
    {
    	this.in=in;
        this.out=out;
        this.commandMap=commandMap;
    }
    
    public void start()
    {
 
    new Thread( new Runnable() {
		
		@Override
		public void run() {
				try {
			   String buffer=null;
			    Command command = null;
			 while(buffer!="exit")
			    {
						buffer = in.readLine();
			    	command = commandMap.get(buffer);
			    	if (command!=null)
			    		command.doCommand();
			    	else
			    		out.println(buffer + " is not reconized command!");
			    	}
				}catch (IOException e) {
						e.printStackTrace();
					}
			    	
			    }
		
	}).start();
   
    } 
    
}
