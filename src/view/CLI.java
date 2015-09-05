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
			   String buffer=in.readLine();
			    Command command = null;
			 while(!buffer.equals("exit"))
			    {
						
			    	command = commandMap.get(buffer.split(" ")[0]);
			    	if (command!=null)
			    		if (buffer.split(" ").length>1)
			    			command.doCommand(buffer.substring(buffer.indexOf(' ')+1));
			    		else out.println("missing parameters!");
			    	else
			    		out.println(buffer + " is not reconized command!");
			    	buffer = in.readLine();
			    	}
			 out.flush();
				}catch (IOException e) {
						e.printStackTrace();
					}
			    	
			    }
		
	}).start();
   
    } 
    
}
